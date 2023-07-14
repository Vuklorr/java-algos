package com.algos.sorting.bucket;

import java.util.ArrayList;
import java.util.Collections;

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

public class BucketSolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for(int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[j++];
        }
        bucketSort(nums1);
    }

    private void bucketSort(int[] nums) {
        int bucketSize = nums.length;
        if (nums.length == 0) {
            return;
        }

        int minValue = nums[0];
        int maxValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minValue) {
                minValue = nums[i];
            } else if (nums[i] > maxValue) {
                maxValue = nums[i];
            }
        }

        int numBuckets = (maxValue - minValue) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int num : nums) {
            int bucketIndex = (num - minValue) / bucketSize;
            buckets.get(bucketIndex).add(num);
        }


        for (int i = 0; i < numBuckets; i++) {
            Collections.sort(buckets.get(i));
        }

        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int value : bucket) {
                nums[index++] = value;
            }
        }
    }

}
