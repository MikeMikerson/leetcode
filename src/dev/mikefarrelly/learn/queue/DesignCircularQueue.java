package dev.mikefarrelly.learn.queue;

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
    private int maxSize;

    /**
     * @param k the max size of the queue
     */
    public DesignCircularQueue(int k) {
        maxSize = k;
    }

    /**
     * Inserts an element into the circular queue. Return true if the operation is successful
     *
     * @param value the new front
     * @return true if the operation is successful
     */
    public boolean enQueue(int value) {
        return true;
    }


    /**
     * Deletes an element from the circular queue
     *
     * @return true if the operation is successful
     */
    public boolean deQueue() {
        return true;
    }

    /**
     * Gets the front item from the queue. If the queue is empty, returns -1.
     *
     * @return the front item. If the queue is empty, returns -1
     */
    public int Front() {
        return 0;
    }

    /**
     * Gets the last item from the queue. If the queue is empty, returns -1.
     *
     * @return the rear item. If the queue is empty, returns -1.
     */
    public int Rear() {
        return 0;
    }

    /**
     * Checks whether the circular queue is empty or not.
     * 
     * @return true if the circular queue is empty
     */
    public boolean isEmpty() {
        return true;
    }

    /**
     * Checks whether the circular is full or not.
     *
     * @return true if the circular queue is full
     */
    public boolean isFull() {
        return true;
    }
}
