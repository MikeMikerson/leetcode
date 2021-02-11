package dev.mikefarrelly.learn.binarytree;

import java.util.*;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 * <p>
 * Example 2:
 * Input: root = []
 * Output: []
 * <p>
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 * <p>
 * Example 4:
 * Input: root = [1,2]
 * Output: [1,2]
 * <p>
 * Example 5:
 * Input: root = [1,null,2]
 * Output: [1,2]
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * <p>
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * <p>
 * https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(preorderTraversal(root));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderNodes = new ArrayList<>();
        if (root == null) {
            return preorderNodes;
        }

        traverseNode(root, preorderNodes);
        return preorderNodes;
    }

    private static void traverseNode(TreeNode cur, List<Integer> preorderNodes) {
        preorderNodes.add(cur.val);
        if (cur.left != null) {
            traverseNode(cur.left, preorderNodes);
        }

        if (cur.right != null) {
            traverseNode(cur.right, preorderNodes);
        }
    }

    public List<Integer> bestSolutionIterative(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode current = deque.pop();
            list.add(current.val);
            if (current.right != null) {
                deque.push(current.right);
            }
            if (current.left != null) {
                deque.push(current.left);
            }

        }

        return list;
    }

    public List<Integer> bestMemory(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ls = new ArrayList<>();
        TreeNode node = root;
        while (!st.isEmpty() || node != null) {
            if (node != null) {
                ls.add(node.val);
                st.push(node);
                node = node.left;
            } else {
                node = st.pop();
                node = node.right;
            }
        }
        return ls;
    }
}
