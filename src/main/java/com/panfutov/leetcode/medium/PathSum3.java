package com.panfutov.leetcode.medium;

import com.panfutov.leetcode.datastructures.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. Path Sum III
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * Example 2:
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 1000].
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 */
public class PathSum3 {
    /**
     * Time complexity: O(n^2)
     */
    public static class BruteforceSolution {
        private int count = 0;

        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return count;
            }

            countFrom(root, targetSum, 0);
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);

            return count;
        }

        private void countFrom(TreeNode node, int target, long sum) {
            if (node == null) {
                return;
            }

            sum += node.val;

            if (target == sum) {
                count++;
            }

            countFrom(node.left, target, sum);
            countFrom(node.right, target, sum);
        }
    }

    public static class PrefixSumSolution {
        private int count = 0;

        public int pathSum(TreeNode root, int targetSum) {
            dfs(root, targetSum, 0, new HashMap<>());
            return count;
        }

        private void dfs(TreeNode node, int target, long current, Map<Long, Integer> prefixSum) {
            if (node == null) {
                return;
            }
            current += node.val;
            if (current == target) {
                count++;
            }
            if (prefixSum.containsKey(current - target)) {
                count += prefixSum.get(current - target);
            }
            prefixSum.put(current, prefixSum.getOrDefault(current, 0) + 1);

            dfs(node.left, target, current, prefixSum);
            dfs(node.right, target, current, prefixSum);

            prefixSum.put(current, prefixSum.getOrDefault(current, 0) - 1);
        }
    }
}
