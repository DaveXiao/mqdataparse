package com.dorong.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dorong.utils.JSonUtil;

import javax.jms.*;
import java.util.HashMap;
import java.util.Map;

/**
 * ActiveMQ消息发送测试类 Created by GaoWanli on 2017/9/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:springContext/*.xml", "classpath*:ActiveMQ.xml" })
public class QueueSenderTest {

	@Autowired
	private JmsTemplate jmsQueueTemplate;

	@Test
	public void testData() {
		jmsQueueTemplate.send("appdata", new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {

				Map<String, String> map = new HashMap<String, String>();
				map.put("ossFileKey", "callrecords/18736297808-1508135550260");
				map.put("userCode", Integer.toString(405065));
				map.put("type", "THQD");// 分析数据类型
				map.put("authorizeDate", "2017-10-16");

				MapMessage maMessage = session.createMapMessage();
				maMessage.setString("mapMsg", JSonUtil.toJSonString(map));
				return maMessage;
			}
		});
	}
}
