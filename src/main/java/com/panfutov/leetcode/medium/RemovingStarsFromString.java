package com.panfutov.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2390. Removing Stars From a String
 */
public class RemovingStarsFromString {
    public static class StackSolution {
        public String removeStars(String s) {
            Deque<Character> deque = new ArrayDeque<>();
            for (var ch : s.toCharArray()) {
                if (ch == '*') {
                    deque.removeFirst();
                } else {
                    deque.addFirst(ch);
                }
            }
            var sb = new StringBuilder();
            while (!deque.isEmpty()) {
                sb.append(deque.removeLast());
            }
            return sb.toString();

        }
    }
    public static class StringBuilderSolution {
        public String removeStars(String s) {
            var result = new java.lang.StringBuilder();

            for (char ch : s.toCharArray()) {
                if (ch == '*') {
                    result.deleteCharAt(result.length() - 1); // !!! This is O(n) operation, array is copied
                } else {
                    result.append(ch);
                }
            }

            return result.toString();
        }
    }
}
