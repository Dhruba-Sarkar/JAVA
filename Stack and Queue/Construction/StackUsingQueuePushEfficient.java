package Construction;

import java.util.LinkedList;

class MyStack {
    private LinkedList<Integer> data;

    public MyStack() {
        data = new LinkedList<>();
    }

    // O(1)
    public void push(int val) {
        data.addLast(val);
    }

    // O(N)
    public int pop() {
        if (data.size() == 0) {
            System.out.println("Stack empty Exception");
            return -1;
        }
        LinkedList<Integer> newData = new LinkedList<>();
        while (data.size() > 1) {
            int frontVal = data.removeFirst();
            newData.addLast(frontVal);
        }
        int stackTopVal = data.removeFirst();
        data = newData;
        return stackTopVal;
    }

    // O(N)
    public int peek() {
        if (data.size() == 0) {
            System.out.println("Stack empty Exception");
            return -1;
        }
        LinkedList<Integer> newData = new LinkedList<>();
        while (data.size() > 1) {
            int frontVal = data.removeFirst();
            newData.addLast(frontVal);
        }
        int stackTopVal = data.removeFirst();
        newData.addLast(stackTopVal);
        data = newData;
        return stackTopVal;
    }
}

public class StackUsingQueuePushEfficient {
    public static void main(String[] args) {
        MyStack st = new MyStack();

        st.push(20);
        st.push(30);
        st.push(40);

        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.peek());

        st.push(50);
        st.push(60);
        st.push(70);

    }
}
