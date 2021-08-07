package hard;

/**
 * 132. Palindrome Partitioning IIGiven a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 0
 * Example 3:
 *
 * Input: s = "ab"
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2000
 * s consists of lower-case English letters only.
 */
public class PalindromePartitioningII {
    /**
     * O(n^2)
     */
    static class Dp {
        public int minCut(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            // dp matrix
            // dp[i][j] represents whether s[i] -> s[j] is a palindrome
            boolean[][] dp = buildDp(s);

            // minimum cuts from - to i
            int[] cut = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                int min = i;
                for (int j = 0; j <= i; j++) {
                    if (dp[j][i]) {
                        min = Math.min(min, j == 0 ? 0 : cut[j - 1] + 1);
                    }
                }
                cut[i] = min;
            }

            return cut[s.length() - 1];
        }

        private boolean[][] buildDp(String s) {
            boolean[][] result = new boolean[s.length()][s.length()];

            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || result[i + 1][j - 1])) {
                        result[i][j] = true;
                    }
                }
            }

            return result;
        }

    }
}
