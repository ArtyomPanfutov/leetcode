package medium;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 * Example 3:
 *
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 *
 * Input: s = "ac"
 * Output: "a"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters (lower-case and/or upper-case),
 */
public class LongestPalindromicSubstring {
    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public static final class ExpandSolution {
        public String longestPalindrome(String s) {
            int start = 0;
            int end = 0;

            for (int i = 0; i < s.length(); i++) {
                int length = Math.max(expand(s, i ,i), expand(s, i, i + 1));

                if (length > end - start) {
                    start = i - (length - 1) / 2;
                    end = i + length / 2;
                }
            }

            return s.substring(start, end + 1);
        }

        private int expand(String s, int left, int right) {
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            return right - left - 1;
        }
    }
    
    /**
     * DP Solution
     */
    class Solution {
        private class PalindromeRange {
            String string;
            int start;
            int end;

            PalindromeRange(int start, int end, String s) {
                this.start = start;
                this.end = end;
                this.string = s;
            }

            int length() {
                return end - start + 1;
            }

            String substring() {
                return string.substring(start, end + 1);
            }

        }

        public String longestPalindrome(String s) {
            var longestRange = new PalindromeRange(0, 0, s);
            var dp = new boolean[s.length()][s.length()];
            for (int right = 0; right < s.length(); right++) {
                for (int left = 0; left < right + 1; left++) {
                    if (isPalindrome(s, left, right, dp) && longestRange.length() < right - left + 1) {
                        longestRange = new PalindromeRange(left, right, s); 
                    } 
                }
            }

            return longestRange.substring();
        }

        private boolean isPalindrome(String s, int start, int end, boolean[][] dp) {
            if (start == end) {
                dp[start][end] = true;
            } else if (end == start + 1) {
                dp[start][end] = s.charAt(start) == s.charAt(end);
            } else {
                int prevStart = (start < s.length()) 
                    ? start + 1 : start;
                int prevEnd = (end > 0)
                    ? end - 1 : end;

                dp[start][end] = dp[prevStart][prevEnd] && s.charAt(start) == s.charAt(end);
            }

            return dp[start][end];
        }
    }
}
