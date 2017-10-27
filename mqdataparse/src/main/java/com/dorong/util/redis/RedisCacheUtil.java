package com.dorong.util.redis;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * 
 * @author xiaoxiong	2017/10/26
 *
 */
@Service("RedisCacheUtil")
public class RedisCacheUtil {

	private static Log logger = LogFactory.getLog(RedisCacheUtil.class);
	@Autowired
	private ShardedJedisPool shardedJedisPool;

	public void set(String key, String value) {

		ShardedJedis jedis = null;
		// 从连接池获取连接
		try {
			jedis = shardedJedisPool.getResource();
			jedis.set(key, value);
		} catch (Exception e) {
			logger.error(e);
		} finally {
			// 归还连接到redis池中
			shardedJedisPool.returnBrokenResource(jedis);
		}

	}

	public String get(@RequestParam("key") String key) {
		ShardedJedis jedis = null;
		String name = "";
		// 从连接池获取连接
		try {
			jedis = shardedJedisPool.getResource();
			name = jedis.get(key);
		} catch (Exception e) {
			logger.error(e);
		} finally {
			// 归还连接到redis池中
			shardedJedisPool.returnBrokenResource(jedis);
		}

		return name;

	}

	public void hset(String key, String field, String value) {
		if (StringUtils.isEmpty(key) || "A97B5923-F208-47CE-A4AA-0672F1A239BA".equals(key)
				|| "861262035544992".equals(key) || key.startsWith("00000") || "9999".equals(key)) {
			return;
		}
		ShardedJedis jedis = null;
		// 从连接池获取连接
		try {
			jedis = shardedJedisPool.getResource();
			jedis.hset(key, field, value);
		} catch (Exception e) {
			logger.error(e);
		} finally {
			// 归还连接到redis池中
			shardedJedisPool.returnBrokenResource(jedis);
		}

	}

	public String hget(@RequestParam("key") String key, @RequestParam("field") String field) throws Exception {
		ShardedJedis jedis = null;
		String status = "";
		// 从连接池获取连接
		try {
			jedis = shardedJedisPool.getResource();
			status = jedis.hget(key, field);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		} finally {
			// 归还连接到redis池中
			shardedJedisPool.returnBrokenResource(jedis);
		}

		return status;
	}

	public Map<String, String> hgetAll(@RequestParam("key") String key) {
		ShardedJedis jedis = null;
		Map<String, String> name = new HashMap<String, String>();
		// 从连接池获取连接
		try {
			jedis = shardedJedisPool.getResource();
			name = jedis.hgetAll(key);
		} catch (Exception e) {
			logger.error(e);
		} finally {
			// 归还连接到redis池中
			shardedJedisPool.returnBrokenResource(jedis);
		}

		return name;
	}

	/**
	 * 将数据推送到redis队列
	 * 
	 * @param key
	 * @param field
	 */
	public void lpush(String key, String field) {
		ShardedJedis jedis = null;
		try {
			jedis = shardedJedisPool.getResource();
			jedis.lpush(key, field);
		} catch (Exception e) {
			logger.error(e);
		} finally {
			shardedJedisPool.returnBrokenResource(jedis);
		}
	}

}
