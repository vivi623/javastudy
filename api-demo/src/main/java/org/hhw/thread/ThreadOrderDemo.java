package org.hhw.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadOrderDemo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("main --- before");
//        threadOrderJoin();

        threadOrderExcutor();
        System.out.println("main --- after");
    }

    private static void threadOrderExcutor() {
        //队列的最大值为Integer.MAX_VALUE,走默认拒绝策略，直接抛出异常
        //拒绝策略有4中，1. 直接抛出异常 2. 立即尝试执行超出队列的任务 3. 丢弃最新的任务  4. 丢弃最旧的数据
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 100; i++) {
            executorService.execute(new ThreadDemo("线程" + i));
        }
        executorService.shutdown();
    }

    private static void threadOrderJoin() throws InterruptedException {
        for(int i = 1; i < 100; i++) {
            Thread t1 = new Thread(new ThreadDemo(),"线程" + i);
            t1.start();
            t1.join();
        }
    }

    private static class ThreadDemo implements Runnable {
        private String name;
        public ThreadDemo(){};

        public ThreadDemo(String name){
            this.name = name;
        };
        @Override
        public void run() {
            try {
                Thread.sleep(600000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(name + ":[" + Thread.currentThread().getName() + "]:正在执行");
        }
    }

}
