package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Combinations {
    /**
     * Time complexity: O(n * (n!/(n - k)! * k!)
     * The time complexity is "n times n choose k". "n choose k" equals (n!/((n-k)! * k!)). In full notation is O(n * (n!/((n-k)! * k!))).
     * We will have "n choose k" combinations and in each call we will do O(n) work to copy the array to the answer.
     * Space complexity:
     */
    static class BacktrackingSolution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();

            backtrack(result, new ArrayList<>(), 1, n, k);

            return result;
        }

        private void backtrack(List<List<Integer>> result, List<Integer> temp, int current, int n, int k) {
            if (temp.size() == k) {
                result.add(new ArrayList<>(temp));
            }

            for (int i = current; i <= n; i++) {
                temp.add(i);
                backtrack(result, temp, i + 1, n, k);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
