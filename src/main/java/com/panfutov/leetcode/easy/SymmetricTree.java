package com.panfutov.leetcode.easy;

import com.panfutov.leetcode.datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 */
public class SymmetricTree {
    /**
     * Recursice approach
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null || eq(root.left, root.right);
    }

    private boolean eq(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        return left != null && right != null && left.val == right.val && eq(left.left, right.right) && eq(right.left, left.right);
    }


    /**
     * Iterative approach
     */
    public boolean isSymmetricIterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) continue;
            if (left == null || right == null) return false;

            if (left.val != right.val) return false;

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }

}
