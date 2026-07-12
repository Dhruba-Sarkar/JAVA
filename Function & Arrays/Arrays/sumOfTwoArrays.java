package Arrays;

import java.util.Scanner;

public class sumOfTwoArrays {
    public static int[] calculateSum(int[] arr1, int[] arr2) {
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int[] result = new int[Math.max(arr1.length, arr2.length) + 1];
        int k = result.length - 1;

        int carry = 0;

        while (k >= 0) {
            int csum = carry;

            if (i >= 0) {
                csum += arr1[i];
            }
            if (j >= 0) {
                csum += arr2[j];
            }

            carry = csum / 10;
            csum = csum % 10;

            result[k] = csum;

            i--;
            j--;
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the size of the first array: ");
        int size1 = scn.nextInt();

        int[] arr1 = new int[size1];

        System.out.print("Enter " + size1 + " elements of the first array: ");
        for (int i = 0; i < size1; i++) {
            arr1[i] = scn.nextInt();
        }

        System.out.print("Enter the size of the second array: ");
        int size2 = scn.nextInt();
        int[] arr2 = new int[size2];

        System.out.print("Enter " + size2 + " elements of the second array: ");
        for (int i = 0; i < size2; i++) {
            arr2[i] = scn.nextInt();
        }

        int[] result = calculateSum(arr1, arr2);

        System.out.print("The sum of the two arrays is: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();

        scn.close();
    }
}
