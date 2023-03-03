package com.panfutov.leetcode.easy;

/**
 * 172. Factorial Trailing Zeroes
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Follow up: Could you write a solution that works in logarithmic time complexity?
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int retVal = 0;

        for (int i = 5; n / i >= 1; i*=5) {
            retVal += n / i;
        }

        return retVal;
    }
}
