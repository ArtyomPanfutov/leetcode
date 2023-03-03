package com.panfutov.leetcode.easy;

import com.panfutov.leetcode.datastructures.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 501. Find Mode in Binary Search Tree
 *
 * Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
 *
 * If the tree has more than one mode, return them in any order.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: root = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 *
 *
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class FindModeInBinarySearchTree {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static class LinearSolution {
        public int[] findMode(TreeNode root) {
            Map<Integer, Integer> map = new HashMap<>();

            traverse(root, map);

            int max = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                }
            }

            List<Integer> result = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == max) {
                    result.add(entry.getKey());
                }
            }

            int[] arr = new int[result.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = result.get(i);
            }

            return arr;

        }

        private void traverse(TreeNode node, Map<Integer, Integer> map) {
            if (node == null) {
                return;
            }

            Integer count = map.getOrDefault(node.val, 0) + 1;

            map.put(node.val, count);

            traverse(node.left, map);
            traverse(node.right, map);
        }
    }

}
