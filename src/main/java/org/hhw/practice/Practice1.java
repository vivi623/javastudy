package org.hhw.practice;

/**
 *  有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 *  这个需要列
 */
public class Practice1 {
    public static void main(String[] args) {
        for(int i = 1; i <=12; i++) {
            System.out.println("第" + i + "个月，兔子的总对数：" + getRebitSum(i));
        }
    }

    /**
     * 获取兔子的总数，试着用递归的方法写下
     * 其实就是2^(n-1)
     * @param n 月数
     */
    public static int getRebitSum(int n) {
        if(n <= 2) {
            return 1;
        }
        return getRebitSum(n-1) + getRebitSum(n-3);
    }

}
