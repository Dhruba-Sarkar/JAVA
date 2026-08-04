package Recursion;

public class Question {
    // Print Decreasing
    public static void printDecreasing(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printDecreasing(n - 1);
    }

    // Print Increasing
    public static void printIncreasing(int n) {
        if (n == 0) {
            return;
        }
        printIncreasing(n - 1);
        System.out.println(n);
    }

    // Print Increasing & Decresing
    public static void printDecInc(int n) {

        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printDecInc(n - 1);
        System.out.println(n);
    }

    // Factorial
    public static int fact(int n) {
        if (n <= 1) {
            return 1;
        }
        int smaller = fact(n - 1);
        int ans = n * smaller;
        return ans;
    }

    // Find X raised to the power Y
    // O(y)
    public static int power(int x, int y) {
        if (y == 0) {
            return 1;
        }
        int smaller = power(x, y - 1);
        int ans = x * smaller;
        return ans;
    }

    // Find X raised to the power Y
    // Log(y)
    public static int power_log(int x, int y) {
        if (y == 0) {
            return 1;
        }
        int smaller = power_log(x, y / 2);
        int ans = smaller * smaller;
        if (y % 2 == 1) {
            ans *= x;
        }
        return ans;
    }

    public static void main(String[] args) {
        // printDecreasing(5);
        // printIncreasing(7);
        // printDecInc(4);
        // int n = 5;
        // System.out.println(fact(n));

        int x = 2;
        int y = 5;
        System.out.println(power(x, y));
        System.out.println(power_log(x, y));
    }
}
