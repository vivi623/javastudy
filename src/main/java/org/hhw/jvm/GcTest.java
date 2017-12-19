package org.hhw.jvm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GcTest implements Runnable {
    private List<String> list;
    private CountDownLatch latch;
    private String name;

    GcTest(CountDownLatch latch, List<String> list, String name){
        this.latch = latch;
        this.list = list;
        this.name = name;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        CountDownLatch mylatch = new CountDownLatch(5);
        List<String> mylist = Collections.synchronizedList(new ArrayList<String>());
//        List<String> mylist = new ArrayList<>();
        long start = System.currentTimeMillis();
        for(int i = 0; i < 5; i++) {
            GcTest gcTest = new GcTest(mylatch, mylist, i+"");
            executor.execute(gcTest);
        }

        try {
            mylatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(mylist.toString());
        executor.shutdown();

    }

    public void run() {
        for(int i = 0; i < 100; i++) {
            list.add(name + ":" + i);
        }

        latch.countDown();
    }
}
