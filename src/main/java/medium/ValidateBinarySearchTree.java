package medium;

import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
    /**
     * In order iterative solution
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;

        TreeNode prev = null;

        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (prev != null && prev.val >= root.val) return false;

            prev = root;
            root = root.right;
        }

        return true;
    }
}
