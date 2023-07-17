package com.algos.sorting.merge;

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

public class MergeSolution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        String[] sortNames = new String[names.length];

        for(int i = 0 ; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }

        MergeSort mergeSort = new MergeSort(heights);

        mergeSort.mergeSort(0, heights.length - 1);


        for(int i = 0; i < heights.length; i++) {
            sortNames[i] = map.get(heights[i]);
        }

        return sortNames;
    }
}
