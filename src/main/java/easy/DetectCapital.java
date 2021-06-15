package easy;

/**
 * 520. Detect Capital
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Given a string word, return true if the usage of capitals in it is right.
 *
 *
 *
 * Example 1:
 *
 * Input: word = "USA"
 * Output: true
 * Example 2:
 *
 * Input: word = "FlaG"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 100
 * word consists of lowercase and uppercase English letters.
 */
public class DetectCapital {
    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static final class CountSolution {
        public boolean detectCapitalUse(String word) {
            int upperCaseCount = 0;

            for (int i = 0; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    upperCaseCount++;
                }
            }

            if (upperCaseCount == 0 || upperCaseCount == word.length()) {
                return true;
            }

            return upperCaseCount == 1 && Character.isUpperCase(word.charAt(0));
        }
    }
}
