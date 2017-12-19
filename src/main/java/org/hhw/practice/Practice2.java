package org.hhw.practice;

/**
 *  判断101-200之间有多少个素数，并输出所有素数。
 *  素数又叫质数，就是除了1和它本身之外，再也没有整数能被它整除的数。也就是素数只有两个因子。
 */
public class Practice2 {
    public static void main(String[] args) {
        getSushu(101, 200);
    }

    public static void getSushu(int min, int max) {
        int sum = 0;
        for(int i = min; i <= max; i++) {
            boolean isSushu = true;
            int mod = i%2;
            if(mod == 0) { //先把偶数排除掉
                continue;
            } else {
                int lengh = (int) Math.sqrt(new Double(i));
                for(int j = 3; j <=lengh; j++) {
                    int mod2 = i%j;
                    if(mod2 == 0) {
                        isSushu = false;
                        break;
                    }
                }
                if(isSushu) {
                    sum++;
                    System.out.println(i);
                }
            }
        }
        System.out.println("共" + sum + "个素数");
    }
}
