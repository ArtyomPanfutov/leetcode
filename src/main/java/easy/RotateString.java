package easy;

/**
 * 796. Rotate String
 * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
 *
 * A shift on s consists of moving the leftmost character of s to the rightmost position.
 *
 * For example, if s = "abcde", then it will be "bcdea" after one shift.
 *
 *
 * Example 1:
 *
 * Input: s = "abcde", goal = "cdeab"
 * Output: true
 * Example 2:
 *
 * Input: s = "abcde", goal = "abced"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length, goal.length <= 100
 * s and goal consist of lowercase English letters.
 */
public class RotateString {
    class BruteForce {
        public boolean rotateString(String s, String goal) {
            char[] string = s.toCharArray();
            char[] target = goal.toCharArray();

            for (int i = 0; i < string.length; i++) {
                rotate(string);

                if (same(string, target)) {
                    return true;
                }
            }

            return false;
        }

        private void rotate(char[] string) {
            char last = string[string.length - 1];

            for (int i = string.length - 1; i > 0; i--) {
                string[i] = string[i - 1];
            }

            string[0] = last;
        }

        private boolean same(char[] x, char[] y) {
            if (x.length != y.length) {
                return false;
            }

            for (int i = 0; i < x.length; i++) {
                if (x[i] != y[i]) {
                    return false;
                }
            }

            return true;
        }
    }
}
