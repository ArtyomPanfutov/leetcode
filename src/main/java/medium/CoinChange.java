package medium;

import java.util.Arrays;

/**
 * 322. Coin Change
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 * Example 4:
 *
 * Input: coins = [1], amount = 1
 * Output: 1
 * Example 5:
 *
 * Input: coins = [1], amount = 2
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinChange {
    /**
     * Algorithm
     *
     * The idea of the algorithm is to build the solution of the problem from top to bottom.
     * It applies the idea described above. It use backtracking and cut the partial solutions in the recursive tree, which doesn't lead to a viable solution.
     * Тhis happens when we try to make a change of a coin with a value greater than the amount SS.
     *
     * To improve time complexity we should store the solutions of the already calculated subproblems in a table.
     *
     * Complexity Analysis
     *
     * Time complexity : O(S*n)O(S∗n). where S is the amount, n is denomination count. In the worst case the recursive tree of the algorithm has height of SS and the algorithm solves only SS subproblems because it caches precalculated solutions in a table. Each subproblem is computed with nn iterations, one by coin denomination. Therefore there is O(S*n)O(S∗n) time complexity.
     *
     * Space complexity : O(S)O(S), where SS is the amount to change We use extra space for the memoization table.
     */
    private static class DpTopDownSolution {
        public int coinChange(int[] coins, int amount) {
            if (amount < 1) return 0;

            return coinChange(coins, amount, new int[amount]);
        }

        private int coinChange(int[] coins, int rem, int[] count) {
            if (rem < 0) return -1;
            if (rem == 0) return 0;
            if (count[rem - 1] != 0) return count[rem - 1];

            int min = Integer.MAX_VALUE;

            for (int coin : coins) {
                int res = coinChange(coins, rem - coin, count);
                if (res >= 0 && res < min) {
                    min = 1 + res;
                }
            }
            count[rem - 1] = min == Integer.MAX_VALUE ? -1 : min;
            return count[rem - 1];
        }
    }

    private static class DpBottomUpSolution {
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;

            int[] dp = new int[max];
            Arrays.fill(dp, max);

            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (coin <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
