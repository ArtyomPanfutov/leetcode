package com.panfutov.leetcode.easy;

import com.panfutov.leetcode.datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 572. Subtree of Another Tree
 *
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [3,4,5,1,2,null,null,0], subRoot = [4,1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the root tree is in the range [1, 2000].
 * The number of nodes in the subRoot tree is in the range [1, 1000].
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 */
public class SubtreeOfAnotherTree {
    /**
     * Time complexity: O(N * M)
     * Space complexity: O(N * M) (Queue for a node1 and call stack for a node2)
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (eq(node, subRoot)) {
                return true;
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return false;
    }

    private boolean eq(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null & node2 != null || node1 != null && node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return eq(node1.left, node2.left) && eq(node1.right, node2.right);
    }
}
