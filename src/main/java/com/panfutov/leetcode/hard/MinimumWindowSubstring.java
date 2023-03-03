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
        Map<Character, Integer> tMap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        int requiredCount = tMap.size();

        int left = 0;
        int right = 0;

        // For keeping track of how many unique characters in t
        // are present in the current window in its desired frequency
        int uniqueCount = 0;

        Map<Character, Integer> windowCount = new HashMap<>();

        // window length, left, right
        int[] ans = {-1, 0, 0};

        while (right < s.length()) {
            char current = s.charAt(right);

            windowCount.put(current, windowCount.getOrDefault(current, 0) + 1);

            if (tMap.containsKey(current)
                    && windowCount.get(current).equals(tMap.get(current))) {
                uniqueCount++;
            }

            while (left <= right && uniqueCount == requiredCount) {
                current = s.charAt(left);

                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                int currentWindowCount = windowCount.get(current) - 1;
                windowCount.put(current, currentWindowCount);

                if (tMap.containsKey(current)
                        && currentWindowCount < tMap.get(current)) {
                    uniqueCount--;
                }
                left++;
            }

            right++;
        }

        return ans[0] == -1
                ? ""
                : s.substring(ans[1], ans[2] + 1);
    }
}
