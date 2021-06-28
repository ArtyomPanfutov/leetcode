package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 345. Reverse Vowels of a String
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: s = "leetcode"
 * Output: "leotcede"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 */
public class ReverseVowelsOfAString {
    private static final Set<Character> VOWELS = new HashSet<>();

    static {
        VOWELS.add('a');
        VOWELS.add('A');
        VOWELS.add('e');
        VOWELS.add('E');
        VOWELS.add('i');
        VOWELS.add('I');
        VOWELS.add('o');
        VOWELS.add('O');
        VOWELS.add('u');
        VOWELS.add('U');
    }

    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;

        char[] string = s.toCharArray();
        while (left < right) {
            if (VOWELS.contains(string[left]) && VOWELS.contains(string[right])) {
                char temp = string[left];
                string[left] = string[right];
                string[right] = temp;
                left++;
                right--;
            } else if (VOWELS.contains(string[left])) {
                right--;
            } else if (VOWELS.contains(string[right])) {
                left++;
            } else {
                left++;
                right--;
            }
        }

        return new String(string);
    }
}
