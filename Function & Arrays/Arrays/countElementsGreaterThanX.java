package Arrays;

import java.util.Scanner;

class countElementsGreaterThanX {
    public static int ElementsGreaterThanX(int[] arr, int x) {
        // write your code here
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > x) {
                count++;
            }
        }
        return count;
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

        System.out.print("Enter the value of x: ");
        int x = scn.nextInt();

        int res = ElementsGreaterThanX(arr, x);

        System.out.println("Number of elements greater than x: " + res);
        scn.close();
    }
}