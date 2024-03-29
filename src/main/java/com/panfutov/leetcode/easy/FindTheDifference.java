package com.panfutov.leetcode.easy;

/**
 * 389. Find the Difference
 * You are given two strings s and t.
 *
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 *
 * Return the letter that was added to t.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcd", t = "abcde"
 * Output: "e"
 * Explanation: 'e' is the letter that was added.
 * Example 2:
 *
 * Input: s = "", t = "y"
 * Output: "y"
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: "a"
 * Example 4:
 *
 * Input: s = "ae", t = "aea"
 * Output: "a"
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s and t consist of lower-case English letters.
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char ch = t.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            ch ^= s.charAt(i) ^ t.charAt(i + 1);
        }
        return ch;
    }
}
