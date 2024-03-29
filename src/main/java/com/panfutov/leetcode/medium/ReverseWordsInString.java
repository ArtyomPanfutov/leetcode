package com.panfutov.leetcode.medium;

/**
 * 151. Reverse Words in a String
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Example 4:
 *
 * Input: s = "  Bob    Loves  Alice   "
 * Output: "Alice Loves Bob"
 * Example 5:
 *
 * Input: s = "Alice does not even like bob"
 * Output: "bob like even not does Alice"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * There is at least one word in s.
 *
 *
 * Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 */
public class ReverseWordsInString {
    public static class AdditionalSpaceSolution {
        public String reverseWords(String s) {
            final StringBuilder result = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                }

                final int start = i;
                while (i < s.length() && s.charAt(i) != ' ') {
                    i++;
                }

                if (start < s.length() && s.charAt(start) != ' ') {
                    result.insert(0, s.substring(start, i));
                    result.insert(0, " ");
                }
            }

            if (result.charAt(0) == ' ') {
                result.deleteCharAt(0);
            }

            return result.toString();
        }
    }

    public static class StringBuilderFromEndSolution {
        public String reverseWords(String s) {
            var sb = new StringBuilder();
            int current = s.length() - 1;
            while (current >= 0) {
                int right = current;
                while (right >= 0 && s.charAt(right) == ' ') {
                    right--;
                }
                int left = right - 1;
                while (left >= 0 && s.charAt(left) != ' ') {
                    left--;
                }
                if (left >= -1) {
                    sb.append(' ');
                    sb.append(s.substring(left + 1, right + 1));
                }
                current = left - 1;
            }
            if (sb.charAt(0) == ' ') {
                sb.deleteCharAt(0);
            }

            return sb.toString();

        }
    }
}
