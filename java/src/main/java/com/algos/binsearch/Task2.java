package com.algos.binsearch;

/**
 * Search in Rotated Sorted Array.
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown
 * pivot index k (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Constraints:
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -10^4 <= target <= 10^4
 */

public class Task2 {
    public int search(int[] nums, int target) {
        if(nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }


        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if ((nums[left] < nums[mid] && (target < nums[mid] && target >= nums[left])) ||
                    (nums[left] > nums[mid] && (target < nums[mid] || target >= nums[left]))) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
