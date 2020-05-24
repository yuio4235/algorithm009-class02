package com.danny.algo.learn;

public class Solution26 {
    /**
     * 当做是删除0的issue,重复的就是0项
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

        int m = 0, n=1, len = nums.length;
        
        for (int i=0; i<len; i++) {
            if (nums[m] != nums[i]) {
                nums[++m] = nums[i];
            }
        }
        return m + 1;
    }
}