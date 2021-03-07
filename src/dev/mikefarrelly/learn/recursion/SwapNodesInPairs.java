package dev.mikefarrelly.learn.recursion;

import dev.mikefarrelly.learn.linkedlist.singly.SinglyLinkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 *
 * Example 2:
 * Input: head = []
 * Output: []
 *
 * Example 3:
 * Input: head = [1]
 * Output: [1]
 *
 * Constraints:
 * - The number of nodes in the list is in the range [0, 100].
 * - 0 <= Node.val <= 100
 *
 * Follow up: Can you solve the problem without modifying the values
 * in the list's nodes? (i.e., Only nodes themselves may be changed.)
 *
 * https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1681/
 */
public class SwapNodesInPairs {
    public static void main (String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        printNodes(node);
        ListNode swappedNodes = swapPairsWithVal(node);
        printNodes(swappedNodes);
    }

    private static void printNodes(ListNode head) {
        ListNode cur = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (cur != null) {
            stringBuilder.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        stringBuilder.append("null");
        System.out.println(stringBuilder.toString());
        System.out.println("============");    }

    private static ListNode swapPairsWithVal(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;

        while (cur != null && cur.next != null) {
            int temp = cur.val;
            cur.val = cur.next.val;
            cur.next.val = temp;
            cur = cur.next.next;
        }

        return head;
    }

    private static ListNode swapPairsWithNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;

        while (cur != null && cur.next != null) {
            
        }

        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
