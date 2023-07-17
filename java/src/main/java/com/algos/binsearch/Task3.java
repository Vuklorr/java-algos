package com.algos.binsearch;

/**
 * Find First and Last Position of Element in Sorted Array.
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Constraints:
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */

public class Task3 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[]{-1, -1};
        }

        int leftIndex = leftBinSearch(nums, target);
        int rightIndex = rightBinSearch(nums, target);

        return new int[] {leftIndex, rightIndex};
    }

    private int leftBinSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;

           if(nums[mid] < target) {
                left = mid + 1;
           } else {
                right = mid;
           }
        }

        return nums[left] == target ? left : -1;
    }

    private int rightBinSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left + 1) / 2;

            if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return nums[right] == target ? right : -1;
    }
}
