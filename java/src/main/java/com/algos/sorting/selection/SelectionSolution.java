package com.algos.sorting.selection;

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

public class SelectionSolution {
    public void sortColors(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int minValue = nums[i];
            int minIndex = i;

            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] < minValue) {
                    minValue = nums[j];
                    minIndex = j;
                }
            }

            nums[minIndex] = nums[i];
            nums[i] = minValue;
        }
    }
}
