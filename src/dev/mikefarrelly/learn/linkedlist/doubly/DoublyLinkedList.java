package dev.mikefarrelly.learn.linkedlist.doubly;

/**
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node,
 * and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in
 * the linked list. Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement the MyLinkedList class:
 * - MyLinkedList() Initializes the MyLinkedList object.
 * - int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 * - void addAtHead(int val) Add a node of value val before the first element of the linked list.
 * After the insertion, the new node will be the first node of the linked list.
 * - void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * - void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list.
 * If index equals the length of the linked list, the node will be appended to the end of the linked list.
 * If index is greater than the length, the node will not be inserted.
 * - void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 * <p>
 * Example 1:
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 * <p>
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 * <p>
 * <p>
 * Constraints:
 * 0 <= index, val <= 1000
 * Please do not use the built-in LinkedList library.
 * At most 2000 calls will be made to get, addAtHead, addAtTail,  addAtIndex and deleteAtIndex.
 * <p>
 * https://leetcode.com/explore/learn/card/linked-list/210/doubly-linked-list/1294/
 */
public class DoublyLinkedList {
    public DoublyNode head;
    public DoublyNode tail;

    /**
     * Initialize your data structure here.
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0) {
            return -1;
        }

        DoublyNode cur = getNode(index);
        return cur == null ? -1 : cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion,
     * the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        DoublyNode newNode = new DoublyNode(val);
        if (head == null) {
            createFromEmptyList(newNode);
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        DoublyNode newNode = new DoublyNode(val);
        if (head == null) {
            createFromEmptyList(newNode);
            return;
        }

        DoublyNode curTail = getTail();
        curTail.next = newNode;
        newNode.prev = curTail;
        tail = newNode;
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            return;
        }

        DoublyNode newNode = new DoublyNode(val);
        if (head == null) {
            createFromEmptyList(newNode);
            return;
        }

        // If cur is null that means the index was not a valid node and the getNode method will return null
        DoublyNode cur = getNode(index);
        if (getListLength() == index) {
            addAtTail(val);
            return;
        }

        if (cur == null) {
            return;
        }

        if (cur == head) {
            addAtHead(val);
            return;
        }

        cur.prev.next = newNode;
        newNode.next = cur;
        newNode.prev = cur.prev;
        cur.prev = newNode;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        DoublyNode nodeToDelete = getNode(index);
        if (nodeToDelete == null) {
            return;
        }

        if (getListLength() == 1 && index == 0) {
            head = null;
            tail = null;
            return;
        }

        if (nodeToDelete.prev == null) {
            head = head.next;
            head.prev = null;
            return;
        } else if (nodeToDelete.next == null) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        nodeToDelete.prev.next = nodeToDelete.next;
        nodeToDelete.next.prev = nodeToDelete.prev;
    }

    private void createFromEmptyList(DoublyNode node) {
        head = node;
        tail = node;
    }

    private DoublyNode getNode(int index) {
        DoublyNode cur = head;
        for (int i = 0; i < index && cur != null; ++i) {
            cur = cur.next;
        }

        return cur;
    }

    private DoublyNode getTail() {
        DoublyNode cur = head;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    private int getListLength() {
        int length = 0;
        DoublyNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        return length;
    }

    private static class DoublyNode {
        int val;
        DoublyNode next;
        DoublyNode prev;

        DoublyNode(int val) {
            this.val = val;
        }
    }
}
