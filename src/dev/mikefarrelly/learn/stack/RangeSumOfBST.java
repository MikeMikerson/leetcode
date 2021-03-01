package dev.mikefarrelly.learn.stack;

/**
 * Given the root node of a binary search tree, return the sum of values of all
 * nodes with a value in the range [low, high].
 * <p>
 * Example 1:
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * <p>
 * Example 2:
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 * <p>
 * Constraints:
 * = The number of nodes in the tree is in the range [1, 2 * 104].
 * = 1 <= Node.val <= 105
 * = 1 <= low <= high <= 105
 * = All Node.val are unique.
 * <p>
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBST {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(7);
        node.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(node, 7, 15));

        TreeNode newNode = new TreeNode(10);
        newNode.left = new TreeNode(5);
        newNode.left.left = new TreeNode(3);
        newNode.left.left.left = new TreeNode(1);
        newNode.left.right = new TreeNode(7);
        newNode.left.right.left = new TreeNode(6);
        newNode.right = new TreeNode(15);
        newNode.right.left = new TreeNode(13);
        newNode.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(newNode, 6, 10));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        return dfs(root, 0, low, high);
    }

    public static int dfs(TreeNode cur, int curSum, int low, int high) {
        if (cur.left != null) {
            curSum = dfs(cur.left, curSum, low, high);
        }

        if (cur.right != null) {
            curSum = dfs(cur.right, curSum, low, high);
        }

        int curVal = cur.val;
        if (curVal >= low && curVal <= high) {
            curSum += curVal;
        }

        return curSum;
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
