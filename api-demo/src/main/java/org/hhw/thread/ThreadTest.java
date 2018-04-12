package org.hhw.thread;

public class ThreadTest implements Runnable {
    private volatile boolean flag;
    private String name;

    ThreadTest(String name, boolean flag) {
        this.name = name;
        this.flag = flag;
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTest("A", true));
        Thread thread2 = new Thread(new ThreadTest("B", false));
        thread.start();
        thread2.start();

    }

    @Override
    public void run() {
        synchronized (ThreadTest.class) {
            for(int i = 0; i < 100; i++) {
                if(flag) {
                    System.out.println(name + ":" + i);
                    flag = false;
                }
            }
        }
    }
}
