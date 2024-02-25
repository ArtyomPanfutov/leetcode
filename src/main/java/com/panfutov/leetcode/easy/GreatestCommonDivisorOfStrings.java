package com.panfutov.leetcode.easy;


/**
 * 1071. Greatest Common Divisor of Strings
 *
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t  (t concatenated with itself 1 or more times)
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 *
 * Example 1:
 *
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 *
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 *
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * Example 4:
 *
 * Input: str1 = "ABCDEF", str2 = "ABC"
 * Output: ""
 *
 *
 * Constraints:
 *
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1 and str2 consist of English uppercase letters.
 *
 */
public class GreatestCommonDivisorOfStrings {
    /**
     * Time complexity O(m + n)
     * Space complexity O(m + n)
     */
    public class MathApproach {
        public String gcdOfStrings(String str1, String str2) {
            if (!(str1 + str2).equals(str2 + str1)) return "";

            int divisor = gcd(str1.length(), str2.length());

            return str1.substring(0, divisor);
        }

        private int gcd(int a, int b) {
            if (b == 0) return a;

            return gcd(b, a % b);
        }
    }

    /**
     * Time complexity: O(min(m, n) * (m + n))
     * Space complexity: O(min(m, n)
     */
    public class BruteForce {
        public String gcdOfStrings(String str1, String str2) {
            if (str1.length() < str2.length()) {
                String temp = str2;
                str2 = str1;
                str1 = temp;
            }

            for (int i = str2.length(); i > 0; i--) {
                if (matches(str1, str2, i)) {
                    return str2.substring(0, i);
                }
            }

            return "";
        }

        private boolean matches(String str1, String str2, int right) {
            var divisor = str2.substring(0, right);
            return isDivisor(str2, divisor) && isDivisor(str1, divisor);
        }

        private boolean isDivisor(String str, String divisor) {
            int i = 0;
            while(i + divisor.length() <= str.length()) {
                if (!str.substring(i, i + divisor.length()).equals(divisor)) {
                    return false;
                }
                i += divisor.length();
            }
            return i == str.length();
        }
    }
}
