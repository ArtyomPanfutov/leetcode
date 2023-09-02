package com.panfutov.leetcode.easy;

import com.panfutov.leetcode.datastructures.TreeNode;

/**
 * Count Complete Tree Nodes
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 *
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Design an algorithm that runs in less than O(n) time complexity.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5,6]
 * Output: 6
 * Example 2:
 *
 * Input: root = []
 * Output: 0
 * Example 3:
 *
 * Input: root = [1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5 * 104].
 * 0 <= Node.val <= 5 * 104
 * The tree is guaranteed to be complete.
 */
public class CountCompleteTreeNodes {
    public static class Solution {
        public int countNodes(TreeNode root) {
            int height = height(root);
            TreeNode node = root;
            int count = 0;
            while (node != null) {
                int rightHeight = height(node.right);
                if (height == rightHeight + 1) {
                    count += Math.pow(2, height); // or count += 1 << height
                    node = node.right;
                } else {
                    count += Math.pow(2, height - 1); // or count += 1 << height - 1
                    node = node.left;
                }
                height--;
            }
            return count;
        }

        private int height(TreeNode node) {
            return node == null ? -1 : 1 + height(node.left);
        }
    }
}
