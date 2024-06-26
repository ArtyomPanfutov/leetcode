package com.panfutov.leetcode.hard;

import com.panfutov.leetcode.datastructures.TreeNode;

/**
 * 124. Binary Tree Maximum Path Sum
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any path.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * Example 2:
 *
 *
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -1000 <= Node.val <= 1000
 */
public class BinaryTreeMaximumSumPath {
    public static class NoGlobalVarSolution {
        public int maxPathSum(TreeNode root) {
            return dfs(root, new int[]{Integer.MIN_VALUE, 0})[0];
        }

        private int[] dfs(TreeNode node, int[] cur) {
            if (node == null) {
                return new int[]{cur[0], 0};
            }
            int[] left = dfs(node.left, cur);
            int[] right = dfs(node.right, cur);
            int leftMax = Math.max(left[1], 0);
            int rightMax = Math.max(right[1], 0);

            int max = Math.max(right[0], Math.max(left[0], Math.max(node.val + leftMax + rightMax, cur[0])));
            return new int[]{max, node.val + Math.max(leftMax, rightMax)};
        }
    }
    public static class GlobalVarSolution {
        private int MAX = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return MAX;
        }

        private int dfs(TreeNode root) {
            if (root == null) return 0;

            int left = dfs(root.left);
            int right = dfs(root.right);

            int cur = Math.max(root.val, Math.max(left + root.val, right + root.val));

            MAX = Math.max(left + right + root.val, Math.max(MAX, cur));

            return cur;
        }
    }
}
