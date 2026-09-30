#include <iostream>
#include <bits/stdc++.h>
using namespace std;

// Leetcode 20 -> Valid Parentheses
bool isValid(string s)
{
    stack<char> st;

    for (int i = 0; i < s.size(); i++)
    {
        char ch = s[i];

        if (ch == '(' || ch == '{' || ch == '[')
        {
            st.push(ch);
        }
        else if (ch == ')')
        {
            if (st.size() == 0 || st.top() != '(')
                return false;

            // popping '('
            st.pop();
        }
        else if (ch == '}')
        {
            if (st.size() == 0 || st.top() != '{')
                return false;

            // popping '{'
            st.pop();
        }
        else if (ch == ']')
        {
            if (st.size() == 0 || st.top() != '[')
                return false;

            // popping '['
            st.pop();
        }
    }
    return st.size() == 0;
}

// Next Greater Element on Right ->
// (https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1)
vector<int> nextLargerElement(vector<int> &arr)
{

    int n = arr.size();
    vector<int> ngr(n, -1);
    stack<int> st;

    for (int i = 0; i < n; i++)
    {
        int currEle = arr[i];

        while (st.size() > 0 && arr[st.top()] < currEle)
        {
            ngr[st.top()] = currEle;
            st.pop();
        }
        st.push(i);
    }
    return ngr;
}
// Leetcode 239 -> Sliding Window Maximum
vector<int> maxSlidingWindow(vector<int> &nums, int k)
{
    int n = nums.size();

    vector<int> ngr(n);
    stack<int> st;
    for (int i = 0; i < n; i++)
    {
        while (st.size() > 0 && nums[st.top()] < nums[i])
        {
            int poppedIndex = st.top();
            st.pop();
            ngr[poppedIndex] = i;
        }
        st.push(i);
    }
    while (st.size() > 0)
    {
        int poppedIndex = st.top();
        st.pop();
        ngr[poppedIndex] = n;
    }
    vector<int> ans(n - k + 1);
    int ansIdx = 0;

    for (int idx = 0; idx < ans.size(); idx++)
    { // idx = starting point of window
        if (ansIdx < idx)
        {
            ansIdx = idx;
        }

        while (ngr[ansIdx] < idx + k)
        {
            ansIdx = ngr[ansIdx];
        }
        ans[idx] = nums[ansIdx];
    }
    return ans;
}

void main()
{
}