package com.panfutov.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 394. Decode String
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 * The test cases are generated so that the length of the output will never exceed 105.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 *
 */
public class DecodeString {
    public static class Solution {
        public String decodeString(String s) {
            Queue<Character> queue = new LinkedList<>();

            for (char ch : s.toCharArray()) {
                queue.add(ch);
            }

            return decode(queue);
        }

        private String decode(Queue<Character> queue) {
            var sb = new StringBuilder();

            int num = 0;
            while (!queue.isEmpty()) {
                char ch = queue.poll();
                if (Character.isDigit(ch)) {
                    num = num * 10 + ch - '0';
                } else if (ch == '[') {
                    String sub = decode(queue);
                    for (int i = 0; i < num; i++) {
                        sb.append(sub);
                    }
                    num = 0;
                } else if (ch == ']') {
                    break;
                } else {
                    sb.append(ch);
                }
            }
            return sb.toString();
        }
    }

    private static class StackSolution {
        public String decodeString(String s) {
            Deque<Integer> stack = new ArrayDeque<>();
            Deque<StringBuilder> sbStack = new ArrayDeque<>();
            int count = 0;
            var sb = new StringBuilder();
            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) {
                    count = count * 10 + (ch - '0');
                } else if (ch == '[') {
                    stack.push(count);
                    sbStack.push(sb);
                    sb = new StringBuilder();
                    count = 0;
                } else if (ch == ']') {
                    var temp = sb;
                    sb = sbStack.pop();
                    for (int i = stack.pop(); i > 0; i--) {
                        sb.append(temp);
                    }
                } else {
                    sb.append(ch);
                }
            }
            return sb.toString();
        }
    }

}
