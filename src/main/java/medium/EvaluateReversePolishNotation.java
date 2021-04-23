package medium;

import java.util.*;

/**
 * 150. Evaluate Reverse Polish Notation
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 *
 * Note that division between two integers should truncate toward zero.
 *
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.
 *
 *
 *
 * Example 1:
 *
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 *
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 *
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 *
 * Constraints:
 *
 * 1 <= tokens.length <= 104
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */
public class EvaluateReversePolishNotation {
    /**
     * Time complexity: O(n) where n is the length of the token array
     * Space complexity: O(d) where d is the number of digits
     */
    public int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>(
                Arrays.asList("+", "-", "*", "/"));

        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (!operators.contains(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int op1 = stack.pop();
                int op2 = stack.pop();

                stack.push(calculate(op1, op2, token));
            }
        }
        return stack.pop();
    }

    private int calculate(int op1, int op2, String operator) {
        switch(operator) {
            case "+":
                return op1 + op2;
            case "-":
                return op2 - op1;
            case "*":
                return op1 * op2;
            case "/":
                return op2 / op1;
            default:
                throw new RuntimeException("wrong token");
        }
    }
}
