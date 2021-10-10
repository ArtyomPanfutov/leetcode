package medium;

import datastructures.TreeNode;

/**
 * 99. Recover Binary Search Tree
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
 * Example 2:
 *
 *
 * Input: root = [3,1,4,null,null,2]
 * Output: [2,1,4,null,null,3]
 * Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 1000].
 * -231 <= Node.val <= 231 - 1
 *
 *
 * Follow up: A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?
 */
public class RecoverBinarySearchTree {
    /**
     * Time complexity: O(m)
     * Space complexity: O(1)
     */
    static class MorrisTraversal {
        public void recoverTree(TreeNode root) {
            TreeNode node = root;
            TreeNode prev = null;
            TreeNode first = null;
            TreeNode second = null;

            while (node != null) {
                if (node.left != null) {
                    TreeNode temp = node.left;

                    while (temp.right != null && temp.right != node) {
                        temp = temp.right;
                    }

                    if (temp.right != null) {
                        if (prev != null && prev.val > node.val) {
                            if (first == null) {
                                first = prev;
                                second = node;
                            } else {
                                second = node;
                            }
                        }
                        temp.right = null;
                        prev = node;
                        node = node.right;
                    } else {
                        temp.right = node;
                        node = node.left;
                    }
                } else {
                    if (prev != null && prev.val > node.val) {
                        if (first == null) {
                            first = prev;
                            second = node;
                        } else {
                            second = node;
                        }
                    }
                    prev = node;
                    node = node.right;
                }
            }

            if (first != null && second != null) {
                final int temp = first.val;
                first.val = second.val;
                second.val = temp;
            }
        }
    }
}
