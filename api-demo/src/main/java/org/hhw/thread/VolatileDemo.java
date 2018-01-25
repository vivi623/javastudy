package org.hhw.thread;

import java.lang.reflect.Field;

public class VolatileDemo {

    public static void main(String[] args) {
        int i = 0;
        int j = 1;
        i += j;
    }
}
