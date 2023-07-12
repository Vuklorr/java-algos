package com.algos.sorting.counting;

/**
 * Sort Colors.
 * Given an array nums with n objects colored red, white, or blue,
 * sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 */

public class CountingSolution {
    public void sortColors(int[] nums) {
        final int MAX_VALUE = 3;
        int[] counting = new int [MAX_VALUE];
        for(int i : nums) {
            counting[i]++;
        }

        int index = 0;

        for(int i = 0; i < counting.length; i++) {
            int count = counting[i];
            while (count-- > 0) {
                nums[index++] = i;
            }
        }
    }

    public void sortColorsStable(int[] nums) {
        final int MAX_VALUE = 3;
        int[] counting = new int[MAX_VALUE];
        int[] out = new int[nums.length];

        for(int i : nums) {
            counting[i]++;
        }

        for(int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            out[counting[nums[i]] - 1] = nums[i];
            counting[nums[i]]--;
        }
        
        for(int i = 0; i < out.length; i++) {
            nums[i] = out[i];
        }
    }
}
