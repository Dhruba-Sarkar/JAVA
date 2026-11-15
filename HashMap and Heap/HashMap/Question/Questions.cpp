#include <bits/stdc++.h>
using namespace std;

// Most Frequent Character(https://www.geeksforgeeks.org/problems/maximum-occuring-character-1587115620/1)
char getMaxOccuringChar(string &s)
{
    unordered_map<char, int> freMap;
    for (char c : s)
    {
        freMap[c]++;
    }
    char ans = '\0';
    int maxFre = 0;
    for (char c : s)
    {
        char ch = c;
        if (maxFre < freMap[ch])
        {
            ans = ch;
            maxFre = freMap[ch];
        }
        else if (freMap[ch] == maxFre && ans > ch)
        {
            ans = ch;
        }
    }
    return ans;
}

// Leetcode 3005 -> Count Elements With Maximum Frequency
int maxFrequencyElements(std::vector<int> &nums)
{
    unordered_map<int, int> freMap;

    int maxFre = 0;
    int totalFrequencies = 0;

    for (int i = 0; i < nums.size(); i++)
    {
        int num = nums[i];

        freMap[num]++;

        int currentFre = freMap[num];

        if (currentFre > maxFre)
        {
            maxFre = currentFre;
            totalFrequencies = currentFre;
        }
        else if (currentFre == maxFre)
        {
            totalFrequencies += currentFre;
        }
    }

    return totalFrequencies;
}

// Leetcode 349 -> Intersection of Two Arrays
vector<int> intersection(vector<int> &nums1, vector<int> &nums2)
{
    unordered_map<int, int> freMap;

    // add nums1 to map
    for (int e : nums1)
    {
        freMap[e] = 1; // we dont care about frequency
    }
    vector<int> ans;

    // find intersection
    for (int e : nums2)
    {
        if (freMap.count(e))
        {
            ans.push_back(e);
            freMap.erase(e); // remove to avoid duplicates
        }
    }

    return ans;
}

// Leetcode 349 -> Intersection of Two Arrays using set
vector<int> intersection(vector<int> &nums1, vector<int> &nums2)
{
    unordered_set<int> sc;

    // add nums1 to map
    for (int e : nums1)
    {
        sc.insert(e); // we dont care about frequency
    }
    vector<int> ans;

    // find intersection
    for (int e : nums2)
    {
        if (sc.find(e) != sc.end())
        {
            ans.push_back(e);
            sc.erase(e); // remove to avoid duplicates
        }
    }
    return ans;
}

// Common Elements(https://www.geeksforgeeks.org/problems/common-elements5420/1)
vector<int> commonElements(vector<int> &a, vector<int> &b)
{
    unordered_map<int, int> freMap;
    for (int e : a)
    {
        freMap[e]++;
    }
    vector<int> ans;
    for (int e : b)
    {
        if (freMap[e] > 0)
        {
            ans.push_back(e);
            freMap[e]--;
        }
    }

    sort(ans.begin(), ans.end());
    return ans;
}
int main()
{
    return 0;
}
