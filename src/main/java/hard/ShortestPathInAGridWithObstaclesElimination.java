package hard;


import java.util.*;

/**
 * 1293. Shortest Path in a Grid with Obstacles Elimination
 * You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.
 *
 * Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.
 *
 *
 *
 * Example 1:
 *
 * Input:
 * grid =
 * [[0,0,0],
 *  [1,1,0],
 *  [0,0,0],
 *  [0,1,1],
 *  [0,0,0]],
 * k = 1
 * Output: 6
 * Explanation:
 * The shortest path without eliminating any obstacle is 10.
 * The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 * Example 2:
 *
 * Input:
 * grid =
 * [[0,1,1],
 *  [1,1,1],
 *  [1,0,0]],
 * k = 1
 * Output: -1
 * Explanation:
 * We need to eliminate at least two obstacles to find such a walk.
 *
 */
public class ShortestPathInAGridWithObstaclesElimination {
    /**
     * Time complexity: O(m * n * k)
     */
    private static final int[] X_DIRECTIONS = new int[] {1, 0, 0, -1};
    private static final int[] Y_DIRECTIONS = new int[] {0, 1, -1, 0};

    public int shortestPath(int[][] grid, int k) {
        final int m = grid.length;
        final int n = grid[0].length;

        final Queue<Node> queue = new ArrayDeque<>();
        final Set<List<Integer>> visited = new HashSet<>();

        if (k > m + n - 2) {
            return m + n - 2;
        }
        queue.add(new Node(0, 0, 0, k));
        visited.add(List.of(0, 0, k));

        while(!queue.isEmpty()) {
            final Node node = queue.poll();
            if (node.x == m - 1 && node.y == n - 1) {
                return node.steps;
            }
            for (int i = 0; i < 4; i++) {
                final int newX = node.x + X_DIRECTIONS[i];
                final int newY = node.y + Y_DIRECTIONS[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && node.k - grid[newX][newY] >= 0) {
                    final List<Integer> point = List.of(newX, newY, node.k - grid[newX][newY]);
                    if (!visited.contains(point)) {
                        final Node newNode = new Node(node.steps + 1, newX, newY, node.k - grid[newX][newY]);
                        queue.add(newNode);
                        visited.add(point);
                    }
                }
            }
        }

        return -1;
    }

    static class Node {
        int steps;
        int x;
        int y;
        int k;

        Node(int steps, int x, int y, int k) {
            this.steps = steps;
            this.x = x;
            this.y = y;
            this.k = k;

        }
    }
}
