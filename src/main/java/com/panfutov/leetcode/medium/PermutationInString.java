package com.panfutov.leetcode.medium;

/**
 * Permutation in String
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */
public class PermutationInString {
    public static class OneArraySolution {
        public boolean checkInclusion(String s1, String s2) {
            if (s2.length() < s1.length()) {
                return false;
            }

            int[] freq = new int[26];
            for (var ch : s1.toCharArray()) {
                freq[ch - 'a']++;
            }

            int cur = 0;
            while (cur <= s2.length() - s1.length()) {
                if (freq[s2.charAt(cur) - 'a'] > 0) {
                    if (isPermutation(freq.clone(), s2, cur, cur + s1.length())) {
                        return true;
                    }
                }
                cur++;
            }
            return false;
        }

        private boolean isPermutation(int[] freq, String s2, int start, int end) {
            for (int i = start; i < end; i++) {
                freq[s2.charAt(i) - 'a']--;
                if (freq[s2.charAt(i) - 'a'] < 0) {
                    return false;
                }
            }
            for (var num : freq) {
                if (num != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
