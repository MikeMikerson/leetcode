package dev.mikefarrelly.learn.linkedlist.classicproblems;

/**
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * <p>
 * https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1207/
 */
public class RemoveLinkedListElements {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(6);
        node.next = new ListNode(2);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(6);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next.next = new ListNode(6);
        removeElements(node, 6);
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        head = dummyNode;
        while (dummyNode != null && dummyNode.next != null) {
            if (dummyNode.next.val == val) {
                dummyNode.next = dummyNode.next.next;
            } else {
                dummyNode = dummyNode.next;
            }
        }

        return head.next;
    }
}
