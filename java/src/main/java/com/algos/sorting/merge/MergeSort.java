package com.algos.sorting.merge;

public class MergeSort {
    private final int[] nums;

    public MergeSort (int[] nums) {
        this.nums = nums;
    }

    public void mergeSort(int start, int end) {
        if(start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);

            merge(start, mid, end);
        }
    }

    private void merge(int start, int mid, int end) {
        int leftSize = mid - start + 1;
        int rightSize = end - mid;

        //не знаю, как реализоавть без использования этих массивов
        int[] leftNums = new int[leftSize];
        int[] rightNums = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftNums[i] = nums[start + i];
        }

        for (int j = 0; j < rightSize; j++) {
            rightNums[j] = nums[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = start;

        while (i < leftSize && j < rightSize) {
            if (leftNums[i] <= rightNums[j]) {
                nums[k++] = rightNums[j++];
            } else {
                nums[k++] = leftNums[i++];
            }
        }

        while (i < leftSize) {
            nums[k++] = leftNums[i++];
        }

        while (j < rightSize) {
            nums[k++] = rightNums[j++];
        }
    }
}
