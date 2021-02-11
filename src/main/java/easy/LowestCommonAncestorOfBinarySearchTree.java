package easy;

import datastructures.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 */
public class LowestCommonAncestorOfBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        while (current != null) {
            if (current.val > p.val && current.val > q.val) {
                current = current.left;
            } else if (current.val < p.val && current.val < q.val) {
                current = current.right;
            } else {
                return current;
            }
        }

        return null;
    }
}
