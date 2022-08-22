package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 140. Word Break II
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 * Example 2:
 *
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 */
public class WordBreakII {
    public static class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            final List<Integer>[] validStarts = new List[s.length() + 1];
            validStarts[0] = new ArrayList<>();

            final Set<String> words = new HashSet<>(wordDict);
            final int maxLength = findMaxLength(wordDict);

            for (int right = 1; right < validStarts.length; right++) {
                for (int left = right - 1; left >= 0 && left >= right - maxLength; left--) {
                    if (validStarts[left] != null) {
                        final String word = s.substring(left, right);

                        if (words.contains(word)) {
                            if (validStarts[right] == null) {
                                validStarts[right] = new ArrayList<>();
                            }

                            validStarts[right].add(left);
                        }
                    }
                }
            }

            final List<String> result = new ArrayList<>();
            if (validStarts[validStarts.length - 1] == null) {
                return result;
            }

            dfs(result, validStarts, "", validStarts.length - 1, s);

            return result;

        }

        private void dfs(List<String> result, List<Integer>[] validStarts, String path, int end, String string) {
            if (end == 0) {
                result.add(path.substring(1));
            } else {
                for (int start : validStarts[end]) {
                    dfs(result, validStarts, " " + string.substring(start, end) + path, start, string);
                }
            }
        }

        private int findMaxLength(List<String> words) {
            int max = 0;
            for (String word : words) {
                max = Math.max(max, word.length());
            }
            return max;
        }
    }
}
