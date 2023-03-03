package com.panfutov.leetcode.medium;

/**
 * 43. Multiply Strings
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 *
 * Constraints:
 *
 * 1 <= num1.length, num2.length <= 200
 * num1 and num2 consist of digits only.
 */
public class MultiplyStrings {
    /**
     * Time complexity: O(n*m)
     * Space complexity: O(n+m)
     */
    static class Solution {
        public String multiply(String num1, String num2) {
            int[] product = new int[num1.length() + num2.length()];

            for (int i = num1.length() - 1; i >= 0; i--) {
                for (int j = num2.length() - 1; j >= 0; j--) {
                    int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                    int sum = temp + product[i + j + 1];

                    product[i + j] += sum / 10;
                    product[i + j + 1] = sum % 10;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int num : product) {
                if (!(num == 0 && result.length() == 0)) {
                    result.append(num);
                }
            }

            return result.length() > 0 ? result.toString() : "0";
        }
    }
}
