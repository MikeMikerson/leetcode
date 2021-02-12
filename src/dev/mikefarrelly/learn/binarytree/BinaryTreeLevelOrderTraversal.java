package dev.mikefarrelly.learn.binarytree;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * return its level order traversal as:
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/931/
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main (String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(10);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(18);
        root.right.right = new TreeNode(19);

        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderTree = new ArrayList<>();
        if (root == null) {
            return levelOrderTree;
        }

        int layerSize = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<Integer> tempList = new ArrayList<>();
        tempList.add(root.val);
        levelOrderTree.add(tempList);

        while (!queue.isEmpty()) {
            List<Integer> curList = new ArrayList<>();
            layerSize = queue.size();

            for (int i = 0; i < layerSize; i++) {
                TreeNode cur = queue.remove();
                if (cur.left != null) {
                    curList.add(cur.left.val);
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    curList.add(cur.right.val);
                    queue.add(cur.right);
                }
            }

            // The last iteration will be empty so check that's it's empty to prevent an emptly
            // list as the last element
            if (!curList.isEmpty()) {
                levelOrderTree.add(curList);
            }
        }

        return levelOrderTree;
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
}
