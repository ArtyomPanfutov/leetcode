package com.panfutov.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
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
 * strs[i] consists of lowercase English letters.
 */
public class GroupAnagrams {
    public static class MapSolution {
        class Solution {
            public List<List<String>> groupAnagrams(String[] strs) {
                Map<String, List<String>> map = new HashMap<>();

                for (var str : strs) {
                    int[] freq = new int[26];
                    for (var ch : str.toCharArray()) {
                        freq[ch - 'a']++;
                    }

                    String key = buildKey(freq);

                    var list = map.getOrDefault(key, new ArrayList<>());
                    list.add(str);
                    map.put(key, list);
                }

                return new ArrayList<>(map.values());
            }

            private String buildKey(int[] freq) {
                var sb = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    if (freq[i] > 0) {
                        sb.append((char) (i + 'a'));
                        sb.append(freq[i]);
                    }
                }
                return sb.toString();
            }
        }
    }
}
