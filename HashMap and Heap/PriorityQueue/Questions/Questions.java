package PriorityQueue.Questions;

import java.util.Collections;
import java.util.PriorityQueue;
import Common.ListNode;

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

    // Leetcode 23 -> Merge k Sorted Lists
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b) -> {
            return a.val - b.val;
        });
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (pq.size() > 0) {
            // remove minimum value node
            ListNode top = pq.remove();

            // insert its next node
            ListNode topKaNext = top.next;
            top.next = null;
            if (topKaNext != null) {
                pq.add(topKaNext);
            }

            // attach it to final list
            curr.next = top;
            curr = curr.next;
        }

        return dummy.next;
    }

    // Leetcode 295 -> Find Median from Data Stream
    class MedianFinder {

        PriorityQueue<Integer> left; // minPQ
        PriorityQueue<Integer> right; // maxPQ

        public MedianFinder() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (left.size() == 0 || left.peek() >= num) {
                left.add(num);
            } else {
                right.add(num);
            }

            int ls = left.size();
            int rs = right.size();

            if (rs > ls) {
                left.add(right.remove());
            }

            if (ls - rs == 2) {
                right.add(left.remove());
            }
        }

        public double findMedian() {
            if (left.size() == right.size()) {
                return (left.peek() + right.peek()) * 1.0 / 2;
            } else {
                return left.peek() * 1.0;
            }
        }
    }
}
