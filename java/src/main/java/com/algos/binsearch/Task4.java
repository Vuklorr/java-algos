package com.algos.binsearch;

/**
 * Search a 2D Matrix.
 * You are given an m x n integer matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 */

public class Task4 {

    public boolean searchMatrixBeanSearch(int[][] matrix, int target) { // O(log(m * n))
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;

        while(up < down) {
            int midColumn = up + (down - up) / 2;

            if(matrix[midColumn][right] == target) {
                return true;
            }

            if(matrix[midColumn][right] < target) {
                up = midColumn + 1;
            } else {
                down = midColumn;
            }
        }

        while(left < right) {
            int midRow = left + (right - left) / 2;

            if(matrix[up][midRow] == target) {
                return true;
            }

            if(matrix[up][midRow] < target) {
                left = midRow + 1;
            } else {
                right = midRow;
            }
        }

        return matrix[up][left] == target;
    }

    public boolean searchMatrixDiagonal(int[][] matrix, int target) { // O(m + n)
        int i = 0;
        int j = matrix[0].length - 1;

        while(i < matrix.length && j >= 0) {
            if(matrix[i][j] == target) {
                return true;
            }

            if(matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }

        }
        return false;
    }
}
