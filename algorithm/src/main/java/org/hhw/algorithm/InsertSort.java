package org.hhw.algorithm;

import java.util.Arrays;

/**
 * 插入排序
 * 基本思想：在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。
 * 如此反复循环，直到全部排好顺序。
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {49, 38, 65, 97, 76, 13, 27, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35};
        sort(array);
//        shellSort(array);
    }


    /**
     * 直接插入排序
     * 基本思想：在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。
     * 如此反复循环，直到全部排好顺序。
     * @param array
     */
    public static void sort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int temp = array[i];
            for(int j = i-1; j>=0 && array[j] > temp; j--) {
                array[j+1] = array[j];
                array[j] = temp;
            }
            System.out.println(i + ": " + Arrays.toString(array) );
        }
    }

    /**
     * 希尔排序
     * 基本思想：其实是直接插入排序的改进版，直接排序可以理解为步调是1的希尔排序
     * @param array
     */
    public static void shellSort(int[] array) {
        int gap = array.length/2;

        do {
            for(int i = gap; i < array.length; i=i+gap) {
                int temp = array[i];
                for(int j = i-gap; j>=0 && array[j] > temp; j=j-gap) {
                    array[j+gap] = array[j];
                    array[j] = temp;
                }
                System.out.println(i + ": " + Arrays.toString(array) );
            }
            gap = gap/2;
        } while (gap > 0);

    }

}
