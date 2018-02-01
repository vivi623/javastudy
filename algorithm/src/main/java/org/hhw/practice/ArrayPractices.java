package org.hhw.practice;

import java.util.*;

public class ArrayPractices {
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
    public int removeDuplicates(int[] nums) {
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

    /**
     * Rotate an array of n elements to the right by k steps.
     * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     *  如果数组中有重复的数据返回ture，没有重复的返货false
     *  时间复杂度O(n),空间复杂度O(n),
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < length; i++) {
            int temp = nums[i];
            if(set.contains(temp)) {
                return true;
            }
            set.add(temp);
        }
        return false;
    }

    /**
     * 给定一个数组，数组中只有一个元素出现一次，其余元素都出现2次，返回出现一次的元素
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        if (nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i]; //异或操作，相同位返回0，不同位返回1，所以最后返回的一定是出现一次的那个元素
        }
        return res;
    }

    public int singleNumber2(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return Integer.MIN_VALUE;
        }
        if(len == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        for(int i = 0; i < len; i++) {
            if(i == len -1) {
                return nums[i];
            }
            if(nums[i] != nums[i+1]) {
                return nums[i];
            }
            i++;
        }
        return Integer.MIN_VALUE;
    }

    /**
     * 求两个数组的交集
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int k = 0;
        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                ans[k] = nums1[i];
                i++;
                j++;
                k++;
            } else if (nums1[i] < nums2[j]) {
                while (i < nums1.length && nums1[i] < nums2[j]){
                    i++;
                }
            } else {
                while (j < nums2.length && nums1[i] > nums2[j]) {
                    j++;
                }
            }
        }

        return Arrays.copyOf(ans, k);
    }

    public int[] intersect2(int[] nums1, int[] nums2) {

        if(nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Queue<Integer> queue1 = new LinkedList<>();
        queue1.addAll(caseIntsToList(nums1));
        Queue<Integer> queue2 = new LinkedList<>();
        queue2.addAll(caseIntsToList(nums2));

        List<Integer> list = new ArrayList<>();
        Integer temp1 = queue1.poll();;
        Integer temp2 = queue2.poll();
        while (true) {
            if(temp1 == null || temp2 == null) {
                break;
            }
            if(temp1.compareTo(temp2) == 0) {
                list.add(temp1);
                temp1 = queue1.poll();
                temp2 = queue2.poll();
            } else if(temp1.compareTo(temp2) < 0) {
                temp1 = queue1.poll();
            } else {
                temp2 = queue2.poll();
            }
        }
        if(list.isEmpty()) {
            return new int[0];
        }

        Integer[] nums = list.toArray(new Integer[list.size()]);

        return caseIntegerToInt(nums);
    }

    private List<Integer> caseIntsToList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <nums.length; i++) {
            list.add(nums[i]);
        }
        return list;
    }

    private int[] caseIntegerToInt(Integer[] nums) {
        int[] rtns = new int[nums.length];
        for(int i = 0; i < nums.length; i ++) {
            rtns[i] = nums[i];
        }
        return rtns;
    }


    /**
     * digits 是由一个数字（非负整数）组成的数组，给这个数字加1，返回加后的数组
     * 例如：1089 + 1 = 1090 -->  digits = {1,0,8,9} + 1 = {1,0,9,0}
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }

    /**
     * 把数组中的0移动到最后，并不改变非0数据的顺序
     * @param nums
     */
    public void moveZeroes(int[] nums) {

        int count = 0;
        int length = nums.length;
        for(int i = 0; i < length; i++) {
            int tmp = nums[i];
            if(tmp == 0) {
                count++;
                continue;
            }

            if(count > 0) {
                nums[i-count] = tmp;
            }

        }

        for(int i = 0; i < count; i++) {
            nums[length-1-i] = 0;
        }

    }

    /**
     * 给定数组，取出两个数相加等于target的位置，默认一个数组中只能有一个组合相加等于target
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {

            if(map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            } else {
                map.put(nums[i], i);
            }

        }

        return null;
    }

}
