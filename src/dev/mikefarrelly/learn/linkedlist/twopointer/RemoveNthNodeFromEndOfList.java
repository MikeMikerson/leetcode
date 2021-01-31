package dev.mikefarrelly.learn.linkedlist.twopointer;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Follow up: Could you do this in one pass?
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * <p>
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * <p>
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 * <p>
 * Constraints:
 * - The number of nodes in the list is sz.
 * - 1 <= sz <= 30
 * - 0 <= Node.val <= 100
 * - 1 <= n <= sz
 * <p>
 * https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/
 */
public class RemoveNthNodeFromEndOfList {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        if (head.next == null && n == 1) {
            return null;
        }

        int size = 1;

        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            size++;
        }

        if (size == n) {
            head = head.next;
            return head;
        }

        int diff = size - n;

        cur = head;

        for (int i = 1; i < diff; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;
        return head;
    }

    public ListNode bestRuntime(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode first = start;
        ListNode second = start;
        start.next = head;

        int i = 0;
        while (first != null) {
            if (i > n)
                second = second.next;
            first = first.next;
            i++;
        }

        second.next = second.next.next;
        return start.next;
    }

    public ListNode bestMemory(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}
