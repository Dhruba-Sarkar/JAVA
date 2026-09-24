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