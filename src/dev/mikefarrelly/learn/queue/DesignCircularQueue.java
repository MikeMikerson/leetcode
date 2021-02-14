package dev.mikefarrelly.learn.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the
 * operations are performed based on FIFO (First In First Out) principle and the last position is connected back
 * to the first position to make a circle. It is also called "Ring Buffer".
 * <p>
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue.
 * In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space
 * in front of the queue. But using the circular queue, we can use the space to store new values.
 * <p>
 * Implementation the MyCircularQueue class:
 * <p>
 * MyCircularQueue(k) Initializes the object with the size of the queue to be k.
 * int Front() Gets the front item from the queue. If the queue is empty, return -1.
 * int Rear() Gets the last item from the queue. If the queue is empty, return -1.
 * boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
 * boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
 * boolean isEmpty() Checks whether the circular queue is empty or not.
 * boolean isFull() Checks whether the circular queue is full or not.
 * <p>
 * <p>
 * Example 1:
 * Input
 * ["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 * Output
 * [null, true, true, true, false, 3, true, true, true, 4]
 * <p>
 * Explanation
 * MyCircularQueue myCircularQueue = new MyCircularQueue(3);
 * myCircularQueue.enQueue(1); // return True
 * myCircularQueue.enQueue(2); // return True
 * myCircularQueue.enQueue(3); // return True
 * myCircularQueue.enQueue(4); // return False
 * myCircularQueue.Rear();     // return 3
 * myCircularQueue.isFull();   // return True
 * myCircularQueue.deQueue();  // return True
 * myCircularQueue.enQueue(4); // return True
 * myCircularQueue.Rear();     // return 4
 * <p>
 * Constraints:
 * - 1 <= k <= 1000
 * - 0 <= value <= 1000
 * - At most 3000 calls will be made to enQueue, deQueue, Front, Rear, isEmpty, and isFull.
 * <p>
 * Follow up: Could you solve the problem without using the built-in queue?
 * <p>
 * https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1337/
 */
public class DesignCircularQueue {
    public static void main(String[] args) {
        DesignCircularQueue queue = new DesignCircularQueue(3);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
        System.out.println(queue.isFull());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(4));

        System.out.println(queue.queue);
    }

    private int maxSize;
    private int back;
    private List<Integer> queue;

    /**
     * Initialize the list with a size of k.
     *
     * @param k the max size of the queue
     */
    public DesignCircularQueue(int k) {
        if (k < 1) {
            throw new IllegalArgumentException("Only values greater than one is allowed");
        }
        queue = new ArrayList<>(k);
        maxSize = k;
    }

    /**
     * Inserts an element into the circular queue. Return true if the operation is successful
     *
     * @param value the new front
     * @return true if the operation is successful
     */
    public boolean enQueue(int value) {
        if (queue.size() == maxSize) {
            System.out.println("There is no room in the queue");
            return false;
        }

        queue.add(value);
        if (isEmpty()) {
            back = 0;
        } else {
            back = queue.size()-1;
        }

        return true;
    }


    /**
     * Deletes an element from the circular queue
     *
     * @return true if the operation is successful
     */
    public boolean deQueue() {
        if (isEmpty()) {
            System.out.println("There is nothing to remove from the queue");
            return false;
        }

        back--;
        queue.remove(0);
        return true;
    }

    /**
     * Gets the front item from the queue. If the queue is empty, returns -1.
     *
     * @return the front item. If the queue is empty, returns -1
     */
    public int Front() {
        int front = 0;
        return isEmpty() ? -1 : queue.get(front);
    }

    /**
     * Gets the last item from the queue. If the queue is empty, returns -1.
     *
     * @return the rear item. If the queue is empty, returns -1.
     */
    public int Rear() {
        return isEmpty() ? -1 : queue.get(back);
    }

    /**
     * Checks whether the circular queue is empty or not.
     *
     * @return true if the circular queue is empty
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Checks whether the circular is full or not.
     *
     * @return true if the circular queue is full
     */
    public boolean isFull() {
        return queue.size() == maxSize;
    }
}
