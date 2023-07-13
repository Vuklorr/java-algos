package com.algos.sorting.insertion;

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

public class InsertionSolution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        String[] sortNames = new String[names.length];

        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }

        insertionSort(heights);

        for (int i = 0; i < heights.length; i++) {
            sortNames[i] = map.get(heights[i]);
        }

        return sortNames;
    }

    private void insertionSort(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] < current) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = current;
        }
    }
}
