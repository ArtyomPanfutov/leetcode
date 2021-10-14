package medium;

import java.util.ArrayDeque;

/**
 * 279. Perfect Squares
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 */
public class PerfectSquares {
    static class DpSolution {
        public int numSquares(int n) {
            final int[] dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                final int sqrt = (int) Math.sqrt(i);

                if (sqrt * sqrt == i) {
                    dp[i] = 1;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int j = 1; j <= sqrt; j++) {
                        min = Math.min(min, dp[i - j * j] + 1);
                    }
                    dp[i] = min;
                }

            }

            return dp[n];
        }
    }
    static class Solution {
        public int numSquares(int n) {
            for (int i = 1; i <= n; i++) {
                if (canDivide(n, i)) {
                    return i;
                }
            }

            return 0;
        }

        private boolean canDivide(int num, int count) {
            if (count == 1) {
                int sqrt = (int) Math.sqrt(num);
                return sqrt * sqrt == num;
            }

            for (int i = 1; i * i <= num; i++) {
                if (canDivide(num - i * i, count - 1)) {
                    return true;
                }
            }

            return false;
        }
    }
}
