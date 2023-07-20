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
        k %= nums.length;
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }

    private void swap(int[] nums, int l, int r) {
        while(l < r) {
            int temp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = temp;
        }
    }
}
