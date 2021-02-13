package dev.mikefarrelly.learn.binarytree;

import java.util.LinkedList;

/**
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * <p>
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 * <p>
 * Example 3:
 * Input: root = []
 * Output: 0
 * <p>
 * Example 4:
 * Input: root = [0]
 * Output: 1
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 * <p>
 * https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/535/
 */
public class MaximumDepthOfBinaryTree {
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

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        System.out.println(maxDepth(node));
    }

    public static int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        int maxDepth = 0;
        maxDepth = getMaxDepth(root, maxDepth, depth + 1);
        return maxDepth;
    }

    private static int getMaxDepth(TreeNode root, int currentMaxDepth, int depth) {
        if (root.left == null && root.right == null) {
            return Math.max(currentMaxDepth, depth);
        }

        if (root.left != null) {
            currentMaxDepth = getMaxDepth(root.left, currentMaxDepth, depth + 1);
        }

        if (root.right != null) {
            currentMaxDepth = getMaxDepth(root.right, currentMaxDepth, depth + 1);
        }
        return currentMaxDepth;
    }

    public int bestRuntime(TreeNode root) {
        if (root == null) return 0;
        int lH = maxDepth(root.left);
        int rH = maxDepth(root.right);
        return Math.max(lH, rH) + 1;
    }

    public int bestMemory(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        nodes.add(root);
        depths.add(1);
        int depth = 0;
        int cur_depth = 0;
        while (!nodes.isEmpty()) {
            root = nodes.poll();
            cur_depth = depths.poll();
            if (root != null) {
                depth = Math.max(cur_depth, depth);
                nodes.add(root.left);
                nodes.add(root.right);
                depths.add(cur_depth + 1);
                depths.add(cur_depth + 1);
            }
        }
        return depth;
    }

    public int averageMemory(TreeNode root) {
        return averageDepth(root);
    }

    private int averageDepth(TreeNode node) {

        if (node == null) {
            return 0;
        }

        return Math.max(1 + averageDepth(node.left), 1 + averageDepth(node.right));
    }
}
