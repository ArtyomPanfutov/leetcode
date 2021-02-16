package easy;

/**
 * 66. Plus One
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Example 3:
 *
 * Input: digits = [0]
 * Output: [1]
 *
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;

        while (i >= 0 && digits[i] == 9) i--;

        if (i < 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }

        int[] result = new int[digits.length];

        result[i] = digits[i] + 1;
        for (int j = 0; j < i; j++) {
            result[j] = digits[j];
        }

        return result;
    }
}
