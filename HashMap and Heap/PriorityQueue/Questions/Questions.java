package PriorityQueue.Questions;

import java.util.Collections;
import java.util.PriorityQueue;

public class Questions {
    // Leetcode 215 -> Kth Largest Element in an Array (NlogN)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int e : nums) {
            pq.add(e);

        }
        k--;
        while (k > 0) {
            pq.remove();
            k--;
        }
        return pq.peek();
    }

    // Leetcode 215 -> Kth Largest Element in an Array (NlogK)
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int e : nums) {
            pq.add(e);

            if (pq.size() > k) {
                pq.remove();
            }
        }

        return pq.peek();
    }

    // Kth Smallest
    // (https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1)
    public int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int e : arr) {
            pq.add(e);

            if (pq.size() > k) {
                pq.remove();
            }
        }

        return pq.peek();
    }
}
