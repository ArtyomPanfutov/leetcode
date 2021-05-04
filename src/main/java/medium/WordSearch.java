package medium;

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

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (check(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(char[][] board, String word, int wordIndex, int x, int y, boolean[][] visited) {
        if (word.charAt(wordIndex) == board[x][y]) {

            int rowLength = board[0].length;
            visited[x][y] = true;

            if (wordIndex == word.length() - 1) {
                return true;
            }

            wordIndex++;
            if (x - 1 >= 0 && !visited[x - 1][y]) {
                if (check(board, word, wordIndex, x - 1, y, visited)) {
                    return true;
                }
            }

            if (x + 1 < board.length && !visited[x + 1][y]) {
                if (check(board, word, wordIndex, x + 1, y,visited)) {
                    return true;
                }
            }

            if (y - 1 >= 0 && !visited[x][y - 1]) {
                if (check(board, word, wordIndex, x, y - 1, visited)) {
                    return true;
                }
            }

            if (y + 1 < board[0].length && !visited[x][y + 1]) {
                if (check(board, word, wordIndex, x, y + 1, visited)) {
                    return true;
                }
            }
            visited[x][y] = false;
        }

        return false;
    }
}
