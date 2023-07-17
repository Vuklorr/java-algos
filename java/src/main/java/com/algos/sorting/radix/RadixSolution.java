package com.algos.sorting.radix;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array of strings names, and an array heights
 * that consists of distinct positive integers. Both arrays are of length n.
 *
 * For each index i, names[i] and heights[i] denote the name and height of the ith person.
 *
 * Return names sorted in descending order by the people's heights.
 *
 * Constraints:
 * n == names.length == heights.length
 * 1 <= n <= 10^3
 * 1 <= names[i].length <= 20
 * 1 <= heights[i] <= 10^5
 * names[i] consists of lower and upper case English letters.
 * All the values of heights are distinct.
 */

public class RadixSolution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        String[] sortNames = new String[names.length];

        for(int i = 0 ; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }

        radixSort(heights);

        for(int i = 0; i < heights.length; i++) {
            sortNames[i] = map.get(heights[i]);
        }

        return sortNames;
    }

    private void radixSort(int[] nums) {
        int max = getMax(nums);

        for(int i = 1; max / i > 0; i *= 10) {
            countingSort(nums, i);
        }
    }

    private int getMax(int[] nums) {
        int max = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }

    private void countingSort(int[] nums, int total) {
        final int MAX_VALUE = 0b1010;
        int[] counting = new int[MAX_VALUE];
        int[] out = new int[nums.length];

        for(int i : nums) {
            //i = 123, total = 1 => digital = (123 / 1) % 10 = 3;
            //i = 123, total = 10 => digital = (123 / 10) % 10 = 2;
            int digit = (i / total) % 10;
            counting[digit]++;
        }

        for(int i = counting.length - 2; i >= 0; i--) {
            counting[i] += counting[i + 1];
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            //i = 123, total = 1 => digital = (123 / 1) % 10 = 3;
            //out[counting[3] - 1] = 123;
            //i = 123, total = 10 => digital = (123 / 10) % 10 = 2;
            int digit = (nums[i] / total) % 10;
            out[counting[digit] - 1] = nums[i];
            counting[digit]--;
        }

        for(int i = 0; i < out.length; i++) {
            nums[i] = out[i];
        }
    }
}
