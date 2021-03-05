package dev.mikefarrelly.learn.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Invert a binary tree.
 * <p>
 * Example:
 * Input:
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * <p>
 * Output:
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 * Google: 90% of our engineers use the software you wrote (Homebrew),
 * but you can’t invert a binary tree on a whiteboard so f*** off.
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(3);
        System.out.println(invertTree(node));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        swapNodes(queue);

        return root;
    }

    private static void swapNodes(Queue<TreeNode> queue) {
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }

                TreeNode tempNode = cur.left;
                cur.left = cur.right;
                cur.right = tempNode;

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
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

    public TreeNode bestMemory(TreeNode root) {
        if(root!=null)
            bestMemoryInvert(root);

        return root;
    }

    private void bestMemoryInvert(TreeNode node){
        if(node==null)
            return;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        bestMemoryInvert(node.left);
        bestMemoryInvert(node.right);
    }
}
