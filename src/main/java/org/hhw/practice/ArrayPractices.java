package org.hhw.practice;

public class ArrayPractices {
    public static void main(String[] args) {
        int[] nums = {1,2,1,1};
        int len = removeDuplicates(nums);
        System.out.println();
        System.out.println(len);

    }

    /**
     *  Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
     *  Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     *  Example:
     *      Given nums = [1,1,2],
     *      Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
     *      It doesn't matter what you leave beyond the new length.
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len <= 1) {
            return len;
        }

        int index = 1;                    // 记录当前的新的数组的长度
        for (int i = 1; i < len; i++){
            if (nums[i] != nums[i - 1]){
                nums[index] = nums[i];    //将新的元素装到前len个
                index++;
            }
        }
        return index;
    }


}
