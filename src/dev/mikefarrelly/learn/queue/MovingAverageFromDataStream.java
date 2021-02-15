package dev.mikefarrelly.learn.queue;

import java.util.*;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * Implement the MovingAverage class:
 * - MovingAverage(int size) Initializes the object with the size of the window size.
 * - double next(int val) Returns the moving average of the last size values of the stream.
 *
 * Example 1:
 * Input
 * ["MovingAverage", "next", "next", "next", "next"]
 * [[3], [1], [10], [3], [5]]
 * Output
 * [null, 1.0, 5.5, 4.66667, 6.0]
 *
 * Explanation
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // return 1.0 = 1 / 1
 * movingAverage.next(10); // return 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
 *
 * Constraints:
 * - 1 <= size <= 1000
 * - -105 <= val <= 105
 * - At most 104 calls will be made to next.
 *
 * https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1368/
 */
public class MovingAverageFromDataStream {
    public static void main(String[] args) {
        MovingAverageFromDataStream movingAverage = new MovingAverageFromDataStream(3);
        System.out.println(movingAverage.next(1)); // return 1.0 = 1 / 1
        System.out.println(movingAverage.next(10)); // return 5.5 = (1 + 10) / 2
        System.out.println(movingAverage.next(3)); // return 4.66667 = (1 + 10 + 3) / 3
        System.out.println(movingAverage.next(5)); // return 6.0 = (10 + 3 + 5) / 3
    }

    private int maxSize;
    private Queue<Integer> queue = new LinkedList<>();

    public MovingAverageFromDataStream(int size) {
        this.maxSize = size;
    }

    public double next(int val) {
        if (queue.size() < maxSize) {
            queue.add(val);
        } else if (queue.size() == maxSize) {
            queue.remove();
            queue.add(val);
        }

        double sum = 0;
        for (Integer value : queue) {
            sum += value;
        }

        return sum / queue.size();
    }

//    class BestRuntime {
//
//        /** Initialize your data structure here. */
//        Queue<Integer> window;
//        double sum = 0;
//        int size = 0;
//
//        public MovingAverage(int size) {
//            window = new LinkedList<>();
//            this.size = size;
//        }
//
//        public double next(int val) { // add val to the data stream, then calculate avg of last "size" elements
//            if(window.size() >= this.size) {
//                int front = window.poll();
//                sum -= front;
//            }
//            window.add(val);
//            sum += val;
//            return sum / window.size();
//        }
//    }

//    ======================================================================

//    class BestMemory {
//        int size, head = 0, windowSum = 0, count = 0;
//        int[] queue;
//        public MovingAverage(int size) {
//            this.size = size;
//            queue = new int[size];
//        }
//
//        public double next(int val) {
//            ++count;
//            // calculate the new sum by shifting the window
//            int tail = (head + 1) % size;
//            windowSum = windowSum - queue[tail] + val;
//            // move on to the next head
//            head = (head + 1) % size;
//            queue[head] = val;
//            return windowSum * 1.0 / Math.min(size, count);
//        }
//    }

//    ======================================================================

//    class AverageRuntime {
//        int sum;
//        int size;
//        Deque<Integer> queue;
//
//        /** Initialize your data structure here. */
//        public MovingAverage(int size) {
//            this.size = size;
//            this.sum = 0;
//            this.queue = new ArrayDeque<>();
//        }
//
//        public double next(int val) {
//            queue.add(val);
//            sum += val;
//            if (queue.size() > size) {
//                sum -= queue.poll();
//            }
//            return (double)sum/queue.size();
//        }
//    }

//    ======================================================================

//    class AverageMemory {
//
//        Queue<Integer> queue;
//        int runningTotal;
//        int size;
//
//        /** Initialize your data structure here. */
//        public MovingAverage(int size) {
//            runningTotal = 0;
//            queue = new LinkedList<>();
//            this.size = size;
//        }
//
//        public double next(int val) {
//            if(queue.size() == size) {
//                int removed = queue.poll();
//                this.runningTotal -= removed;
//            }
//
//            queue.add(val);
//            this.runningTotal += val;
//
//            return this.runningTotal * (1.0/Math.min(this.size, queue.size()));
//
//        }
//    }
}
