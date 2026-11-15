package PriorityQueue.Introduction;

import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        // Min Priority Queue
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        minPQ.add(10);
        minPQ.add(100);
        minPQ.add(201);
        minPQ.add(83);
        minPQ.add(31);
        minPQ.add(93);

        // System.out.println(minPQ.peek());
        // System.out.println(minPQ.poll());
        // System.out.println(minPQ.poll());
        // System.out.println(minPQ.poll());
        // System.out.println(minPQ.peek());

        // Max Priority Queue
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        maxPQ.add(10);
        maxPQ.add(100);
        maxPQ.add(201);
        maxPQ.add(83);
        maxPQ.add(31);
        maxPQ.add(93);

        System.out.println(maxPQ.peek());
        System.out.println(maxPQ.poll());
        System.out.println(maxPQ.poll());
        System.out.println(maxPQ.poll());
        System.out.println(maxPQ.peek());
    }
}
