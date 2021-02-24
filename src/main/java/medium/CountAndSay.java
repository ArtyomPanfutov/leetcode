package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 38. Count and Say
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.
 *
 * For example, the saying and conversion for digit string "3322251":
 *
 *
 * Given a positive integer n, return the nth term of the count-and-say sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: "1"
 * Explanation: This is the base case.
 * Example 2:
 *
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 */
public class CountAndSay {
    private static final int DELIMITER = -1;

    public String countAndSay(int n) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(DELIMITER);

        List<Integer> counted = count(n, list);

        StringBuilder sb = new StringBuilder();

        for (int num : counted) {
            sb.append(num);
        }

        return sb.toString();
    }

    private LinkedList<Integer> count(int n, LinkedList<Integer> prev) {
        if (n == 1) {
            prev.pollLast();
            return prev;
        }

        int count = 0;
        Integer prevDigit = null;

        LinkedList<Integer> next = new LinkedList<>();

        for (int digit : prev) {
            if (prevDigit == null) {
                prevDigit = digit;
                count++;
            } else if (prevDigit == digit) {
                count++;
            } else {
                next.add(count);
                next.add(prevDigit);
                prevDigit = digit;
                count = 1;
            }
        }

        next.add(DELIMITER);

        return count(n - 1, next);
    }
}
