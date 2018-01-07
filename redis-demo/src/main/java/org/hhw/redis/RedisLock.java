package org.hhw.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.UUID;

public class RedisLock {


    public String getLock(String key, int timeout) {
        try {
            Jedis jedis = RedisManager.getJedis();
            String uuid = UUID.randomUUID().toString();
            long end = System.currentTimeMillis()+timeout;
            while (System.currentTimeMillis() < end) {
                if(jedis.setnx(key, uuid) == 1) {
                    return uuid;
                }
                Thread.sleep(500);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean releaseLock(String key, String value){
        try {
            Jedis jedis = RedisManager.getJedis();
            while (true) {
                jedis.watch(key);
                if(value.equals(jedis.get(key))) { //判断获得的锁与当前redis释放的锁是同一个
                    Transaction transaction  = jedis.multi();
                    transaction.del(key);
                    List<Object> list = transaction.exec();
                    if(list == null) {
                        continue;
                    }
                    return true;
                }
                jedis.unwatch();
                break;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        RedisLock redisLock = new RedisLock();
        String key = "lock:demo1";
        String lockid = redisLock.getLock("lock:demo1", 2000);
        if(lockid != null) {
            System.out.println("获取锁成功");
        } else {
            System.out.println("失败");
        }

        String lockid2 = redisLock.getLock("lock:demo1", 2000);
        if(lockid2 != null) {
            System.out.println("获取锁成功");
        } else {
            System.out.println("失败");
        }



    }

}
