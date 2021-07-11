package easy;

import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 617. Merge Two Binary Trees
 * You are given two binary trees root1 and root2.
 *
 * Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
 *
 * Return the merged tree.
 *
 * Note: The merging process must start from the root nodes of both trees.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * Output: [3,4,5,5,4,null,7]
 * Example 2:
 *
 * Input: root1 = [1], root2 = [1,2]
 * Output: [2,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in both trees is in the range [0, 2000].
 * -104 <= Node.val <= 104
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        Deque<TreeNode[]> deque = new ArrayDeque<>();
        deque.push(new TreeNode[]{root1, root2});

        while (!deque.isEmpty()) {
            TreeNode[] pair = deque.pop();

            if (pair[0] == null || pair[1] == null) {
                continue;
            }

            pair[0].val += pair[1].val;

            if (pair[0].left == null) {
                pair[0].left = pair[1].left;
            } else {
                deque.push(new TreeNode[] {pair[0].left, pair[1].left});
            }

            if (pair[0].right == null) {
                pair[0].right = pair[1].right;
            } else {
                deque.push(new TreeNode[] {pair[0].right, pair[1].right});
            }
        }
        return root1;
    }
}
