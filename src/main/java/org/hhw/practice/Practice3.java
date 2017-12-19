package org.hhw.practice;

/**
 *  打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身
 *  153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方
 */
public class Practice3 {
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        for(int i = 100; i <1000; i++) {
           if(isFlower(i)) {
               System.out.println(i);
           }
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);

        System.out.println("===============");
        long start2 = System.currentTimeMillis();
        for(int i = 100; i <1000; i++) {
            if(isFlower2(i)) {
                System.out.println(i);
            }
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2-start2);

    }

    public static boolean isFlower(int n) {
        char[] array = String.valueOf(n).toCharArray();
        int sum = 0;
        for(char achar : array) {
            int chari = Integer.valueOf(String.valueOf(achar));
            sum += (int)Math.pow(chari, 3);
        }
        if(n == sum) {
            return true;
        }
        return false;
    }

    public static boolean isFlower2(int n) {
        int gw = n%10; //个位
        int sw = (n-gw)/10%10; //十位
        int bw = (n-gw-sw*10)/100; //百位

        int sum = gw*gw*gw + sw*sw*sw + bw*bw*bw;
        if(n == sum) {
            return true;
        }
        return false;
    }
}
