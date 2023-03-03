package com.panfutov.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 *
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinationsOfPhoneNumber {

    public static class Solution {
        private static final Map<Character, List<String>> MAP = Map.of(
                '2', List.of("a", "b", "c"),
                '3', List.of("d", "e", "f"),
                '4', List.of("g", "h", "i"),
                '5', List.of("j", "k", "l"),
                '6', List.of("m", "n", "o"),
                '7', List.of("p", "q", "r", "s"),
                '8', List.of("t", "u", "v"),
                '9', List.of("w", "x", "y", "z")
        );

        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if (digits.length() == 0) {
                return result;
            }

            fill(result, digits, 0, new StringBuilder());

            return result;
        }

        private void fill(List<String> result, String digits, int index, StringBuilder current) {
            if (index == digits.length()) {
                result.add(current.toString());
                return;
            }

            List<String> variants = MAP.get(digits.charAt(index));
            for (var letter : variants) {
                StringBuilder newString = new StringBuilder(current);
                newString.append(letter);
                fill(result, digits, index + 1, newString);
            }
        }
    }
}