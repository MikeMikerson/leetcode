package dev.mikefarrelly.problems;

import dev.mikefarrelly.node.TreeNode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameterOf(root);
        return diameter;
    }

    public int diameterOf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = 0;
        if (root.left != null) {
            left = diameterOf(root.left) + 1;
        }

        int right = 0;
        if (root.right != null) {
            right = diameterOf(root.right) + 1;
        }

        int currentMax = left + right;
        int greaterSide = Math.max(left, right);
        diameter = Math.max(diameter, currentMax);

        return greaterSide;
    }
}
