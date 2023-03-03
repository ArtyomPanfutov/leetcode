package com.panfutov.leetcode.medium;

import com.panfutov.leetcode.datastructures.TreeNode;

import java.util.*;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * BFS approach
     * time and space complexity O(n)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) return Collections.emptyList();

            List<List<Integer>> result = new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                final int size = queue.size();

                for (int i = 0; i < size; i++) {
                    root = queue.poll();

                    level.add(root.val);

                    if (root.left != null) {
                        queue.add(root.left);
                    }

                    if (root.right != null) {
                        queue.add(root.right);
                    }
                }

                if (level.size() > 0) {
                    result.add(level);
                }
            }

            return result;
        }
}
