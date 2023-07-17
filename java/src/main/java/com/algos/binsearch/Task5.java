package com.algos.binsearch;

/**
 * Sqrt(x).
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *
 * Constraints:
 * 0 <= x <= 231 - 1
 */

public class Task5 {
    public int mySqrt(int x) {
        if(x == 1) {
            return 1;
        }

        long left = 0;
        long right = x;
        long ans = 0;

        while(left < right)
        {
            long mid = left + (right - left) / 2;

            if(mid * mid == x) {
                return (int)mid;
            }

            if(mid * mid < x) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid;
            }
        }
        return (int)ans;
    }
}
