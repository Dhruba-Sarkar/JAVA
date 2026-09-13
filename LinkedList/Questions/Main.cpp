#include <bits/stdc++.h>
using namespace std;

// LeetCode blueprint
struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

// Leetcode 876 -> Find middle node
ListNode *middleNode(ListNode *head)
{
    ListNode *slow = head;
    ListNode *fast = head;

    while (fast != nullptr && fast->next != NULL)
    {
        slow = slow->next;
        fast = fast->next->next;
    }

    return slow;
}

// Helper function to find middle of LinkedList(first middle in case of even
// length)
ListNode *findMiddleNode(ListNode *head)
{
    ListNode *slow = head;
    ListNode *fast = head;

    while (fast->next != nullptr && fast->next->next != nullptr)
    {
        slow = slow->next;
        fast = fast->next->next;
    }

    return slow;
}

// Helper function to reverse LinedList and return new head
ListNode *reverseLinkedList(ListNode *head)
{
    ListNode *curr = head;
    ListNode *prev = nullptr;

    while (curr != nullptr)
    {

        ListNode *currKaNext = curr->next;
        curr->next = prev;

        prev = curr;
        curr = currKaNext;
    }
    return prev;
}

// Leetcode 234 -> Palindrome LinkedList
bool isPalindrome(ListNode *head)
{
    // Divide into two halves
    ListNode *midNode = findMiddleNode(head);

    ListNode *secondHalfHead = midNode->next;
    midNode->next = nullptr;

    // Reverse the second half
    secondHalfHead = reverseLinkedList(secondHalfHead);

    ListNode *temp1 = head;
    ListNode *temp2 = secondHalfHead;

    while (temp1 != nullptr && temp2 != nullptr)
    {
        if (temp1->val != temp2->val)
        {
            return false;
        }
        temp1 = temp1->next;
        temp2 = temp2->next;
    }

    return true;
}

// Leetcode 234 -> Palindrome LinkedList
void reorderList(ListNode *head)
{

    ListNode *midNode = findMiddleNode(head);
    ListNode *secondHalfHead = midNode->next;
    midNode->next = nullptr;

    secondHalfHead = reverseLinkedList(secondHalfHead);

    ListNode *dummy = new ListNode(-1);
    ListNode *curr = dummy;
    ListNode *ptr1 = head;
    ListNode *ptr2 = secondHalfHead;

    while (ptr2 != nullptr)
    {
        // isolate ptr1
        ListNode *ptr1KaNext = ptr1->next;
        ptr1->next = nullptr;

        curr->next = ptr1;

        curr = curr->next;
        ptr1 = ptr1KaNext;

        // isolate ptr2
        ListNode *ptr2KaNext = ptr2->next;
        ptr2->next = nullptr;

        curr->next = ptr2;

        curr = curr->next;
        ptr2 = ptr2KaNext;
    }

    if (ptr1 != nullptr)
    { // Odd case
        curr->next = ptr1;
    }
}

// Leetcode 328 (odd even linked list)
ListNode *oddEvenList(ListNode *head)
{
    if (head == nullptr || head->next == nullptr)
    {
        return head;
    }

    ListNode *oddDummy = new ListNode(-1);
    ListNode *evenDummy = new ListNode(-1);

    ListNode *ptr = head;
    ListNode *oddTail = oddDummy;
    ListNode *evenTail = evenDummy;

    int idx = 1;

    while (ptr != nullptr)
    {
        // isolate ptr
        ListNode *ptrKaNext = ptr->next;
        ptr->next = nullptr;

        // connect with even or odd
        if (idx % 2 == 0)
        {
            evenTail->next = ptr;
            evenTail = ptr;
        }
        else
        {
            oddTail->next = ptr;
            oddTail = oddTail->next;
        }

        // move to next node
        ptr = ptrKaNext;
        idx++;
    }

    ListNode *oddListHead = oddDummy->next;
    ListNode *evenListHead = evenDummy->next;

    oddTail->next = evenListHead;

    return oddListHead;
}