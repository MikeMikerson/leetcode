package dev.mikefarrelly.learn.linkedlist.singly;

/**
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node,
 * and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in
 * the linked list. Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement the MyLinkedList class:
 * <p>
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of the linked list.
 * After the insertion, the new node will be the first node of the linked list.
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list.
 * If index equals the length of the linked list, the node will be appended to the end of the linked list.
 * If index is greater than the length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 * <p>
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
 * https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/
 */
public class SinglyLinkedList {
    private SinglyListNode head;
    private SinglyListNode tail;
    private int length = 0;

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addAtHead(1);
        singlyLinkedList.printAllNodes();
        singlyLinkedList.addAtTail(3);
        singlyLinkedList.printAllNodes();
        singlyLinkedList.addAtIndex(1, 2);
        singlyLinkedList.printAllNodes();
//
//        // 2
        System.out.println(singlyLinkedList.get(1));
        singlyLinkedList.deleteAtIndex(1);
//
//        // 3
        System.out.println(singlyLinkedList.get(1));

        // ============================================================
        // ============================================================
        // ============================================================

        /*
         * ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
         * [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
         */
//        singlyLinkedList.addAtHead(7);
//        singlyLinkedList.printAllNodes();
//        singlyLinkedList.addAtHead(2);
//        singlyLinkedList.printAllNodes();
//        singlyLinkedList.addAtHead(1);
//        singlyLinkedList.printAllNodes();
//        singlyLinkedList.addAtIndex(3, 0);
//        singlyLinkedList.printAllNodes();
//        singlyLinkedList.deleteAtIndex(2);
//        singlyLinkedList.printAllNodes();
//        singlyLinkedList.addAtHead(6);
//        singlyLinkedList.printAllNodes();
//        singlyLinkedList.addAtTail(4);
//        singlyLinkedList.printAllNodes();
//
//         should be 4
//        System.out.println(singlyLinkedList.get(4));
//        singlyLinkedList.addAtHead(4);
//        singlyLinkedList.addAtIndex(5, 0);
//        singlyLinkedList.addAtHead(6);

        // ============================================================
        // ============================================================
        // ============================================================

        /*
         * ["MyLinkedList","addAtIndex","addAtIndex","addAtIndex","get"]
         * [[],[0,10],[0,20],[1,30],[0]]
         */
//        singlyLinkedList.addAtIndex(0, 10);
//        singlyLinkedList.addAtIndex(0, 20);
//        singlyLinkedList.addAtIndex(1, 30);

        // 20
//        System.out.println(singlyLinkedList.get(0));
    }

    public void printAllNodes() {
        SinglyListNode cur = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (cur != null) {
            stringBuilder.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        stringBuilder.append("null");
        System.out.println(stringBuilder.toString());
        System.out.println("Size of current list: " + length);
        System.out.println("============");
    }

    /**
     * Initialize your data structure here.
     */
    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (head == null || tail == null || index < 0) {
            return -1;
        }

        SinglyListNode cur = head;
        int count = 0;

        while (cur.next != null) {
            if (count == index) {
                return cur.val;
            }
            count++;
            cur = cur.next;
        }

        if (count == index) {
            return cur.val;
        }

        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion,
     * the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        SinglyListNode newHead = new SinglyListNode(val);
        newHead.next = head;
        head = newHead;

        // If head is the only item, then it is also the tail
        if (head.next == null) {
            tail = head;
        }
        length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        SinglyListNode newTail = new SinglyListNode(val);

        // If tail if null then that means there are no nodes, so set both head and tail to equal the new tail
        if (head == null || tail == null) {
            head = newTail;
            tail = newTail;
            length++;
            return;
        }

        tail.next = newTail;
        tail = newTail;
        length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            // Don't do anything if the index isn't valid
            return;
        }

        SinglyListNode newNode = new SinglyListNode(val);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            length++;
            if (tail == null) {
                tail = newNode;
            }
            return;
        }

        if (index == length) {
            tail.next = newNode;
            tail = newNode;
            length++;
            return;
        }

        if (head == null) {
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
            length++;
            return;
        }

        SinglyListNode cur = head;
        int count = 0;
        while (cur.next != null) {
            if (count + 1 == index) {
                newNode.next = cur.next;
                cur.next = newNode;
                length++;
                return;
            }
            count++;
            cur = cur.next;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > length - 1) {
            return;
        }

        if (index == 0) {
            head = head.next;
            length--;
            return;
        }

        SinglyListNode prev = head;
        for (int i = 1; i < index; i++) {
            prev = prev.next;
        }
        SinglyListNode del = prev.next;
        prev.next = del.next;
        length--;

        if (length == index) {
            tail = prev;
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
