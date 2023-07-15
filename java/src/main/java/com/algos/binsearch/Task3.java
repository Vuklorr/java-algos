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
        int targetIndex = binSearch(nums, target);

        if(targetIndex == -1) {
            return new int[]{-1, -1};
        }

        int i = targetIndex;
        int j = targetIndex + 1;

        while(i >= 0 && nums[i] == target) {
            i--;
        }
        while(j < nums.length && nums[j] == target) {
            j++;
        }

        return new int[] {++i, --j};

    }

    private int binSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while(left <= right) {
            mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
