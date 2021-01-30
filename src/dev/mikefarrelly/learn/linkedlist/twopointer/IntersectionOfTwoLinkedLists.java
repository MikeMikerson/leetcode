package dev.mikefarrelly.learn.linkedlist.twopointer;

/**
 * Example 1:
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5].
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * <p>
 * Example 2:
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4].
 * There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 * <p>
 * Example 3:
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5].
 * Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * <p>
 * Notes:
 * - If the two linked lists have no intersection at all, return null.
 * - The linked lists must retain their original structure after the function returns.
 * - You may assume there are no cycles anywhere in the entire linked structure.
 * - Each value on each linked list is in the range [1, 10^9].
 * - Your code should preferably run in O(n) time and use only O(1) memory.
 * <p>
 * https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1215/
 */
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        if (headA == headB) {
            return headA;
        }

        int aLength = 0;
        int bLength = 0;

        ListNode nodeA = headA;
        while (nodeA != null) {
            nodeA = nodeA.next;
            aLength++;
        }

        ListNode nodeB = headB;
        while (nodeB != null) {
            nodeB = nodeB.next;
            bLength++;
        }

        int difference;
        if (aLength >= bLength) {
            difference = aLength - bLength;
        } else {
            difference = bLength - aLength;
        }

        nodeA = headA;
        nodeB = headB;
        if (aLength > bLength) {
            for (int i = 0; i < difference; i++) {
                nodeA = nodeA.next;
            }
        } else {
            for (int i = 0; i < difference; i++) {
                nodeB = nodeB.next;
            }
        }

        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return nodeA;
    }
}
