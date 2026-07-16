package Arrays;

import java.util.Scanner;

public class reverseArray {
    public static void ReverseArray(int number[]) {
        int start = 0;
        int end = number.length - 1;
        while (start < end) {
            int temp = number[end];
            number[end] = number[start];
            number[start] = temp;
            start++;
            end--;
        }
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scn.nextInt();
        System.out.println("Enter " + size + " elements of the array: ");
        int number[] = new int[size];
        for (int i = 0; i < size; i++) {
            number[i] = scn.nextInt();
        }
        System.out.println("Reversed array is: ");
        ReverseArray(number);
        scn.close();
    }

}