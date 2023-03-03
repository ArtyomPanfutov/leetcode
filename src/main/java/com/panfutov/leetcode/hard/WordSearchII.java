package com.panfutov.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 212. Word Search II
 *
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * Example 2:
 *
 *
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 */
public class WordSearchII {
    /**
     * Time complexity:
     * We are doing a 4-child DFS traversal.
     * The worst case depth in this case is the minimum of [traversing the entire board, traversing until we hit the end of a word].
     * -> O of each traversal is4^(min(Y, NM))
     * Note: min accounts for the case where we have words in the dictionary longer than the number of characters in the board itself.
     * We are doing this N*M times since we need to check for words starting at each position in the board
     * -> O(4^(min(Y, NM))*NM)
     *
     * Space complexity: O(K)
     *
     * where K - number of words
     * M - number of rows
     * N - number of columns
     * Y - longes word in dictionary
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> found = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, root, found);
            }
        }

        return found;
    }

    private void dfs(int row, int col, char[][] board, TrieNode root, List<String> result) {
        char ch = board[row][col];

        if (ch == '#' || root.next[ch - 'a'] == null) {
            return;
        }

        root = root.next[ch - 'a'];

        if (root.word != null) {
            result.add(root.word);
            root.word = null;
        }

        board[row][col] = '#';

        if (row > 0) dfs(row - 1, col, board, root, result);
        if (row < board.length - 1) dfs(row + 1, col, board, root, result);
        if (col > 0) dfs(row, col - 1, board, root, result);
        if (col < board[0].length - 1) dfs(row, col + 1, board, root, result);

        board[row][col] = ch;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode current = root;

            for (char ch : word.toCharArray()) {
                int i = ch - 'a';

                if (current.next[i] == null) {
                    current.next[i] = new TrieNode();
                }

                current = current.next[i];
            }
            current.word = word;
        }

        return root;
    }

    private static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
