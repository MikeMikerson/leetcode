package dev.mikefarrelly.problems;

import java.util.Stack;

/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has
 * a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * <p>
 * A leaf is a node with no children.
 * <p>
 * Example 1:
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * <p>
 * Example 2:
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * <p>
 * Example 3:
 * Input: root = [1,2], targetSum = 0
 * Output: false
 * <p>
 * Constraints:
 * - The number of nodes in the tree is in the range [0, 5000].
 * - -1000 <= Node.val <= 1000
 * - -1000 <= targetSum <= 1000
 * <p>
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        System.out.println(hasPathSum(node, 8));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    private static boolean dfs(TreeNode cur, int targetSum) {
        if (cur == null) {
            return false;
        }

        if (cur.left == null && cur.right == null && cur.val == targetSum) {
            return true;
        }

        int curVal = targetSum - cur.val;
        return dfs(cur.left, curVal) || dfs(cur.right, curVal);
    }

    public boolean iterativeSolution(TreeNode root, int targetSum) {
        if (root == null) return false;

        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> vals = new Stack<>();
        nodes.push(root);
        vals.push(root.val);

        while (!nodes.isEmpty()) {
            TreeNode tempNode = nodes.pop();
            Integer tempVal = vals.pop();

            if (tempNode.left == null && tempNode.right == null && tempVal == targetSum) return true;

            if (tempNode.left != null) {
                nodes.push(tempNode.left);
                vals.push(tempVal + tempNode.left.val);
            }

            if (tempNode.right != null) {
                nodes.push(tempNode.right);
                vals.push(tempVal + tempNode.right.val);
            }
        }

        return false;
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
