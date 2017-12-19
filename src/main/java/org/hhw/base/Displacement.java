package org.hhw.base;

/**
 * 位移
 */
public class Displacement {

    public static void main(String[] args) {
        int num = 5;
        System.out.println(num + "=======" + Integer.toBinaryString(num));
        int temp = num << 1;
        System.out.println(temp + "==" + Integer.toBinaryString(temp));
        temp = num << 2;
        System.out.println(temp + "==" + Integer.toBinaryString(temp));
        temp = num << 3;
        System.out.println(temp + "==" + Integer.toBinaryString(temp));
        System.out.println("==================");
        temp = num >> 1;
        System.out.println(temp + "==" + Integer.toBinaryString(temp));
        temp = num >> 2;
        System.out.println(temp + "==" + Integer.toBinaryString(temp));
        temp = num >> 3;
        System.out.println(temp + "==" + Integer.toBinaryString(temp));

        System.out.println(1 << 30);
        System.out.println(Integer.toBinaryString(1073741824));
    }
}
