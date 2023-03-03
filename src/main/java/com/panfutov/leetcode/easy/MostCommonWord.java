package com.panfutov.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 819. Most Common Word
 * Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.
 *
 * The words in paragraph are case-insensitive and the answer should be returned in lowercase.
 *
 *
 *
 * Example 1:
 *
 * Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 * Example 2:
 *
 * Input: paragraph = "a.", banned = []
 * Output: "a"
 *
 *
 * Constraints:
 *
 * 1 <= paragraph.length <= 1000
 * paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
 * 0 <= banned.length <= 100
 * 1 <= banned[i].length <= 10
 * banned[i] consists of only lowercase English letters.
 */
public class MostCommonWord {
    static class MapSolution {
        public String mostCommonWord(String paragraph, String[] banned) {
            Map<String, Integer> words = new HashMap<>();
            Set<String> exclude = new HashSet<>();

            for (String word : banned) {
                exclude.add(word.toLowerCase());
            }

            int start = 0;
            for (int i = 0; i < paragraph.length(); i++) {
                if (!Character.isLetter(paragraph.charAt(i))
                        || paragraph.charAt(i) == ' '
                        || i == paragraph.length() - 1)
                {
                    int end = Character.isLetter(paragraph.charAt(i)) ? i + 1 : i;
                    String word = paragraph.substring(start, end).toLowerCase();

                    if (!exclude.contains(word) && word.length() > 0) {
                        words.put(word, words.getOrDefault(word, 0) + 1);
                    }
                    start = i + 1;
                }
            }

            int max = Integer.MIN_VALUE;
            String word = "";
            for (Map.Entry<String, Integer> entry : words.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    word = entry.getKey();
                }
            }

            return word;
        }
    }
}
