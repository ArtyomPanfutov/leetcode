package com.panfutov.leetcode.medium;

/**
 * 424. Longest Repeating Character Replacement
 *
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int maxCount = 0;
        int[] chars = new int[26];

        int start = 0;
        int end = 0;

        while (end < s.length()) {
            chars[s.charAt(end) - 'A']++;
            int current = chars[s.charAt(end) - 'A'];
            maxCount = Math.max(maxCount, current);

            while (end - start - maxCount + 1 > k) {
                chars[s.charAt(start) - 'A']--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }


        return maxLength;
    }
}
