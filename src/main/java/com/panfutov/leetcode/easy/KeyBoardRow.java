package com.panfutov.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 500. Keyboard Row
 * Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.
 *
 * In the American keyboard:
 *
 * the first row consists of the characters "qwertyuiop",
 * the second row consists of the characters "asdfghjkl", and
 * the third row consists of the characters "zxcvbnm".
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["Hello","Alaska","Dad","Peace"]
 * Output: ["Alaska","Dad"]
 * Example 2:
 *
 * Input: words = ["omk"]
 * Output: []
 * Example 3:
 *
 * Input: words = ["adsdf","sfd"]
 * Output: ["adsdf","sfd"]
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] consists of English letters (both lowercase and uppercase).
 */
public class KeyBoardRow {
    /**
     * Time complexity: O(M) where M is the length of all words
     * Space complexity: O(1)
     */
    private static final String[] rows = new String[] {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

    private static final Set<Character>[] rowSet;

    static {
        rowSet = new HashSet[rows.length];

        for (int i = 0; i < rows.length; i++) {
            char[] chars = rows[i].toCharArray();

            rowSet[i] = new HashSet<>();
            for (char ch : chars) {
                rowSet[i].add(ch);
            }
        }
    }
    public String[] findWords(String[] words) {
        List<String> found = new ArrayList<>();

        for (String word : words) {
            int row = findRow(word.charAt(0));

            boolean allMatch = true;
            for (char ch : word.toCharArray()) {
                ch = Character.toLowerCase(ch);
                if (!rowSet[row].contains(ch)) {
                    allMatch = false;
                    break;
                }
            }

            if (allMatch) {
                found.add(word);
            }
        }

        return found.toArray(new String[0]);
    }

    private int findRow(char ch) {
        ch = Character.toLowerCase(ch);
        for (int i = 0; i < rowSet.length; i++) {
            if (rowSet[i].contains(ch)) {
                return i;
            }
        }

        return -1;
    }
}
