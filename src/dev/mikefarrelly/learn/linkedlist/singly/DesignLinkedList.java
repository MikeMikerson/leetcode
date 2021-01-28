package dev.mikefarrelly.learn.linkedlist.singly;

/**
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node,
 * and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in
 * the linked list. Assume all nodes in the linked list are 0-indexed.
 *
 * Implement the MyLinkedList class:
 * - MyLinkedList() Initializes the MyLinkedList object.
 * - int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 * - void addAtHead(int val) Add a node of value val before the first element of the linked list.
 *      After the insertion, the new node will be the first node of the linked list.
 * - void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * - void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list.
 *      If index equals the length of the linked list, the node will be appended to the end of the linked list.
 *      If index is greater than the length, the node will not be inserted.
 * - void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 *
 * Example 1:
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 *
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 *
 *
 * Constraints:
 * 0 <= index, val <= 1000
 * Please do not use the built-in LinkedList library.
 * At most 2000 calls will be made to get, addAtHead, addAtTail,  addAtIndex and deleteAtIndex.
 *
 * https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/
 */
public class DesignLinkedList {
    private SinglyListNode head;

    public DesignLinkedList() {
        head = null;
    }

    // Helper function to return the index-th node in the linked list
    private SinglyListNode getNode(int index) {
        SinglyListNode cur = head;
        for (int i = 0; i < index && cur != null; ++i) {
            cur = cur.next;
        }
        return cur;
    }

    private SinglyListNode getTail() {
        SinglyListNode cur = head;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    public void addAtHead(int val) {
        SinglyListNode cur = new SinglyListNode(val);
        cur.next = head;
        head = cur;
        return;
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        SinglyListNode prev = getTail();
        SinglyListNode cur = new SinglyListNode(val);
        prev.next = cur;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }

        SinglyListNode prev = getNode(index - 1);
        if (prev == null) {
            return;
        }

        SinglyListNode cur = new SinglyListNode(val);
        SinglyListNode next = prev.next;
        cur.next = next;
        prev.next = cur;
    }

    public void deleteAtIndex(int index) {
        SinglyListNode cur = getNode(index);
        if (cur == null) {
            return;
        }

        SinglyListNode prev = getNode(index - 1);
        SinglyListNode next = cur.next;
        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }
    }

    private static class SinglyListNode {
        int val;
        SinglyListNode next;
        SinglyListNode(int x) {
            val = x;
        }
    }
}
