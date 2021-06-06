package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(result, new StringBuilder(), n, 0, 0);

        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int n, int open, int close) {
        if (current.length() == n * 2) {
            result.add(current.toString());

            return;
        }

        if (open < n) {
            current.append("(");
            backtrack(result, current, n, open + 1, close);
            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            current.append(")");
            backtrack(result, current, n, open, close + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
