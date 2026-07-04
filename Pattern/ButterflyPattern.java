package Pattern;

import java.util.Scanner;

public class ButterflyPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");

        int n = sc.nextInt();

        //  1st half
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            //space
            int space = 2*(n-i);
            for (int j = 1; j<=space;j++){
                System.out.print(" ");
            }

            //2nd part
            for (int j= 1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        // 2nd part
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            //space
            int space = 2*(n-i);
            for (int j = 1; j<=space;j++){
                System.out.print(" ");
            }

            //2nd part
            for (int j= 1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}
