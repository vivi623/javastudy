package org.hhw.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo {

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(0);
        int i = integer.addAndGet(5);
        System.out.println(i);
        System.out.println(integer.get());

//        Integer[] a = {1,2,3,4,5,6,7,8,9};
//
//        List<Integer> list = Arrays.asList(a);
//
//        for (int i = 0; i < 10; i += 2) {
//            System.out.println(list.get(i));
//        }
    }
}
