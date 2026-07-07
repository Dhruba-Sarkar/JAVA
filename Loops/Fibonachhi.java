package Loops;

import java.util.*;

public class Fibonachhi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number you want till : ");
        int n = sc.nextInt();
        int init = 0;
        int sum = 0;
        for (int i = 1; i < n - 1; i++) {
            i = i + init;
            sum = sum + i;
        }
        System.out.println("The sum of the Prime number till " + n + " is " + sum);
        sc.close();
    }
}
