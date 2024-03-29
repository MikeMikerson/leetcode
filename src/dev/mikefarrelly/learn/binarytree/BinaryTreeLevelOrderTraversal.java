package dev.mikefarrelly.learn.binarytree;

import javax.swing.tree.TreeNode;
import java.util.*;

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
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(10);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(18);
//        root.right.right = new TreeNode(19);
//
//        System.out.println(levelOrder(root));
        List<Integer> list1 = new ArrayList<>();
        list1.add(11);
        list1.add(2);
        list1.add(4);
        System.out.println(reverseArray(list1));
    }

    public static List<Integer> reverseArray(List<Integer> a) {
        if (a == null || a.size() < 1) return a;

        int listSize = a.size();
        // List<Integer> result = new ArrayList<>();
        // for (int i = listSize-1; i >= 0; i--) {
        //     result.add(a.get(i));
        // }

        // return result;
        for (int i = 0, j = listSize-1; i < j; i++, j--) {
            // 1, 2, 3, 4
            //    i  j
            // 4, 2, 3, 1
            // 4, 3, 2, 1
            int temp = a.get(i);
            a.set(a.get(i), a.get(j));
            a.set(a.get(j), temp);
        }

        return a;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderTree = new ArrayList<>();
        if (root == null) {
            return levelOrderTree;
        }

        int layerSize = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> curList = new ArrayList<>();
            layerSize = queue.size();

            for (int i = 0; i < layerSize; i++) {
                TreeNode cur = queue.remove();
                curList.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }

            levelOrderTree.add(curList);
        }

        return levelOrderTree;
    }

    public List<List<Integer>> bestRuntime(TreeNode root) {
        Deque<TreeNode> d = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        d.addLast(root);
        while (!d.isEmpty()) {
            int size = d.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = d.pollFirst();
                l.add(t.val);
                if (t.left != null) {
                    d.addLast(t.left);
                }
                if (t.right != null) {
                    d.addLast(t.right);
                }
            }
            result.add(l);
        }
        return result;
    }

    public List<List<Integer>> bestMemory(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> cur = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                cur.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(cur);
        }
        return res;
    }

    public List<List<Integer>> leetCodeAnswer(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        TreeNode cur;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> subAns = new LinkedList<Integer>();
            for (int i = 0; i < size; ++i) {        // traverse nodes in the same level
                cur = q.poll();
                subAns.add(cur.val);                // visit the root
                if (cur.left != null) {
                    q.offer(cur.left);              // push left child to queue if it is not null
                }
                if (cur.right != null) {
                    q.offer(cur.right);             // push right child to queue if it is not null
                }
            }
            ans.add(subAns);
        }
        return ans;
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
