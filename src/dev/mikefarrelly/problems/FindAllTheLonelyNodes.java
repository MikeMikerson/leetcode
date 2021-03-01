package dev.mikefarrelly.problems;

import java.util.ArrayList;
import java.util.List;

public class FindAllTheLonelyNodes {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> lonelyNodes = new ArrayList<>();

        if (root == null || (root.left == null && root.right == null)) {
            return lonelyNodes;
        }

        dfs(root, lonelyNodes);
        return lonelyNodes;
    }

    private void dfs(TreeNode cur, List<Integer> lonelyNodes) {
        if (cur.left != null) {
            dfs(cur.left, lonelyNodes);
        }

        if (cur.right != null) {
            dfs(cur.right, lonelyNodes);
        }

        if (cur.left == null && cur.right != null) {
            lonelyNodes.add(cur.right.val);
        }

        if (cur.right == null && cur.left != null) {
            lonelyNodes.add(cur.left.val);
        }
    }

    public class TreeNode {
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
