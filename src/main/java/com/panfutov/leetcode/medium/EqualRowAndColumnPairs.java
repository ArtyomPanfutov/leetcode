package com.panfutov.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 2352. Equal Row and Column Pairs
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
 *
 * A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
 * Output: 1
 * Explanation: There is 1 equal row and column pair:
 * - (Row 2, Column 1): [2,7,7]
 * Example 2:
 *
 *
 * Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * Output: 3
 * Explanation: There are 3 equal row and column pairs:
 * - (Row 0, Column 0): [3,1,2,2]
 * - (Row 2, Column 2): [2,4,2,2]
 * - (Row 3, Column 2): [2,4,2,2]
 *
 *
 * Constraints:
 *
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * 1 <= grid[i][j] <= 105
 */
public class EqualRowAndColumnPairs {
    public static class BruteForceSolution {
        public int equalPairs(int[][] grid) {
            int count = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    boolean match = true;
                    for (int k = 0; k < grid.length; k++) {
                        if (grid[k][j] != grid[i][k]) {
                            match = false;
                            break;
                        }
                    }
                    count += match ? 1 : 0;
                }
            }
            return count;
        }

    }

    public static class TrieSolution {
        private static class TrieNode {
            private int count = 0;
            private final Map<Integer, TrieNode> children = new HashMap<>();
        }

        private static class Trie {
            private final TrieNode trie = new TrieNode();

            public void insert(int[] arr) {
                TrieNode node = this.trie;
                for (int num : arr) {
                    if (!node.children.containsKey(num)) {
                        node.children.put(num, new TrieNode());
                    }
                    node = node.children.get(num);
                }
                node.count += 1;
            }

            public int search(int[] arr) {
                TrieNode node = this.trie;
                for (int num : arr) {
                    if (node.children.containsKey(num)) {
                        node = node.children.get(num);
                    } else {
                        return 0;
                    }
                }
                return node.count;
            }

        }
        public int equalPairs(int[][] grid) {
            var trie = new Trie();
            for (int[] row : grid) {
                trie.insert(row);
            }

            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                var colArray = new int[grid.length];
                for (int j = 0; j < grid.length; j++) {
                    colArray[j] = grid[j][i];
                }
                count += trie.search(colArray);
            }
            return count;
        }
    }

}
