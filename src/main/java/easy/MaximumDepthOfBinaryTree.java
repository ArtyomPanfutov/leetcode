package easy;

import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 104. Maximum Depth of Binary Tree
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 * Example 3:
 *
 * Input: root = []
 * Output: 0
 * Example 4:
 *
 * Input: root = [0]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
public class MaximumDepthOfBinaryTree {
    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static final class RecursiveSolution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
        }
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static final class StackSolution {
        /**
         * Here the solution with two stacks
         * The first one is for storing nodes to explore later
         * The second is for current path
         * <p>
         * If on top of these stack equal nodes then it means we traversed everything below
         * (Space complexity in worst case O(n) but on balanced trees it would be log(n)
         */
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;

            int max = 0;
            Deque<TreeNode> wq = new ArrayDeque<>();
            Deque<TreeNode> path = new ArrayDeque<>();

            wq.push(root);

            while (!wq.isEmpty()) {
                root = wq.peek();

                if (!path.isEmpty() && root == path.peek()) {
                    max = Math.max(max, path.size());

                    wq.pop();
                    path.pop();
                } else {
                    path.push(root);

                    if (root.left != null) {
                        wq.push(root.left);
                    }

                    if (root.right != null) {
                        wq.push(root.right);
                    }
                }
            }
            return max;
        }
    }
}
