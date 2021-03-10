package dev.mikefarrelly.learn.linkedlist.classicproblems;

import dev.mikefarrelly.node.ListNode;
import dev.mikefarrelly.utils.NodeUtils;

import java.util.ArrayList;

/**
 * Reverse a singly linked list.
 * <p>
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * <p>
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * <p>
 * https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1205/
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        NodeUtils.printNodes(node);
        NodeUtils.printNodes(reverseList(node));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode before = null;
        ListNode cur = head;
        ListNode after = null;

        while (cur != null) {
            after = cur.next;
            cur.next = before;
            before = cur;
            cur = after;
        }
        return before;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        return swap(null, head, null);
    }

    private static ListNode swap(ListNode before, ListNode cur, ListNode after) {
        if (cur == null) {
            return before;
        }
        after = cur.next;
        cur.next = before;
        before = cur;
        cur = after;

        return swap(before, cur, after);
    }

    public ListNode bestRuntime(ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        ListNode res = nodes.get(nodes.size() - 1);
        ListNode tmp = res;
        ListNode node = new ListNode();
        for (int i = nodes.size() - 2; i >= 0; i--) {
            node = nodes.get(i);
            tmp.next = node;
            tmp = tmp.next;
        }
        tmp.next = null;
        return res;
    }

    public ListNode bestMemory(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode n1 = head;
        ListNode n2 = head.next;

        while (n2 != null) {
            ListNode temp = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = temp;
        }
        head.next = null;
        return n1;
    }

    public ListNode averageMemory(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return head;
    }

    public ListNode recursionReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = recursionReverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
