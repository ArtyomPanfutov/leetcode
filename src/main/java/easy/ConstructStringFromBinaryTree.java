package easy;

import datastructures.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * 606. Construct String from Binary Tree
 * Given the root of a binary tree, construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way, and return it.
 *
 * Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4]
 * Output: "1(2(4))(3)"
 * Explanation: Originallay it needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)"
 * Example 2:
 *
 *
 * Input: root = [1,2,3,null,4]
 * Output: "1(2()(4))(3)"
 * Explanation: Almost the same as the first example, except we cannot omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -1000 <= Node.val <= 1000
 */
public class ConstructStringFromBinaryTree {
    class Iterative {
        public String tree2str(TreeNode root) {
            StringBuilder sb = new StringBuilder();

            Deque<TreeNode> deque = new ArrayDeque<>();
            Set<TreeNode> visited = new HashSet<>();
            deque.push(root);

            while (!deque.isEmpty()) {
                TreeNode node = deque.peek();

                if (visited.contains(node)) {
                    deque.pop();
                    sb.append(')');
                } else {
                    visited.add(node);
                    sb.append('(');
                    sb.append(node.val);

                    if (node.left == null && node.right != null) {
                        sb.append("()");
                    }

                    if (node.right != null) {
                        deque.push(node.right);
                    }

                    if (node.left != null) {
                        deque.push(node.left);
                    }
                }
            }

            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
    }
}
