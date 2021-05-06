package easy;

import java.util.*;

/**
 * 49. Group Anagrams
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lower-case English letters.
 */
public class GroupAnagrams {
    /**
     * Time complexity: O(NKlogK)
     * Space complexity: O(N)
     * Where N is the length of strs and K is the longest length of string
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();

            Arrays.sort(chars);

            String key = String.valueOf(chars);

            if (map.containsKey(key)) {
                List<String> strings = map.get(key);
                strings.add(str);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(str);
                map.put(key, strings);
            }
        }

        return new ArrayList<>(map.values());
    }
}
