package com.panfutov.leetcode.medium;

import java.util.Set;

/**
 * Maximum Number of Vowels in a Substring of Given Length
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 *
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 * Example 2:
 *
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 * Example 3:
 *
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * 1 <= k <= s.length
 */
public class MaximumNumberOfVowelsInSubstringOfGivenLength {

    public static class Solution {

        private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

        public int maxVowels(String s, int k) {
            int count = 0;
            for (int i = 0; i < k; i++) {
                if (VOWELS.contains(s.charAt(i))) {
                    count++;
                }
            }
            int max = count;

            for (int i = k - 1; i < s.length() - 1; i++) {
                if (VOWELS.contains(s.charAt(i - k + 1))) {
                    count--;
                }
                if (VOWELS.contains(s.charAt(i + 1))) {
                    count++;
                }
                max = Math.max(max, count);
            }

            return max;
        }
    }
}
