package org.hhw.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.UUID;

/**
 * 分布式锁
 */
public class RedisLock {

    /**
     * 锁定key，如果未拿到锁停留500毫秒后重新获取锁
     * @param key 锁定的字符串
     * @param timeout 超时时间，单位毫秒
     * @return key的唯一标识用于解锁
     */
    public static String getLock(String key, int timeout) {
        try {
            Jedis jedis = RedisManager.getJedis();
            String uuid = UUID.randomUUID().toString();
            long end = System.currentTimeMillis()+timeout;
            while (System.currentTimeMillis() < end) {
                if(jedis.setnx(key, uuid) == 1) {
                    jedis.expire(key, timeout/1000);
                    return uuid;
                }

                if (jedis.ttl(key) == -1) {
                    jedis.expire(key, timeout);
                }

                Thread.sleep(500);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 按key和唯一标识进行解锁，如果
     * @param key
     * @param value
     * @return
     */
    public static boolean releaseLock(String key, String value){
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
        for(int i = 0; i < 10; i ++) {
            Thread thread = new Thread(new ThreadDemo(), "test" + i);
            thread.start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 10; i < 20; i ++) {
            Thread thread = new Thread(new ThreadDemo(), "test" + i);
            thread.start();
        }




    }

    private static class ThreadDemo implements Runnable {

        @Override
        public void run() {
            String key = "lock:demo1";
            String lockid = RedisLock.getLock(key, 5000);

            System.out.println("[" + Thread.currentThread().getName() + "]获取到锁, uuid=" + lockid);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(lockid != null) {
                boolean flag = RedisLock.releaseLock(key, lockid);
                System.out.println("[" + Thread.currentThread().getName() + "]释放锁" + flag);
            }

        }
    }

}
