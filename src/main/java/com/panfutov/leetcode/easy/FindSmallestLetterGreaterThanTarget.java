package com.panfutov.leetcode.easy;

/**
 * 744. Find Smallest Letter Greater Than Target
 * Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest character in the array that is larger than target.
 *
 * Note that the letters wrap around.j
 *
 * For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
 *
 *
 * Example 1:
 *
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 * Example 2:
 *
 * Input: letters = ["c","f","j"], target = "c"
 * Output: "f"
 * Example 3:
 *
 * Input: letters = ["c","f","j"], target = "d"
 * Output: "f"
 * Example 4:
 *
 * Input: letters = ["c","f","j"], target = "g"
 * Output: "j"
 * Example 5:
 *
 * Input: letters = ["c","f","j"], target = "j"
 * Output: "c"
 *
 *
 * Constraints:
 *
 * 2 <= letters.length <= 104
 * letters[i] is a lowercase English letter.
 * letters is sorted in non-decreasing order.
 * letters contains at least two different characters.
 * target is a lowercase English letter.
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        while (right >= left) {
            int mid = left + (right - left) / 2;

            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left < letters.length
                ? letters[left]
                : letters[0];
    }
}
