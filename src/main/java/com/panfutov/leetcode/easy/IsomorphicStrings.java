package com.panfutov.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 205. Isomorphic Strings
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapByFirst = new HashMap<>();
        Map<Character, Character> mapBySecond = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char first = s.charAt(i);
            char second = t.charAt(i);

            if (mapByFirst.containsKey(first) && mapByFirst.get(first) != second) {
                return false;
            }

            if (mapBySecond.containsKey(second) && mapBySecond.get(second) != first) {
                return false;
            }

            mapByFirst.put(first, second);
            mapBySecond.put(second, first);
        }

        return true;
    }
}
