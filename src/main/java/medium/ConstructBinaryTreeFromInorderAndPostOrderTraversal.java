package medium;

import datastructures.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 *
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 *
 * Constraints:
 *
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 */
public class ConstructBinaryTreeFromInorderAndPostOrderTraversal {
    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            final Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return construct(inorder, postorder, map, 0, inorder.length - 1, 0, postorder.length - 1);
        }

        private TreeNode construct(int[] inorder, int[] postorder, Map<Integer, Integer> map,
                                   int inorderLeft, int inorderRight, int postorderLeft, int postorderRight) {

            if (inorderRight < inorderLeft || postorderRight < postorderLeft) {
                return null;
            }

            final TreeNode root = new TreeNode(postorder[postorderRight]);
            final int index = map.get(root.val);

            root.left = construct(inorder, postorder, map, inorderLeft, index - 1, postorderLeft, postorderLeft + (index - 1 - inorderLeft));
            root.right = construct(inorder, postorder, map, index + 1, inorderRight, postorderLeft + (index - inorderLeft), postorderRight - 1);

            return root;
        }
    }
}
