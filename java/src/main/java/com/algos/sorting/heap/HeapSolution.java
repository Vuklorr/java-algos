package com.algos.sorting.heap;

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

public class HeapSolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for(int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[j++];
        }
        heapSort(nums1);
    }

    private void heapSort(int[] nums) {
        for(int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            heapify(nums, i, 0);
        }
    }

    private void heapify(int[] nums, int len, int root) {
        int max = root;
        int l = 2 * root + 1;
        int r = 2 * root + 2;

        if(l < len && nums[l] > nums[max]) {
            max = l;
        }

        if(r < len && nums[r] > nums[max]) {
            max = r;
        }

        if(max != root) {
            int temp = nums[root];
            nums[root] = nums[max];
            nums[max] = temp;
            heapify(nums, len, max);
        }
    }
}
