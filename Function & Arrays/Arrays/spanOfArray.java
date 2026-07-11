package Arrays;

import java.util.Scanner;

public class spanOfArray {

    public static int findSpan(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int span = max - min;
        return span;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = scn.nextInt();

        int[] arr = new int[size];

        System.out.print("Enter " + size + " elements of array: ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.print("The Span of the array is: ");
        int span = findSpan(arr);

        System.out.println(span);
        scn.close();
    }
}
