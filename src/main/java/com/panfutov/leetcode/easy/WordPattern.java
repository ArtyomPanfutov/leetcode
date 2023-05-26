package com.panfutov.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 *
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 *
 *
 * Example 1:
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 * Example 4:
 *
 * Input: pattern = "abba", s = "dog dog dog dog"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= pattern.length <= 300
 * pattern contains only lower-case English letters.
 * 1 <= s.length <= 3000
 * s contains only lower-case English letters and spaces ' '.
 * s does not contain any leading or trailing spaces.
 * All the words in s are separated by a single space.
 */
public class WordPattern {
    public static class OneHashMapSolution {
        public boolean wordPattern(String pattern, String s) {
            Map<Character, String> map = new HashMap<>();

            String[] words = s.split(" ");

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                Character ch = pattern.charAt(i);

                if (map.containsKey(ch)) {
                    if (!map.get(ch).equals(word)) return false;
                } else {
                    map.put(ch, word);
                }
            }

            return true;
        }
    }

    public static class TwoHashMapSolution {
        public boolean wordPattern(String pattern, String s) {
            String[] words = s.split(" ");

            if (words.length != pattern.length()) {
                return false;
            }

            Map<Character, String> wordByLetter = new HashMap<>();
            Map<String, Character> letterByWord = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                Character letter = letterByWord.get(words[i]);
                String word = wordByLetter.get(pattern.charAt(i));

                if ((letter == null && word != null) || (letter != null && word == null)) {
                    return false;
                }

                if (letter == null && word == null) {
                    wordByLetter.put(pattern.charAt(i), words[i]);
                    letterByWord.put(words[i], pattern.charAt(i));
                } else {
                    if (!words[i].equals(word) || pattern.charAt(i) != letter) {
                        return false;
                    }
                }

            }

            return true;
        }
    }
}
