package com.danny.algo.learn;

public class PlusOneSolution {
    public int[] plusOne(int[] digits) {
        int[] nums = new int[digits.length + 1];
        System.arraycopy(digits, 0, nums, 1, digits.length);
        nums[0] = 0;
        int p = nums.length -1;
        int increment = 0;
        while (p >= 0) {
            int num = 0;
            if (p == nums.length - 1) {
                num = (nums[p] + 1 + increment)%10;
                increment = (nums[p] + 1 + increment)/10;
            } else {
                num = (nums[p] + 0 + increment)%10;
                increment = (nums[p] + 0 + increment)/10;
            }
            nums[p--] = num;
        }
        if(nums[0] == 0) {
            int[] temp = new int[nums.length -1];
            System.arraycopy(nums, 1, temp, 0, nums.length -1);
            return temp;
        }
        return nums;
    }
}