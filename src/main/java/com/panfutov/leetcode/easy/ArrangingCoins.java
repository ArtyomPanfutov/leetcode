package com.panfutov.leetcode.easy;

/**
 * 441. Arranging Coins
 * You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.
 *
 * Given the integer n, return the number of complete rows of the staircase you will build.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 5
 * Output: 2
 * Explanation: Because the 3rd row is incomplete, we return 2.
 * Example 2:
 *
 *
 * Input: n = 8
 * Output: 3
 * Explanation: Because the 4th row is incomplete, we return 3.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 */
public class ArrangingCoins {
    /**
     * Not efficient, but working solution.
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static class SimulationSolution {
        public int arrangeCoins(int n) {
            int rows = 1;

            for (int i = 1; n > 0; i++) {
                n -= i;
                if (n >= 0) {
                    rows = i;
                }
            }

            return rows;
        }
    }

    /**
     * Time complexity: O(log(n))
     * Space complexity: O(1)
     */
    public static class BinarySearchSolution {
        public int arrangeCoins(int n) {
            int max = 0;
            int left = 0;
            int right = n;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                double coins = ((double)mid / 2) * (mid + 1);
                if (coins > n) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                    max = Math.max(max, mid);
                }
            }
            return max;
        }
    }
}
