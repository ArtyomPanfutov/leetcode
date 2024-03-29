package com.panfutov.leetcode.easy;

/**
 * 392. Is Subsequence
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 *
 *
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */
public class IsSubsequence {
    /**
     * Time complexity: O(MN)
     * Space complexity: O(1)
     */
    public static final class SimpleApproach {
        public boolean isSubsequence(String s, String t) {
            int left = 0;
            int right = 0;

            while (left < s.length() && right < t.length()) {
                if (s.charAt(left) == t.charAt(right)) {
                    left++;
                }
                right++;
            }

            return left == s.length();
        }
    }

    public static final class AnotherWay {
        public boolean isSubsequence(String s, String t) {
            int right = 0;
            for (int i = 0; i < s.length(); i++) {
                while (right < t.length() && s.charAt(i) != t.charAt(right)) {
                    right++;
                }
                if (right >= t.length() ||  s.charAt(i) != t.charAt(right)) {
                    return false;
                }
                right++;
            }
            return true;
        }
    }
}
