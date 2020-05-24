package com.danny.algo.learn;

public class Solution26S1 {
    /**
     * 充分使用排序数组的特性
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length <= 1) {
            return nums.length;
        }

        int m =0, n = 1, len = nums.length;
        
        while (n < len) {
            if (nums[n] > nums[m]) {
                nums[++m] = nums[n];
            }
            n++;
        }
        return m+1;
    }
}