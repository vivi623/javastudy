package org.hhw.effective;

/**
 * Created by houhongwei on 2017/12/20.
 */
public class NocreateObject {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

//        System.out.println(getLongSum());
        System.out.println(getlongSum());

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static Long getLongSum() {
        Long sum = 0l;
        for(long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    public static long getlongSum() {
        long sum = 0l;
        for(long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }
}
