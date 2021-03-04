package dev.mikefarrelly.learn.binarytree;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * Example 1:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 *
 * Example 2:
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 * Constraints:
 * - The number of nodes in the tree is in the range [1, 1000].
 * - -100 <= Node.val <= 100
 *
 * Follow up: Could you solve it both recursively and iteratively?
 *
 * https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.right = new TreeNode(3);
        node.right.left = new TreeNode(4);
        System.out.println(isSymmetric(node));

        TreeNode newNode = new TreeNode(1);
        newNode.left = new TreeNode(2);
        newNode.right = new TreeNode(2);
        newNode.left.right = new TreeNode(3);
        newNode.right.right = new TreeNode(3);
        System.out.println(isSymmetric(newNode));

        TreeNode another = new TreeNode(1);
        another.left = new TreeNode(0);
        System.out.println(isSymmetric(another));

        TreeNode yetAnother = new TreeNode(1);
        yetAnother.right = new TreeNode(2);
        System.out.println(isSymmetric(yetAnother));

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode curLeft, TreeNode curRight) {
        if (curLeft == null && curRight == null) {
            return true;
        }

        if (curLeft == null || curRight == null) {
            return false;
        }

        return curLeft.val == curRight.val
                && isSymmetric(curLeft.left, curRight.right)
                && isSymmetric(curLeft.right, curRight.left);
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
