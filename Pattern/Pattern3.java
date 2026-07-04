package Pattern;

import java.util.Scanner;

public class Pattern3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scn.nextInt();

        int total_num_lines = n;
        int current_num_of_line = 1;

        int stars = 1;
        int spaces = n - 1;
        while (current_num_of_line <= total_num_lines) {
            for (int i = 1; i <= spaces; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= stars; i++) {
                System.out.print("* ");
            }
            spaces--;
            stars++;
            System.out.println();
            current_num_of_line++;
        }
        scn.close();
    }
}
