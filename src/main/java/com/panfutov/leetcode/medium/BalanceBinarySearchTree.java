package com.panfutov.leetcode.medium;

import com.panfutov.leetcode.datastructures.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Balance a Binary Search Tree
 * Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.
 *
 * A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,null,3,null,4,null,null]
 * Output: [2,1,3,null,null,null,4]
 * Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
 * Example 2:
 *
 *
 * Input: root = [2,1,3]
 * Output: [2,1,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 105
 */
public class BalanceBinarySearchTree {
    public static class Solution {
        public TreeNode balanceBST(TreeNode root) {
            List<Integer> values = new ArrayList<>();
            collectValuesInorder(root, values);

            return buildTree(values, 0, values.size() - 1);
        }

        public void collectValuesInorder(TreeNode node, List<Integer> values) {
            if (node == null) {
                return;
            }

            collectValuesInorder(node.left, values);
            values.add(node.val);
            collectValuesInorder(node.right, values);
        }

        private TreeNode buildTree(List<Integer> values, int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = (left + right) / 2;

            var node = new TreeNode(values.get(mid));
            node.left = buildTree(values, left, mid - 1);
            node.right = buildTree(values, mid + 1, right);
            return node;
        }
    }
}
