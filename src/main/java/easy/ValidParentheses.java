package easy;

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
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();

        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                if (map.get(ch) != stack.peek()) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}
