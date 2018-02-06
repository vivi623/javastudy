package org.hhw.redis;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.CountDownLatch;

public class LimtRateDemo {
    static RateLimiter rateLimiter = RateLimiter.create(10);
    static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) {

        for(int i = 0; i < 100; i++) {
            Thread thread = new Thread(new ThreadDemo(),"demo" + i);
            thread.start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 100; i < 200; i++) {
            Thread thread = new Thread(new ThreadDemo(),"demo" + i);
            thread.start();
        }
    }

    private static class ThreadDemo implements Runnable {

        @Override
        public void run() {
           double delay = rateLimiter.acquire(1);
           System.out.println(Thread.currentThread().getName() + "获取到锁，" + delay);
            try {
                Thread.sleep(1000);
                if("demo99".equals(Thread.currentThread().getName())) {
                    countDownLatch.countDown();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
