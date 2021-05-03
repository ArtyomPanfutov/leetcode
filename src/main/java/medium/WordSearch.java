package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 79. Word Search
 *Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 */
public class WordSearch {

    /** Not optimal solution */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (check(board, word, 0, i, j, new HashSet<>())) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(char[][] board, String word, int wordIndex, int x, int y, Set<Integer> visited) {
        if (word.charAt(wordIndex) == board[x][y]) {

            int rowLength = board[0].length;
            visited.add(convert(x, y, rowLength));

            if (wordIndex == word.length() - 1) {
                return true;
            }

            wordIndex++;
            if (x - 1 >= 0 && !visited.contains(convert(x - 1, y, rowLength))) {
                if (check(board, word, wordIndex, x - 1, y, new HashSet<Integer>(visited))) {
                    return true;
                }
            }

            if (x + 1 < board.length &&!visited.contains(convert(x + 1, y, rowLength))) {
                if (check(board, word, wordIndex, x + 1, y, new HashSet<Integer>(visited))) {
                    return true;
                }
            }

            if (y - 1 >= 0 && !visited.contains(convert(x, y - 1, rowLength))) {
                if (check(board, word, wordIndex, x, y - 1, new HashSet<Integer>(visited))) {
                    return true;
                }
            }

            if (y + 1 < board[0].length && !visited.contains(convert(x, y + 1, rowLength))) {
                if (check(board, word, wordIndex, x, y + 1, new HashSet<Integer>(visited))) {
                    return true;
                }
            }
        }

        return false;
    }

    private int convert(int row, int col, int rowLength) {
        return (row * rowLength) + col;
    }

}
