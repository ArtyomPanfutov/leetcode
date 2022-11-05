package easy;

import datastructures.TreeNode;

/**
 * 965. Univalued Binary Tree
 * A binary tree is uni-valued if every node in the tree has the same value.
 *
 * Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,1,1,1,1,null,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [2,2,2,5,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 100].
 * 0 <= Node.val < 100
 */
public class UnivaluedBinaryTree {
    public static class Solution {
        public boolean isUnivalTree(TreeNode root) {
            if (root != null) {
                if (root.left != null && root.left.val != root.val) {
                    return false;
                }
                if (root.right != null && root.right.val != root.val) {
                    return false;
                }
                return isUnivalTree(root.left) && isUnivalTree(root.right);
            }
            return true;
        }
    }
}
