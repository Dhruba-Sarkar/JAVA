#include <bits/stdc++.h>
#include "ListNode.h"
using namespace std;

// Leetcode 215 -> Kth Largest Element in an Array (NlogK)
int findKthLargest(vector<int> &nums, int k)
{
    priority_queue<int, vector<int>, greater<int>> pq;

    for (int e : nums)
    {
        pq.push(e);

        if (pq.size() > k)
        {
            pq.pop();
        }
    }

    return pq.top();
}

// Leetcode 23 -> Merge k Sorted Lists
ListNode *mergeKLists(vector<ListNode *> &lists)
{
    auto cmp = [](ListNode *a, ListNode *b)
    {
        return a->val > b->val;
    };
    priority_queue<ListNode *, vector<ListNode *>, decltype(cmp)> pq(cmp);

    for (ListNode *head : lists)
    {
        if (head != nullptr)
        {
            pq.push(head);
        }
    }

    ListNode dummy(-1);
    ListNode *curr = &dummy;

    while (!pq.empty())
    {
        // remove minimum value node
        ListNode *top = pq.top();
        pq.pop();

        // insert its next node
        ListNode *topKaNext = top->next;
        top->next = nullptr;
        if (topKaNext != nullptr)
        {
            pq.push(topKaNext);
        }

        // attach it to final list
        curr->next = top;
        curr = curr->next;
    }

    return dummy.next;
}
// Leetcode 295 -> Find Median from Data Stream
class MedianFinder
{
    priority_queue<int> left;                             // maxPQ
    priority_queue<int, vector<int>, greater<int>> right; // minPQ

public:
    MedianFinder() {}

    void addNum(int num)
    {
        if (left.empty() || left.top() >= num)
        {
            left.push(num);
        }
        else
        {
            right.push(num);
        }

        int ls = left.size();
        int rs = right.size();

        if (rs > ls)
        {
            left.push(right.top());
            right.pop();
        }

        if (ls - rs == 2)
        {
            right.push(left.top());
            left.pop();
        }
    }

    double findMedian()
    {
        if (left.size() == right.size())
        {
            return (left.top() + right.top()) / 2.0;
        }
        else
        {
            return left.top();
        }
    }
};
int main()
{
    return 0;
}