package com.panfutov.leetcode.easy;

/**
 * 326. Power of Three
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 *
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 27
 * Output: true
 * Example 2:
 *
 * Input: n = 0
 * Output: false
 * Example 3:
 *
 * Input: n = 9
 * Output: true
 * Example 4:
 *
 * Input: n = 45
 * Output: false
 *
 *
 * Constraints:
 *
 * -231 <= n <= 231 - 1
 *
 *
 * Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfThree {
    /**
     * Brute force
     */
    public boolean isPowerOfThreeNaive(int n) {
        int i = 0;
        double temp = 0;
        while (temp <= n) {
            temp = Math.pow(3, i);

            if (temp == n) return true;
            i++;
        }

        return false;
    }

    /**
     * Loop, but still on optimal
     * Time complexity log b (n)
     */
    public boolean isPowerOfThreeLoop(int n) {
        if (n < 1) return false;

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
