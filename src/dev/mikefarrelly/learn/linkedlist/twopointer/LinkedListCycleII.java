package dev.mikefarrelly.learn.linkedlist.twopointer;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
 * connected to. Note that pos is not passed as a parameter.
 * Notice that you should not modify the linked list.
 * <p>
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * <p>
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * <p>
 * Constraints:
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 * <p>
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 * <p>
 * https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1214/
 */
public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next.next = node.next.next.next;

        ListNode anotherNode = new ListNode(1);
        anotherNode.next = new ListNode(2);
        anotherNode.next.next = new ListNode(3);
        anotherNode.next.next.next = new ListNode(4);
        anotherNode.next.next.next.next = new ListNode(5);
        anotherNode.next.next.next.next.next = anotherNode;

        ListNode noCycleNod = new ListNode(100);
        noCycleNod.next = new ListNode(2);
        noCycleNod.next.next = new ListNode(3);
        noCycleNod.next.next.next = new ListNode(4);
        noCycleNod.next.next.next.next = new ListNode(5);

        LinkedListCycleII linkedList = new LinkedListCycleII();

        // 4
        System.out.println(linkedList.detectCycle(node));

        // 1
        System.out.println(linkedList.detectCycle(anotherNode));

        // null
        System.out.println(linkedList.detectCycle(noCycleNod));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    // Also seems to be the average runtime
    public ListNode bestRuntime(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public ListNode bestMemory(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // circle detected
            if (fast == slow) {
                fast = head;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null; // no circle
    }
}
