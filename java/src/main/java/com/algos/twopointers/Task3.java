package com.algos.twopointers;

/**
 * Rotate Array.
 *Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^5
 */

public class Task3 {
    public void rotate(int[] nums, int k) {
        int[] out = new int[nums.length];
        k %= nums.length;

        for(int i = 0; i < nums.length; i++) {
            int j = (nums.length - k + i) % nums.length;
            out[i] = nums[j];
        }

        for(int i = 0; i < out.length; i++) {
            nums[i] = out[i];
        }
    }
}
