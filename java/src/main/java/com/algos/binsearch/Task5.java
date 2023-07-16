package com.algos.binsearch;

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
