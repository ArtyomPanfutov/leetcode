package easy;

import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 *
 *
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
 */
public class ConvertSortedArrayToBinarySearchTree {
    /**
     * Recursive solution
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(0, nums.length - 1, nums);
    }

    private TreeNode convert(int start, int end, int[] nums) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = convert(start, mid - 1, nums);
        node.right = convert(mid + 1, end, nums);

        return node;
    }

    /**
     * Iterative solution with 3 stacks
     */
    public TreeNode sortedArrayToBSTIterative(int[] nums) {
        if (nums.length == 0) return null;

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode head = new TreeNode();
        stack.push(head);

        Deque<Integer> leftRange = new ArrayDeque<>();
        leftRange.push(0);

        Deque<Integer> rightRange = new ArrayDeque<>();
        rightRange.push(nums.length - 1);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            int left = leftRange.pop();
            int right = rightRange.pop();

            int mid = left + (right - left) / 2;
            node.val = nums[mid];

            if (left < mid) {
                node.left = new TreeNode();
                stack.push(node.left);

                leftRange.push(left);
                rightRange.push(mid - 1);
            }

            if (right > mid) {
                node.right = new TreeNode();
                stack.push(node.right);

                leftRange.push(mid + 1);
                rightRange.push(right);
            }
        }

        return head;
    }
}
