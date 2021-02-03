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

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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

    public ListNode bestRuntime(ListNode head, int val) {
        head = bestRuntimeSeekHead(head, val);
        if (head == null)
            return null;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return head;
    }

    public ListNode bestRuntimeSeekHead(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        return head;
    }

    public ListNode bestMemory(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy, next = dummy.next;
        while (curr != null) {
            next = curr.next;
            if (next != null && next.val == val) {
                while (next != null && next.val == val) {
                    next = next.next;
                }
                curr.next = next;
            }
            curr = next;
        }
        return dummy.next;
    }

    public ListNode averageMemory(ListNode head, int val) {
        if (head == null) return null;
        ListNode rt = new ListNode(0), pre, now = head;
        rt.next = head;
        pre = rt;
        while (now != null) {
            if (now.val == val) {
                pre.next = now.next;
                now = now.next;
            } else {
                pre = now;
                now = now.next;
            }
        }
        return rt.next;
    }
}
