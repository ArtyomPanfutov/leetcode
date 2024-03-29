package com.panfutov.leetcode.easy;

import com.panfutov.leetcode.datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 872. Leaf-Similar Trees
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 *
 *
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * Output: true
 * Example 2:
 *
 *
 * Input: root1 = [1,2,3], root2 = [1,3,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in each tree will be in the range [1, 200].
 * Both of the given trees will have values in the range [0, 200].
 */
public class LeafSimilarTrees {
    static class Dfs {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            final List<Integer> leaves1 = getLeaves(root1);
            final List<Integer> leaves2 = getLeaves(root2);

            if (leaves1.size() != leaves2.size()) {
                return false;
            }

            for (int i = 0; i < leaves1.size(); i++) {
                if (!leaves1.get(i).equals(leaves2.get(i))) {
                    return false;
                }
            }

            return true;
        }

        private List<Integer> getLeaves(TreeNode node) {
            final List<Integer> result = new ArrayList<>();
            final Deque<TreeNode> deque = new ArrayDeque<>();

            deque.push(node);

            while (!deque.isEmpty()) {
                final TreeNode current = deque.pop();

                if (current.left == null && current.right == null) {
                    result.add(current.val);
                } else {
                    if (current.left != null) {
                        deque.push(current.left);
                    }
                    if (current.right != null) {
                        deque.push(current.right);
                    }
                }
            }

            return result;
        }
    }
}
