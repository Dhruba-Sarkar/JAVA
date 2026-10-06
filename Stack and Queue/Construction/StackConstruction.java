package Construction;

class MyStack {
    final int maxSize = 8;
    private int[] data;
    private int tos;

    public MyStack() {
        data = new int[maxSize];
        tos = -1;
    }

    private void resizeData() {
        // new data array of twice the size
        int[] newData = new int[maxSize * 2];

        // copy old data to new data array
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        // refer data to new data array
        data = newData;
    }

    public void push(int val) {
        // static stack
        // if (tos == maxSize - 1) { // data array is completely filled
        // System.out.println("Stack Overflow!!");

        // }
        // dynamic stack
        if (tos == data.length - 1) {
            resizeData();
        } else {
            tos++;
            data[tos] = val;
        }
    }

    public int pop() {
        if (tos == -1) {
            System.out.println("Stack is Empty!!");
            return -1;
        }
        int val = data[tos];
        tos--;
        return val;
    }

    public int peek() {
        if (tos == -1) {
            System.out.println("Stack is Empty!!");
            return -1;
        }
        return data[tos];
    }

    public int size() {
        return tos + 1;
    }

    @Override
    public String toString() {
        String StackString = "[";
        for (int i = 0; i <= tos; i++) {
            StackString += data[i] + " ";
        }
        StackString += "]";
        return StackString;
    }

    class StackConstruction {
        public static void main(String[] args) {
            MyStack st = new MyStack();

            st.push(2);
            st.push(3);
            st.push(4);
            st.push(5);
            st.push(5);
            st.push(5);
            st.push(5);
            st.push(5);
            st.push(5);
            st.push(5);

            System.out.println(st.pop());
            System.out.println(st.peek());
            System.out.println(st.size());
            System.out.println(st);

        }
    }
}
