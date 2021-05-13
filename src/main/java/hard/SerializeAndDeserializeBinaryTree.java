package hard;

import datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 * Example 4:
 *
 * Input: root = [1,2]
 * Output: [1,2]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 */
public class SerializeAndDeserializeBinaryTree {
    /**
     * Pretty straight forward solution
     * Constructs a string with node values with a comma as a delimiter
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    private static final String DELIMITER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.poll();

            if (root != null) {
                sb.append(root.val);
                queue.add(root.left);
                queue.add(root.right);
            } else {
                sb.append("$");
            }

            sb.append(DELIMITER);
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");

        if (nodes.length == 0 || nodes[0].equals("$")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (int i = 1; i < nodes.length; i++) {
            if (nodes[i].equals("$")) {
                if (i % 2 == 0) queue.poll();
                continue;
            }

            TreeNode node = new TreeNode(Integer.parseInt(nodes[i]));
            TreeNode prev = queue.peek();

            if (i % 2 == 0) {
                prev.right = node;
                queue.poll();
            } else {
                prev.left = node;
            }

            queue.add(node);
        }

        return root;
    }
}
