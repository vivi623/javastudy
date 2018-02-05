package org.hhw.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 分布式锁
 */
public class RedisManager {
    private static JedisPool jedisPool;
    private static String HOST = "192.168.174.130";
    private static int PORT = 6379;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPool = new JedisPool(jedisPoolConfig, HOST, PORT);
    }

    public static Jedis getJedis() throws Exception {
        if(jedisPool != null) {
            return jedisPool.getResource();
        }
        throw new Exception("jedisPool was not init");
    }

}
