package com.panfutov.leetcode.easy;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Example 3:
 *
 * Input: haystack = "", needle = ""
 * Output: 0
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;

        int haystackIndex = 0;
        int needleIndex = 0;

        while (haystackIndex < haystack.length()) {
            if (haystack.charAt(haystackIndex) == needle.charAt(needleIndex)) {
                if (needleIndex == needle.length() - 1)
                    return haystackIndex - needle.length() + 1;

                needleIndex++;
            } else {
                haystackIndex = haystackIndex - needleIndex;
                needleIndex = 0;
            }

            haystackIndex++;
        }
        return -1;
    }
}
