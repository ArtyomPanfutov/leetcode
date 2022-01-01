package easy;

/**
 * 925. Long Pressed Name
 * Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
 *
 * You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 *
 *
 *
 * Example 1:
 *
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 * Example 2:
 *
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it was not in the typed output.
 *
 *
 * Constraints:
 *
 * 1 <= name.length, typed.length <= 1000
 * name and typed consist of only lowercase English letters.
 */
public class LongPressedName {
    static class TwoPointersSolution {
        public boolean isLongPressedName(String name, String typed) {
            int left = 0;
            int right = 0;

            while (left < name.length() && right < typed.length()) {
                final char leftChar = name.charAt(left);
                final char rightChar = typed.charAt(right);

                if (leftChar != rightChar) {
                    return false;
                }

                int rightCount = 0;
                while (right < typed.length() && typed.charAt(right) == rightChar) {
                    right++;
                    rightCount++;
                }

                int leftCount = 0;
                while (left < name.length() && name.charAt(left) == leftChar) {
                    left++;
                    leftCount++;
                }

                if (leftCount > rightCount) {
                    return false;
                }
            }

            return left == name.length() && right == typed.length();
        }
    }
}
