package org.hhw.base;

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

    }
}
