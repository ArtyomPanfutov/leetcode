package medium;

import java.util.*;

/**
 * 1514. Path with Maximum Probability
 * You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].
 *
 * Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.
 *
 * If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
 * Output: 0.25000
 * Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
 * Example 2:
 *
 *
 *
 * Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
 * Output: 0.30000
 * Example 3:
 *
 *
 *
 * Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
 * Output: 0.00000
 * Explanation: There is no path between 0 and 2.
 *
 *
 * Constraints:
 *
 * 2 <= n <= 10^4
 * 0 <= start, end < n
 * start != end
 * 0 <= a, b < n
 * a != b
 * 0 <= succProb.length == edges.length <= 2*10^4
 * 0 <= succProb[i] <= 1
 * There is at most one edge between every two nodes.
 */
public class PathWithMaximumProbability {
    /**
     * Time complexity: O(V + Elog(V))
     */
    static class Dijkstra {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            final Map<Integer, List<int[]>> graph = new HashMap<>();

            for (int i = 0; i < edges.length; i++) {
                final int a = edges[i][0];
                final int b = edges[i][1];

                final List<int[]> edgeToB = graph.computeIfAbsent(a, x -> new ArrayList<>());
                edgeToB.add(new int[]{b, i});

                final List<int[]> edgeToA = graph.computeIfAbsent(b, x -> new ArrayList<>());
                edgeToA.add(new int[]{a, i});
            }

            final double[] odds = new double[n];
            odds[start] = 1;

            final Queue<Integer> queue = new PriorityQueue<>(
                    Comparator.comparingDouble((Integer index) -> odds[index]).reversed()
            );

            queue.add(start);
            while(!queue.isEmpty()) {
                final int current = queue.poll();

                if (current == end) {
                    return odds[end];
                }

                final List<int[]> neighbors = graph.getOrDefault(current, Collections.emptyList());
                for (int[] neighbor : neighbors) {
                    final int node = neighbor[0];
                    final int index = neighbor[1];

                    if (odds[current] * succProb[index] > odds[node]) {
                        odds[node] = odds[current] * succProb[index];
                        queue.add(node);
                    }
                }
            }

            return 0.0;        }
    }
}
