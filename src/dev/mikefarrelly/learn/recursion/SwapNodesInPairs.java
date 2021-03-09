package dev.mikefarrelly.learn.recursion;

import dev.mikefarrelly.learn.linkedlist.classicproblems.ReverseLinkedList;
import dev.mikefarrelly.learn.linkedlist.singly.SinglyLinkedList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * <p>
 * Example 2:
 * Input: head = []
 * Output: []
 * <p>
 * Example 3:
 * Input: head = [1]
 * Output: [1]
 * <p>
 * Constraints:
 * - The number of nodes in the list is in the range [0, 100].
 * - 0 <= Node.val <= 100
 * <p>
 * Follow up: Can you solve the problem without modifying the values
 * in the list's nodes? (i.e., Only nodes themselves may be changed.)
 * <p>
 * https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1681/
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        printNodes(node);
        ListNode swappedNodes = swapPairs(node);
        printNodes(swappedNodes);
    }


    private static void printNodes(ListNode root) {
        ListNode cur = root;
        StringBuilder stringBuilder = new StringBuilder();
        while (cur != null) {
            stringBuilder.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        stringBuilder.append("null");
        System.out.println(stringBuilder.toString());
        System.out.println("============");
    }

    private static ListNode swapPairs(ListNode head) {
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

    public static ListNode otherSolution(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode point = dummy;
        while (point.next != null && point.next.next != null) {
            ListNode swap1 = point.next;
            ListNode swap2 = point.next.next;
            point.next = swap2;
            swap1.next = swap2.next;
            swap2.next = swap1;
            point = swap1;
        }
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
