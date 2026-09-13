package LinkedList.Questions;

// LeetCode blueprint
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Main {
    // Leetcode 876 -> Find middle node
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Helper function to find middle of LinkedList(first middle in case of even
    // length)
    public ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Helper function to reverse LinedList and return new head
    public ListNode reverseLinkedList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {

            ListNode currKaNext = curr.next;
            curr.next = prev;

            prev = curr;
            curr = currKaNext;
        }
        return prev;
    }

    // Leetcode 234 -> Palindrome LinkedList
    public boolean isPalindrome(ListNode head) {
        // Divide into two halves
        ListNode midNode = findMiddleNode(head);

        ListNode secondHalfHead = midNode.next;
        midNode.next = null;

        // Reverse the second half
        secondHalfHead = reverseLinkedList(secondHalfHead);

        ListNode temp1 = head;
        ListNode temp2 = secondHalfHead;

        while (temp1 != null && temp2 != null) {
            if (temp1.val != temp2.val) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;
    }

    // Leetcode 143 -> Reorder LinkedList
    public void reorderList(ListNode head) {
        // find two halves
        ListNode midNode = findMiddleNode(head);

        ListNode secondHalfHead = midNode.next;
        midNode.next = null;

        // reverse the second half
        secondHalfHead = reverseLinkedList(secondHalfHead);

        // combine these two
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode ptr1 = head;
        ListNode ptr2 = secondHalfHead;

        while (ptr2 != null) {
            // isolate ptr1
            ListNode ptr1KaNext = ptr1.next;
            ptr1.next = null;

            // connect to ans linkedList
            curr.next = ptr1;

            // move ptr1 and curr
            curr = curr.next;
            ptr1 = ptr1KaNext;

            // isolate ptr2
            ListNode ptr2KaNext = ptr2.next;
            ptr2.next = null;

            // connect to ans linkedList
            curr.next = ptr2;

            // move ptr2 and curr
            curr = curr.next;
            ptr2 = ptr2KaNext;
        }

        if (ptr1 != null) { // Odd case
            curr.next = ptr1;

        }

    }

    // Leetcode 328 (odd even linked list)
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-1);

        ListNode ptr = head;
        ListNode oddTail = oddDummy;
        ListNode evenTail = evenDummy;

        int idx = 1;

        while (ptr != null) {
            // isolate ptr
            ListNode ptrKaNext = ptr.next;
            ptr.next = null;

            // connect with even or odd
            if (idx % 2 == 0) {
                evenTail.next = ptr;
                evenTail = ptr;
            } else {
                oddTail.next = ptr;
                oddTail = oddTail.next;
            }

            // move to next node
            ptr = ptrKaNext;
            idx++;
        }

        ListNode oddListHead = oddDummy.next;
        ListNode evenListHead = evenDummy.next;

        oddTail.next = evenListHead;

        return oddListHead;
    }

    public static void main(String[] args) {
        //
    }
}