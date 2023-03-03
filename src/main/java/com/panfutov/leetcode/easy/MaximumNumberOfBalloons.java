package com.panfutov.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1189. Maximum Number of Balloons
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 *
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: text = "nlaebolko"
 * Output: 1
 * Example 2:
 *
 *
 *
 * Input: text = "loonbalxballpoon"
 * Output: 2
 * Example 3:
 *
 * Input: text = "leetcode"
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= text.length <= 104
 * text consists of lower case English letters only.
 */
public class MaximumNumberOfBalloons {
    static class Solution {
        public int maxNumberOfBalloons(String text) {
            final Map<Character, Integer> map = new HashMap<>();

            for (char ch : text.toCharArray()) {
                if (ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n') {
                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                }
            }

            if (map.entrySet().size() < 5) {
                return 0;
            }

            int count = Integer.MAX_VALUE;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                int value = entry.getValue();
                if (entry.getKey() == 'l' || entry.getKey() == 'o') {
                    value /= 2;
                }

                count = Math.min(count, value);
            }

            return count;
        }
    }
}
