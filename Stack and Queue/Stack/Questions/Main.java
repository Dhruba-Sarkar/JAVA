import java.util.Stack;

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
}