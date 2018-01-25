package org.hhw.base;

import java.lang.reflect.Field;

public class IntegerDemo {
    public static void main(String[] args) {
        int i = 16;
        System.out.println("Number = " + i);

        /* returns the string representation of the unsigned integer value represented by the argument in binary (base 2) */
        System.out.println("Binary = " + Integer.toBinaryString(i));

        // returns the number of one-bits
        System.out.println("Number of one bits = " + Integer.bitCount(i));

        /* returns an int value with at most a single one-bit, in the position of the highest-order ("leftmost") one-bit in the specified int value */
        System.out.println("Highest one bit = " + Integer.highestOneBit(i));

        Integer m = 1;
        Integer n = 2; //valueOf 方法中有缓存，缓存的范围是-128~127

        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            Integer tmp = new Integer(m.intValue());
            field.set(m, n.intValue());
            field.set(n, tmp);
            System.out.println(m + "===" + n );
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
