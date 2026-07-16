package Arrays;

import java.util.Scanner;

public class leftRotateArray {
    public void rotateArr(int arr[], int d) {
        int n = arr.length;
        int k = d;

        k = k % n;
        if (k < 0) {
            k = k + n;
        }
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scn.nextInt();
        int arr[] = new int[size];
        System.out.print("Enter the elements of the array: ");
        leftRotateArray obj = new leftRotateArray();
        for (int i = 0; i < size; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.print("Enter the number of positions to rotate: ");
        int d = scn.nextInt();
        obj.rotateArr(arr, d);
        System.out.print("Array after left rotation: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        scn.close();
    }
}
