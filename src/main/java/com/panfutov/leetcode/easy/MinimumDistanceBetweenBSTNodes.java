package com.panfutov.leetcode.easy;

import com.panfutov.leetcode.datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 783. Minimum Distance Between BST Nodes
 * Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,6,1,3]
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 100].
 * 0 <= Node.val <= 105
 *
 *
 * Note: This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;

        Deque<TreeNode> deque = new ArrayDeque<>();

        TreeNode prev = null;
        TreeNode node = root;
        while (!deque.isEmpty() || node != null) {
            while (node != null) {
                deque.push(node);
                node = node.left;
            }

            node = deque.pop();

            if (prev != null) {
                min = Math.min(min, node.val - prev.val);
            }

            prev = node;
            node = node.right;
        }

        return min;
    }
}
