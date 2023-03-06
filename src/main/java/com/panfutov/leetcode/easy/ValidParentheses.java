package com.panfutov.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 * Example 4:
 *
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 *
 * Input: s = "{[]}"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {
    private static Map<Character, Character> MAP = Map.of(
        ')', '(',
        ']', '[',
        '}', '{'
    );

    public boolean isValid(String s) {
        var stack = new ArrayDeque<Character>();
        for (var ch : s.toCharArray()) {
            if (isClosingParentheses(ch)) {
                var isValid = !stack.isEmpty() && stack.pop().equals(MAP.get(ch));

                if (!isValid) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    private boolean isClosingParentheses(Character ch)  {
        return MAP.containsKey(ch);
    }
}
