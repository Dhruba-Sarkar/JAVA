package Arrays;

import java.util.Scanner;

public class maxSubArray {
    public int maxSubArrays(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int startEi = 0;
        int endEi = 0;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum > maxSum) {
                startEi = currentSum;
                endEi = i;
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scn.nextInt();
        int arr[] = new int[size];
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = scn.nextInt();
        }
        maxSubArray obj = new maxSubArray();
        int result = obj.maxSubArrays(arr);
        System.out.println("Maximum subarray sum is: " + result);
        scn.close();
    }
}
