package com.panfutov.leetcode.easy;

import com.panfutov.leetcode.datastructures.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 * Example 2:
 *
 * Input: root = [1]
 * Output: ["1"]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 */
public class BinaryTreePaths {
    public static class DfsSolution {
        public List<String> binaryTreePaths(TreeNode root) {
            return dfs(root, new ArrayList<String>(), new StringBuilder());
        }

        private List<String> dfs(TreeNode root, List<String> result, StringBuilder current) {
            if (root != null) {
                if (current.length() == 0) {
                    current.append(root.val);
                } else {
                    current.append("->").append(root.val);
                }

                if (root.left == null && root.right == null) {
                    result.add(current.toString());
                } else {
                    if (root.left != null) {
                        dfs(root.left, result, new StringBuilder(current));
                    }
                    if (root.right != null) {
                        dfs(root.right, result, new StringBuilder(current));
                    }
                }
            }

            return result;
        }
    }
}
