package medium;

import datastructures.TreeNode;

import java.util.*;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * BFS approach
     * time and space complexity O(n)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(root.val));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            final int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null) {
                    level.add(node.left.val);
                    q.add(node.left);
                }

                if (node.right != null) {
                    level.add(node.right.val);
                    q.add(node.right);
                }
            }

            if (level.size() > 0) {
                result.add(level);
            }
        }

        return result;
    }
}
