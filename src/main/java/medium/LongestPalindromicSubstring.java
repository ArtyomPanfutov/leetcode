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
}
