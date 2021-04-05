package dev.mikefarrelly.problems;

import dev.mikefarrelly.learn.binarytree.BinaryTreeLevelOrderTraversal;
import dev.mikefarrelly.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 */
public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(10);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(19);

        mergeTrees(root, root);
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            // If root1 is null then there's nowhere for root1 to continue, so simply set it to root2
            // If root2 happens to be null as well, that's also find because then we will simply
            // have nothing in that location.
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        // The instructions say to return a new binary tree, so we can assume that we don't want to modify any of the
        // arguments
        TreeNode mergedTree = new TreeNode(root1.val + root2.val);
        mergedTree.left = mergeTrees(root1.left, root2.left);
        mergedTree.right = mergeTrees(root1.right, root2.right);

        return mergedTree;
    }
}
