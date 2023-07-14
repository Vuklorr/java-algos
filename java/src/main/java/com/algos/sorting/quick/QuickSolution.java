package com.algos.sorting.quick;

/**
 * Merge Sorted Array.
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function,
 * but instead be stored inside the array nums1. To accommodate this,
 * nums1 has a length of m + n, where the first m elements denote the elements
 * that should be merged, and the last n elements are set to 0 and should be ignored.
 * nums2 has a length of n.
 *
 * Constraints:
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 */

public class QuickSolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for(int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[j++];
        }
        quickSort(nums1, 0 , nums1.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if(nums.length == 0) {
            return;
        }

        if(start >= end) {
            return;
        }

        int indexSupport = (start + end) / 2;
        int valueSupport = nums[indexSupport];

        int left = start;
        int right = end;

        while (left <= right) {
            while (nums[left] < valueSupport) {
                left++;
            }

            while (nums[right] > valueSupport) {
                right--;
            }

            if(left <= right) {
                int temp = nums[left];
                nums[left++] = nums[right];
                nums[right--] = temp;
            }
        }

        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }
}

