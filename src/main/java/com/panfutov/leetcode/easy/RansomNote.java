package com.panfutov.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. Ransom Note
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote {
    public static class MapSolution {
        public boolean canConstruct(String ransomNote, String magazine) {
            Map<Character, Integer> map = new HashMap<>();

            for (char ch : magazine.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            for (char ch : ransomNote.toCharArray()) {
                Integer count = map.get(ch);
                if (count == null || count == 0) {
                    return false;
                }
                count--;
                map.put(ch, count);
            }

            return true;
        }
    }
    public static class ArraySolution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length()) {
                return false;
            }

            int[] map = new int[26];

            for (char currentChar : magazine.toCharArray()) {
                map[currentChar - 'a']++;
            }

            for (char currentChar : ransomNote.toCharArray()) {
                if (map[currentChar - 'a'] == 0) {
                    return false;
                }
                map[currentChar - 'a']--;
            }
            return true;
        }
    }
}
