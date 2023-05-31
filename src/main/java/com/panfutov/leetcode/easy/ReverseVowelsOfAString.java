package com.panfutov.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 345. Reverse Vowels of a String
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: s = "leetcode"
 * Output: "leotcede"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 */
public class ReverseVowelsOfAString {
    public static class Solution {
        private static final Set<Character> vowels = Set.of(
                'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');

        public String reverseVowels(String s) {
            int left = 0;
            int right = s.length() - 1;

            char[] string = s.toCharArray();

            while (left < right) {
                if (vowels.contains(string[left]) && vowels.contains(string[right])) {
                    char temp = string[left];
                    string[left] = string[right];
                    string[right] = temp;

                    left++;
                    right--;
                } else if (vowels.contains(string[left])) {
                    right--;
                } else if (vowels.contains(string[right])) {
                    left++;
                } else {
                    left++;
                    right--;
                }

            }

            return new String(string);
        }
    }
}
