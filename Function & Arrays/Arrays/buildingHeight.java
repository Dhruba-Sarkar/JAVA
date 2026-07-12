package Arrays;

import java.util.Scanner;

public class buildingHeight {
    public static void heightOfBuilding(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currentHeight = arr[i];
            max = Math.max(max, currentHeight);
        }
        int current_floor = max;
        while (current_floor > 0) {
            for (int i = 0; i < arr.length; i++) {
                int currentHeight = arr[i];
                if (current_floor <= currentHeight) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
            current_floor--;
        }
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

        System.out.println("The Building of the array is: ");
        heightOfBuilding(arr);
        scn.close();
    }
}
