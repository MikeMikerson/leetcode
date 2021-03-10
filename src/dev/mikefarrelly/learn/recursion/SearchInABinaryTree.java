package dev.mikefarrelly.learn.recursion;

import dev.mikefarrelly.node.TreeNode;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 * <p>
 * Find the node in the BST that the node's value equals val and return the
 * subtree rooted with that node. If such a node does not exist, return null.
 * <p>
 * Example 1:
 * Input: root = [4,2,7,1,3], val = 2
 * Output: [2,1,3]
 * <p>
 * Example 2:
 * Input: root = [4,2,7,1,3], val = 5
 * Output: []
 * <p>
 * Constraints:
 * - The number of nodes in the tree is in the range [1, 5000].
 * - 1 <= Node.val <= 107
 * - root is a binary search tree.
 * - 1 <= val <= 107
 * <p>
 * https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3233/
 */
public class SearchInABinaryTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }

        if (root.val == val) {
            return root;
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    // Not my solution, pulled from LeetCode
    public TreeNode otherIterative(TreeNode root, int val) {
        TreeNode curr = root;
        while (curr != null) {
            if (val < curr.val) {
                curr = curr.left;
            } else if (val > curr.val) {
                curr = curr.right;
            } else if (val == curr.val) {
                return curr;
            }
        }
        return null;
    }
}
