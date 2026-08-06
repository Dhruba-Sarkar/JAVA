public class Questions {

    // Print the Array using Recursion
    public static void printArray(int[] arr, int idx) {
        if (idx == arr.length) {
            return;
        }

        System.out.println(arr[idx]);
        printArray(arr, idx + 1);
    }

    // Print the Array in Reverse Order using Recursion
    public static void printArrayReverse(int[] arr, int idx) {
        if (idx == arr.length) {
            return;
        }

        printArrayReverse(arr, idx + 1);
        System.out.println(arr[idx]);
    }

    // Find the Maximum Element in the Array using Recursion
    public static int findMax(int arr[], int idx) {
        if (idx == arr.length - 1) {
            return arr[idx];
        }
        int smallerAns = findMax(arr, idx + 1);
        int ans = Math.max(smallerAns, arr[idx]);
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 7, 45, 8, 11 };
        // printArray(arr, 0);
        // printArrayReverse(arr, 0);
        System.out.println(findMax(arr, 0));
    }
}