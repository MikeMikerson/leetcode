package dev.mikefarrelly.learn.linkedlist.singly;

public class SinglyLinkedListAverageMemory {
    class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }

    Node head;

    /**
     * Initialize your data structure here.
     */
    public SinglyLinkedListAverageMemory() {
        head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        int i = 0;
        Node cur = head;
        while (cur != null) {
            if (i == index)
                return cur.val;
            i++;
            cur = cur.next;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node cur = new Node(val);
            cur.next = head;
            head = cur;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node tail = null, cur = head;
        if (head == null) {
            head = new Node(val);
        } else {
            while (cur != null) {
                tail = cur;
                cur = cur.next;
            }
            cur = new Node(val);
            tail.next = cur;
        }

    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        int i = 0;
        Node cur = head, prev = null;
        while (cur != null) {
            if (i == index) {
                Node temp = new Node(val);
                if (prev == null) {
                    temp.next = head;
                    head = temp;
                } else {
                    temp.next = cur;
                    prev.next = temp;
                }
                return;
            }
            i++;
            prev = cur;
            cur = cur.next;
        }
        if (i == index) {
            Node temp = new Node(val);
            if (prev == null) {
                head = temp;
            } else {
                prev.next = temp;
            }
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        int i = 0;
        Node cur = head, prev = null;
        while (cur != null) {
            if (i == index) {
                if (prev == null) {
                    head = cur.next;
                } else {
                    prev.next = cur.next;
                }
                return;
            }
            i++;
            prev = cur;
            cur = cur.next;
        }
    }
}
