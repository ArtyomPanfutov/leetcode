package com.panfutov.leetcode.medium;

/**
 * 2390. Removing Stars From a String
 */
public class RemovingStarsFromString {
    public static class Solution {
        public String removeStars(String s) {
            var result = new StringBuilder();

            for (char ch : s.toCharArray()) {
                if (ch == '*') {
                    result.deleteCharAt(result.length() - 1);
                } else {
                    result.append(ch);
                }
            }

            return result.toString();
        }
    }
}
