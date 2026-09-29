import java.util.ArrayList;
import java.util.Stack;

import Pattern.hRectangle;

class Main {
    public static boolean isDuplicateBracket(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')') {
                // if opening bracket at top, its duplicate
                if (st.peek() == '(') {
                    return true;
                }

                // remove all characters till we find openign bracket
                while (st.peek() != '(') {
                    st.pop();
                }
                st.pop();// removing opening bracket
            } else {
                st.push(ch);
            }
        }
        return false;
    }

    // Leetcode 20 -> Valid Parentheses
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.size() == 0 || st.peek() != '(')
                    return false;

                // popping '('
                st.pop();
            } else if (ch == '}') {
                if (st.size() == 0 || st.peek() != '{')
                    return false;

                // popping '{'
                st.pop();
            } else if (ch == ']') {
                if (st.size() == 0 || st.peek() != '[')
                    return false;

                // popping '['
                st.pop();
            }
        }
        return st.size() == 0;
    }

    public static void main(String[] args) {
        String str = "(((a+(b))+c+d))";

        boolean isDuplicate = isDuplicateBracket(str);

        if (isDuplicate) {
            System.out.println("Brackets are duplicate!!!");
        } else {
            System.out.println("Brackets are not duplicate!!!");
        }
    }

    // Next Greater Element on Right ->
    // (https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1)
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;

        int ngr[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int currEle = arr[i];

            while (st.size() > 0 && st.peek() <= currEle) {
                st.pop();
            }
            if (st.size() == 0) {
                ngr[i] = -1;
            } else {
                ngr[i] = st.peek();
            }
            st.push(currEle);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            res.add(ngr[i]);
        return res;
    }

    // Next Greater Element on Right ->(Moving from left to right)
    public ArrayList<Integer> nextLargerElement1(int[] arr) {
        int n = arr.length;

        int ngr[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            int currEle = arr[i];

            while (st.size() > 0 && arr[st.peek()] < currEle) {
                ngr[st.pop()] = currEle;
            }
            st.push(i);
        }

        while (st.size() > 0) {
            ngr[st.pop()] = -1;
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            res.add(ngr[i]);
        return res;
    }

    // Next smaller element(Moving from lest to right)
    // https://www.geeksforgeeks.org/problems/previous-smaller-element/1
    public static ArrayList<Integer> prevSmaller(int[] arr) {

        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int[] nls = new int[n];

        for (int i = 0; i < n; i++) {
            int currEle = arr[i];

            while (st.peek() != -1 && st.peek() >= currEle) {
                st.pop();
            }
            nls[i] = st.peek();
            st.push(currEle);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            res.add(nls[i]);
        return res;
    }

    // Stock span problem
    public ArrayList<Integer> calculateSpan(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = 0; i < arr.length; i++) {
            while (st.peek() != -1 && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            ans.add(i - st.peek());
            st.push(i);
        }
        return ans;
    }

    // Leetcode 84 -> Largest Rectangle in Histogram
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] nsl = new int[n];
        int[] nsr = new int[n];

        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = 0; i < n; i++) {
            while (st.peek() != -1 && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nsl[i] = st.peek();
            st.push(i);
        }

        st = new Stack<>();
        st.push(n);

        for (int i = n - 1; i >= 0; i--) {
            while (st.peek() != n && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nsr[i] = st.peek();
            st.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int h = heights[i];
            int w = nsr[i] - nsl[i] - 1;
            maxArea = Math.max(maxArea, h * w);
        }
        return maxArea;
    }

}