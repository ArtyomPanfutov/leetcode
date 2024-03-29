package com.panfutov.leetcode.easy;

/**
 * 168. Excel Sheet Column Title
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int c = n % 26;

            if (c == 0) {
                sb.insert(0, "Z");
                n--;
            }
            else {
                sb.insert(0, (char) (c + 64));
            }

            n = n / 26;
        }

        return sb.toString();
    }
}
