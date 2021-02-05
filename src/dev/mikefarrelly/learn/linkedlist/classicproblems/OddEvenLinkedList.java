package dev.mikefarrelly.learn.linkedlist.classicproblems;

import dev.mikefarrelly.learn.linkedlist.singly.DesignLinkedList;
import dev.mikefarrelly.learn.linkedlist.singly.SinglyLinkedList;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are
 * talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example 1:
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * <p>
 * Example 2:
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * <p>
 * Constraints:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 * The length of the linked list is between [0, 10^4].
 * <p>
 * https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1208/
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);

        oddEvenList(node);

    }

    public static ListNode oddEvenList(ListNode head) {
        // If the head is null or if the size of the node is at most two nodes long, then simply return the node
        // because the order won't change.
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = new ListNode(-1);
        head = odd;
        int count = 1;

        while ((odd != null && odd.next != null)) {
            if (count % 2 != 0) {
                addAtTail(even, odd.next.val);
                odd.next = odd.next.next;
            } else {
                odd = odd.next;
            }
            count++;
        }

        odd.next = even.next;
        printNodes(head);
        return head;
    }

    public static void addAtTail(ListNode head, int val) {
        ListNode prev = getTail(head);
        ListNode cur = new ListNode(val);
        prev.next = cur;
    }

    private static ListNode getTail(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode() {
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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
        System.out.println("============");
    }

    public ListNode bestRuntime(ListNode head) {
        if (head == null) return null;

        ListNode dummyHeadOdd = new ListNode();
        ListNode dummyHeadEven = new ListNode();
        dummyHeadOdd.next = head;
        ListNode tailOdd = head;
        ListNode tailEven = null;
        ListNode cur = null;
        if (head.next != null) {
            dummyHeadEven.next = head.next;
            tailEven = dummyHeadEven.next;
            cur = tailEven.next;
        }

        while (cur != null) {
            tailOdd.next = cur;
            tailEven.next = cur.next;
            if (cur.next != null) {
                cur = cur.next.next;
            } else {
                cur = null;
            }
            tailOdd = tailOdd.next;
            tailEven = tailEven.next;
        }

        tailOdd.next = dummyHeadEven.next;
        return dummyHeadOdd.next;
    }

    public ListNode bestMemory(ListNode head) {
        if (head == null) return null;

        ListNode odd = head, even = odd.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public ListNode averageMemory(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head, even = odd.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;

    }
}
