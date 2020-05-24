package com.danny.algo.learn;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-1, q = n-1, s = m + n -1;
        while (p >= 0 && q >= 0) {
            nums1[s--] = nums1[p] >  nums2[q] ? nums1[p--] : nums2[q--];
        }
        //如果B还有剩下的没排完，则全部放到前面去
        while (q >= 0) {
            nums1[s--] = nums2[q--];
        }
    }
}