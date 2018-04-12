package org.hhw.base;

/**
 * 异或运算：两个值异或就是将两个值改为二进制，相同的位=0，不同的位=1
 * 如 101^100 = 001
 */
public class XorDemo {
    public static void main(String[] args) {
        String key = "skuid";
        int h = 0;
        h ^= key.hashCode();
        System.out.println(h + "==" + Integer.toBinaryString(h));
        int temp1 = h >>> 20;
        System.out.println("h >>> 20:"  + Integer.toBinaryString(temp1));
        int temp2 = h >>> 12;
        System.out.println("h >>> 12:"+ Integer.toBinaryString(temp2));


        System.out.println("(h >>> 20) ^ (h >>> 12):" + Integer.toBinaryString(temp1^temp2));
        System.out.println("h^(h >>> 20) ^ (h >>> 12):" + Integer.toBinaryString(h^(temp1^temp2)));

        h ^= (h >>> 20) ^ (h >>> 12);



        System.out.println("h >>> 7:" + Integer.toBinaryString(h^(h>>>7)^(h>>>4)));

        int hash = hash(key);
        System.out.println("hash：" + hash);
        int i = indexFor(hash, 16);
        System.out.println("i：" + i);
    }

    static int hash(Object k) {
        int h = 0;
//        if (0 != h && k instanceof String) {
//            return sun.misc.Hashing.stringHash32((String) k);
//        }

        h ^= k.hashCode();

        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    static int indexFor(int h, int length) {
        // assert Integer.bitCount(length) == 1 : "length must be a non-zero power of 2";
        return h & (length-1);
    }
}
