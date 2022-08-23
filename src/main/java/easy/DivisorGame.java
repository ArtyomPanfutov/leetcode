package easy;

/**
 * 1025. Divisor Game
 *
 * Alice and Bob take turns playing a game, with Alice starting first.
 *
 * Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
 *
 * Choosing any x with 0 < x < n and n % x == 0.
 * Replacing the number n on the chalkboard with n - x.
 * Also, if a player cannot make a move, they lose the game.
 *
 * Return true if and only if Alice wins the game, assuming both players play optimally.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: true
 * Explanation: Alice chooses 1, and Bob has no more moves.
 * Example 2:
 *
 * Input: n = 3
 * Output: false
 * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 */
public class DivisorGame {
    /**
     * The most optimal
     */
    public static class ConstantSolution {
        public boolean divisorGame(int n) {
            return n % 2 == 0;
        }
    }

    public static class DpSolution {
        public boolean divisorGame(int n) {
            // Result of the game for the player that starts (Alice in this case)
            final boolean[] dp = new boolean[n + 1];

            // Setting explicitly to emphasize that this is loosing numbers for Alice
            dp[0] = false;
            dp[1] = false;


            // Alice will try all factors and choose the one which gives his opponent a losing value.
            for (int i = 2; i < dp.length; i++) {
                for (int j = 1; j < i; j++) {
                    if (i % j == 0 && !dp[i - j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[dp.length - 1];
        }
    }

    /**
     * Time limit exceeded
     */
    public static class BruteForceSolution {
        public boolean divisorGame(int n) {
            for (int i = 1; i < n; i++) {
                if (n % i == 0 && !divisorGame(n - i)) {
                    return true;
                }
            }

            return false;
        }
    }
}
