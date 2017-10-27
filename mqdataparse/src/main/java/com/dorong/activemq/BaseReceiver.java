package com.dorong.activemq;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQMapMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dorong.mapper.localdata.EventAbstract;
import com.dorong.model.log.AnalysisLogBase;
import com.dorong.util.redis.RedisCacheUtil;
import com.dorong.utils.JSonUtil;
import com.dorong.utils.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

/**
 * MQ解析处理抽象 Created by GaoWanli on 2017/9/12.
 */
public abstract class BaseReceiver implements MessageListener {
	private static Logger logger = LoggerFactory.getLogger(BaseReceiver.class);

	private EventAbstract<? super String, ? extends AnalysisLogBase> handler;

	private static ExecutorService threadPool = new ThreadPoolExecutor(15, 25, 10L, TimeUnit.SECONDS,
			new LinkedBlockingQueue<Runnable>(30),new ThreadFactory(){

		private final AtomicInteger threadNumber = new AtomicInteger(1);//线程数量

		public Thread newThread(Runnable r) {
			Thread thread = new Thread(r, "ActiveMQ处理线程-"+threadNumber.getAndIncrement());
			thread.setDaemon(true);	//设置线程为后台线程，防止tomcat无法关闭
			return thread;
		}
	});


	private RedisCacheUtil redisUtil;

	protected void setHandler(EventAbstract<? super String, ? extends AnalysisLogBase> handler) {
		this.handler = handler;
	}

	/**
	 * mq消息调度类，负责
	 *
	 * @param message
	 *            待处理的消息
	 */
	protected void doReceve(Message message) {
		final ActiveMQMapMessage mqMapMessage = (ActiveMQMapMessage) message;
		while (true) {
			try {
				threadPool.execute(new Runnable() {
					public void run() {
						try {
							String mapMsg = mqMapMessage.getString("mapMsg");
							logger.debug("MQ参数：{} 长度：{}", mapMsg, mapMsg.length());
							sendOssFiletoRedis(mapMsg);
						} catch (JMSException e) {
							logger.error("产生异常：", e);
						} catch (Exception ex) {
							// MQ处理所有异常
							logger.error("业务错误：", ex);
						}
					}
				});
				break;
			} catch (RejectedExecutionException e) {
				try {
					Thread.sleep(5000L);// 等待5秒继续添加任务
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	protected abstract String beforeHandle(String mapMsg);

	/**
	 * 解析OSS文件
	 * 
	 * @param metaData
	 * @param ossFileKey
	 * @return
	 */
	protected abstract String parseOssComment(Map<String, Object> metaData, String ossFileKey);

	/**
	 * 推送数据到redis
	 * 
	 * @param mapMsg
	 */
	private void sendOssFiletoRedis(String mapMsg) {
		try {
			Map<String, String> hash_mapMsg = JSonUtil.toHashMap(mapMsg);

			String ossFileKey = hash_mapMsg.get("ossFileKey");
			String userCode = hash_mapMsg.get("userCode");
			String type = hash_mapMsg.get("type");
			String authorizeDate = hash_mapMsg.get("authorizeDate");

			if (StringUtil.isEmpty(ossFileKey)) {
				logger.info("ossFilekey 为空" + userCode);
				return;
			}
			logger.debug("MQ参数：{} 长度：{}", ossFileKey, ossFileKey.length());
			// 定义传入参数
			Map<String, Object> metaData = new HashMap<String, Object>();

			metaData.put("ossFielKey", ossFileKey);
			metaData.put("userCode", userCode);
			metaData.put("data_type", type);
			metaData.put("authorizeDate", authorizeDate);

			String doc_type = parseOssComment(metaData, ossFileKey);

			// doc_type对应ES表名
			metaData.put("doc_type", doc_type);

			// 将数据转换成JSON格式输出
			String str_metaData = JSonUtil.toJSonString(metaData);

			// 将数据推送到redis队列
			logger.info("将数据推送到redis队列" + userCode + "  " + ossFileKey);
			if (StringUtil.isEmpty(doc_type)) {
				logger.info("doc_type 为空" + userCode);
			} else {
				logger.info("doc_type参数：{}",doc_type);
				redisUtil.lpush("jielema_" + doc_type, str_metaData);
				logger.info("str_metaData参数：{}",str_metaData);
			}
		} catch (Exception e) {
			logger.info("将数据推送到redis队列异常  " + e.getMessage());
		}

	}

	@Autowired @Lazy
	public void setRedisUtil(RedisCacheUtil redisUtil) {
		this.redisUtil = redisUtil;
	}
}
