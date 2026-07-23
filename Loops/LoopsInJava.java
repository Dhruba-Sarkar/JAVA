package Loops;

import java.util.*;

public class LoopsInJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number for the multiplication table : ");
        int a = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(a + " X " + i + " = " + (a * i));
        }
        sc.close();
    }
}