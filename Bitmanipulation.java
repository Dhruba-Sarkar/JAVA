public class Bitmanipulation {
    public static void oddOrEven(int n) {
        int bitmask = 1;
        if ((n & bitmask) == 0) {
            System.out.println("The number is even");
        } else {
            System.out.println("The number is odd");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitmask = 1 << i;
        if ((n & bitmask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitmask = 1 << i;
        return n | bitmask;
    }

    public static void main(String args[]) {
        System.out.println(setIthBit(10, 4));
    }
}