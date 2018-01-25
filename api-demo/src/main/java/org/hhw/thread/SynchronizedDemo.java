package org.hhw.thread;

public class SynchronizedDemo {
    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {

        }
        test();
    }

    public static synchronized void test(){}
}
