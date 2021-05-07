package medium;

/**
 * 647. Palindromic Substrings
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 */
public class PalindromicSubstrings {
    /**
     * Time Complexity: O(N^2)O(N
     * 2
     *  ) for input string of length NN. The total time taken in this approach is dictated by two variables:
     *
     * The number of possible palindromic centers we process.
     * How much time we spend processing each center.
     * The number of possible palindromic centers is 2N-12N−1: there are NN single character centers and N-1N−1 consecutive character pairs as centers.
     *
     * Each center can potentially expand to the length of the string, so time spent on each center is linear on average. Thus total time spent is N \cdot (2N-1) \simeq N^2N⋅(2N−1)≃N
     * 2
     *  Space Complexity: O(1)O(1). We don't need to allocate any extra space since we are repeatedly iterating on the input string itself..
     */
    public static final class ExpandSolution {
        public int countSubstrings(String s) {
            int count = 0;

            for (int i = 0; i < s.length(); i++) {
                count += expand(s, i, i);
                count += expand(s, i, i + 1);
            }

            return count;

        }

        private int expand(String s, int start, int end) {
            int result = 0;

            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                result++;
                start--;
                end++;
            }

            return result;
        }
    }
}
