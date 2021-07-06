package easy;

import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 543. Diameter of Binary Tree
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3is the length of the path [4,2,1,3] or [5,2,1,3].
 * Example 2:
 *
 * Input: root = [1,2]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -100 <= Node.val <= 100
 */
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int max = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);

        Map<TreeNode, Integer> map = new HashMap<>();

        while (!deque.isEmpty()) {
            TreeNode node = deque.peek();
            if (node.left != null && !map.containsKey(node.left)) {
                deque.push(node.left);
            } else if (node.right != null && !map.containsKey(node.right)) {
                deque.push(node.right);
            } else {
                node = deque.pop();

                int left = map.getOrDefault(node.left, 0);
                int right = map.getOrDefault(node.right, 0);

                int nodeMax = 1 + Math.max(left, right);

                max = Math.max(left + right, max);

                map.put(node, nodeMax);
            }
        }

        return max;
    }
}
