package com.panfutov.leetcode.medium;

import com.panfutov.leetcode.datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1161. Maximum Level Sum of a Binary Tree
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 *
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 * Example 2:
 *
 * Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 */
public class MaximumLevelSumOfBinaryTree {
    public static class Solution {
        public int maxLevelSum(TreeNode root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);

            int maxSum = Integer.MIN_VALUE;
            int maxLvl = 0;
            int curLvl = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                int sum = 0;
                for (int i = 0;i < size; i++) {
                    var node = queue.poll();
                    sum += node.val;
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    maxLvl = curLvl;
                }
                curLvl++;
            }
            return maxLvl;
        }
    }
}
