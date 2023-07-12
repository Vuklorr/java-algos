package com.algos.sorting.selection;

public class Solution {
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
