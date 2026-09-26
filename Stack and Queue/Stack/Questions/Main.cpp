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

void main()
{
}