package dev.mikefarrelly.problems;

import dev.mikefarrelly.node.ListNode;

/**
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by
 * splicing together the nodes of the first two lists.
 *
 * Example 1:
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 * Input: l1 = [], l2 = []
 * Output: []
 *
 * Example 3:
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 *
 * Constraints:
 * - The number of nodes in both lists is in the range [0, 50].
 * - -100 <= Node.val <= 100
 * - Both l1 and l2 are sorted in non-decreasing order.
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode mergedNode = new ListNode();
        ListNode dummyNode = mergedNode;

        while (l1 != null && l2 !=null) {
            if (l1.val == l2.val) {
                mergedNode.next = new ListNode(l1.val);
                mergedNode.next.next = new ListNode(l2.val);
                mergedNode = mergedNode.next.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1.val < l2.val) {
                mergedNode.next = new ListNode(l1.val);
                mergedNode = mergedNode.next;
                l1 = l1.next;
            } else {
                mergedNode.next = new ListNode(l2.val);
                mergedNode = mergedNode.next;
                l2 = l2.next;
            }
        }

        if (l1 == null && l2 != null) {
            mergedNode.next = l2;
        } else if (l1 != null) {
            mergedNode.next = l1;
        }

        return dummyNode.next;
    }

    public ListNode otherSolution(ListNode l1, ListNode l2)
    {
        ListNode sl1=l1;
        ListNode sl2=l2;
        ListNode head=new ListNode(0);
        ListNode newnode=head,t;
        while(sl1!=null && sl2!=null)
        {

            if(sl1.val<sl2.val)
            {
                newnode.next=sl1;
                sl1=sl1.next;
            }
            else
            {
                newnode.next=sl2;
                sl2=sl2.next;
            }
            newnode=newnode.next;

        }
        if(sl1!=null)
        {
            newnode.next=sl1;
        }
        if(sl2!=null)
        {
            newnode.next=sl2;
        }
        return head.next;
    }
}
