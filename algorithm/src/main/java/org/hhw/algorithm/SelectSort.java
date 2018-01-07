package org.hhw.algorithm;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = new int[]{2,5,4,7,1,6,8,3};
//        int[] array = {49, 38, 65, 97, 76, 13, 27, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 15, 35};

        System.out.println( ": " + Arrays.toString(array) );
        quick_sort(array, 0, array.length-1);
//        select_sort(array);
    }

    /**
     * 选择排序
     * 基本思想：首先在未排序序列中找到最小元素，存放到排序序列的起始位置，再从剩余未排序元素中继续寻找最小元素，然后放到已排序序列的末尾。
     * @param array
     */
    public static void select_sort(int[] array) {
        int len = array.length;

        for(int i = 0; i < len-1; i ++) {
            int min = i;
            for(int j = i +1; j < len; j++) {
                if(array[min] > array[j]) {
                    min = j;
                }
            }

            if (min != i) {
                swap(array, i, min);
            }
            System.out.println(i + ": " + Arrays.toString(array) );
        }

    }

    /**
     * 快速排序
     * @param array
     */
    public static void quick_sort(int[] array, int start, int end) {
        int left = start;
        int right = end;
        int base = array[left];
        while(right > left) { //base从0开始，先从最后开始比较
            if(array[right] < base) {
                array[left] = array[right];
                break;
            } else {
                right--;
            }
        }
        while (left < right) {
            if(array[left + 1] > base) {
                array[right] = array[left];
                break;
            } else {
                left++;
            }
        }

        array[left] = base;
        if(left >= right) {
            return;
        }

        System.out.println( ": " + Arrays.toString(array) );

        quick_sort(array, start, left);
        quick_sort(array, left + 1 , end);

    }

    /**
     * array[m]与array[n]值交换
     * @param array
     * @param m
     * @param n
     */
    public  static void swap(int[] array, int m, int n) {
        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }
}
