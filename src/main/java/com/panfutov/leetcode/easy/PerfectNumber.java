package com.panfutov.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 507. Perfect Number
 * A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.
 *
 * Given an integer n, return true if n is a perfect number, otherwise return false.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 28
 * Output: true
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, and 14 are all divisors of 28.
 * Example 2:
 *
 * Input: num = 6
 * Output: true
 * Example 3:
 *
 * Input: num = 496
 * Output: true
 * Example 4:
 *
 * Input: num = 8128
 * Output: true
 * Example 5:
 *
 * Input: num = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= num <= 108
 * Accepted
 * 84,115
 * Submissions
 * 229,313
 */
public class PerfectNumber {
    /**
     * Hack
     */
    private static class ConstantComplexityHackedSolution {
        private static final Set<Integer> PERFECT = new HashSet<>();

        static {
            PERFECT.add(6);
            PERFECT.add(28);
            PERFECT.add(496);
            PERFECT.add(8128);
            PERFECT.add(33550336);
        }

        public boolean checkPerfectNumber(int num) {
            return PERFECT.contains(num);
        }
    }
}
