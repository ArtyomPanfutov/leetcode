package com.panfutov.leetcode.medium;

import com.panfutov.leetcode.datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 113. Path Sum II
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 * Example 3:
 *
 * Input: root = [1,2], targetSum = 0
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class PathSumII {
    static class Dfs {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> result = new ArrayList<>();
            Deque<TreeNode> deque = new ArrayDeque<>();
            int currentSum = 0;
            List<Integer> currentPath = new ArrayList<>();

            TreeNode node = root;
            TreeNode prev = null;
            while (node != null || !deque.isEmpty()) {
                while (node != null) {
                    deque.push(node);
                    currentSum += node.val;
                    currentPath.add(node.val);
                    node = node.left;
                }
                node = deque.peek();

                if (node.right != null && node.right != prev) {
                    node = node.right;
                } else {
                    if (node.left == null && node.right == null && currentSum == targetSum) {
                        result.add(new ArrayList<>(currentPath));
                    }
                    deque.pop();
                    currentPath.remove(currentPath.size() - 1);
                    currentSum -= node.val;
                    prev = node;
                    node = null;
                }

            }

            return result;
        }
    }
}
