package medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 239. Maximum Length of a Concatenated String with Unique Characters
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 *
 * Return the maximum possible length of s.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * Example 2:
 *
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * Example 3:
 *
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lower case English letters.
 */
public class MaximumLengthOfConcatenatedStringWithUniqueCharacters {
    /**
     * Time complexity: O(2^n)
     */
    static class Dfs {
        public int maxLength(List<String> arr) {
            return dfs(arr, "", 0);
        }

        private int dfs(List<String> list, String current, int index) {
            if (index > list.size()) {
                return 0;
            }

            final Set<Character> set = new HashSet<>();
            for (char ch : current.toCharArray()) {
                if (!set.add(ch)) {
                    return 0;
                }
            }
            int max = current.length();

            for (int i = index; i < list.size(); i++) {
                max = Math.max(max, dfs(list, current + list.get(i), i + 1));
            }
            return max;
        }
    }
}
