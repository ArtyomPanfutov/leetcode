package com.panfutov.leetcode.medium;

/**
 * 537. Complex Number Multiplication
 * A complex number can be represented as a string on the form "real+imaginaryi" where:
 *
 * real is the real part and is an integer in the range [-100, 100].
 * imaginary is the imaginary part and is an integer in the range [-100, 100].
 * i2 == -1.
 * Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = "1+1i", num2 = "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 *
 * Input: num1 = "1+-1i", num2 = "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 *
 *
 * Constraints:
 *
 * num1 and num2 are valid complex numbers.
 */
public class ComplexNumberMultiplication {
    static class Solution {
        public String complexNumberMultiply(String num1, String num2) {
            String[] splittedNum1 = num1.split("\\+|i");
            String[] splittedNum2 = num2.split("\\+|i");

            int realNum1 = Integer.parseInt(splittedNum1[0]);
            int imaginaryNum1 = Integer.parseInt(splittedNum1[1]);

            int realNum2 = Integer.parseInt(splittedNum2[0]);
            int imaginaryNum2 = Integer.parseInt(splittedNum2[1]);

            return (realNum1 * realNum2 -imaginaryNum1 * imaginaryNum2) + "+" + (imaginaryNum1 * realNum2 + realNum1 * imaginaryNum2) + "i";
        }
    }
}
