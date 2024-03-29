package com.panfutov.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".
 *
 * Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 105
 * s and t consist of English letters.
 *
 *
 * Follow up: Could you find an algorithm that runs in O(n) time?
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        for (var ch : t.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int current = 0;
        int target = t.length();
        int[] ans = new int[]{-1, 0, 0};
        while (right < s.length()) {
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
            var count = freq.get(s.charAt(right));
            if (count != null && count >= window.get(s.charAt(right))) {
                current++;
            }
            while (current == target) {
                int len = right - left + 1;
                if (ans[0] == -1 || len < ans[0]) {
                    ans[0] = len;
                    ans[1] = left;
                    ans[2] = right;
                }
                var leftCount = window.get(s.charAt(left));
                window.put(s.charAt(left), leftCount - 1);
                if (freq.containsKey(s.charAt(left)) && leftCount - 1 < freq.get(s.charAt(left))) {
                    current--;
                }
                left++;
            }
            right++;
        }
        return ans[0] != -1 ? s.substring(ans[1], ans[2] + 1) : "";
    }
}
