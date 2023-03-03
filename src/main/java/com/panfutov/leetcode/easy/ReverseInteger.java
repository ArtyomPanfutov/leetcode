package com.panfutov.leetcode.easy;

/**
 * 7. Reverse Integer
 *
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */
public class ReverseInteger {
    public int reverse(int x) {
        int retVal = 0;

        while(x != 0) {
            if (retVal > Integer.MAX_VALUE / 10 || retVal < Integer.MIN_VALUE / 10) {
                return 0;
            }

            retVal *= 10;
            retVal += x % 10;
            x /= 10;
        }

        return retVal;
    }
}
