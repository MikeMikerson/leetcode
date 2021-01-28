package dev.mikefarrelly.learn.linkedlist.singly;

public class SinglyLinkedListAverageRuntime {
    Node head = null;

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public SinglyLinkedListAverageRuntime() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node curr = head;
        while (curr != null) {
            if (index == 0)
                return curr.val;
            index--;
            curr = curr.next;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;

    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node newNode = new Node(val);
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            if (index == 0) {
                prev.next = newNode;
                newNode.next = curr;
                return;
            }
            prev = curr;
            curr = curr.next;
            index--;
        }
        if (index == 0)
            prev.next = newNode;

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            if (index == 0) {
                if (prev == null)
                    head = curr.next;
                else
                    prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
            index--;
        }
    }
}
