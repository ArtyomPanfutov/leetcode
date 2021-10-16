package easy;

/**
 * 844. Backspace String Compare
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 *
 * Input: s = "a##c", t = "#a#c"
 * Output: true
 * Explanation: Both s and t become "c".
 * Example 4:
 *
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 *
 *
 * Follow up: Can you solve it in O(n) time and O(1) space?
 */
public class BackspaceStringCompare {
    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    static class SkipCountSolution {
        public boolean backspaceCompare(String s, String t) {
            int left = s.length() - 1;
            int right = t.length() - 1;
            int skipLeft = 0;
            int skipRight = 0;

            while (left >= 0 || right >= 0) {
                while (left >= 0)  {
                    if (s.charAt(left) == '#') {
                        skipLeft++;
                        left--;
                    } else if (skipLeft > 0) {
                        skipLeft--;
                        left--;
                    } else {
                        // found position
                        break;
                    }
                }

                while (right >= 0) {
                    if (t.charAt(right) == '#') {
                        skipRight++;
                        right--;
                    } else if (skipRight > 0) {
                        skipRight--;
                        right--;
                    } else {
                        // found positon
                        break;
                    }
                }

                if (left >= 0 && right >= 0 && s.charAt(left) != t.charAt(right)) {
                    return false;
                }

                if ((left >= 0) != (right >= 0)) {
                    return false;
                }

                left--;
                right--;
            }

            return true;
        }
    }
}
