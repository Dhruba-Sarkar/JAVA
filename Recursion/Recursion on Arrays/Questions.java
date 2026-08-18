
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

    // Find the First Index of an Element in an Array
    public static int findFirstIndex(int[] arr, int tar, int idx) {

        if (idx == arr.length) {
            return -1;
        }

        int furtherFirstIndex = findFirstIndex(arr, tar, idx + 1);
        if (arr[idx] == tar) {
            return idx;
        } else {
            return furtherFirstIndex;
        }
    }

    // Find the Last Index of an Element in an Array
    public static int findLastIndex(int[] arr, int tar, int idx) {
        if (idx == arr.length) {
            return -1;
        }

        int lastIndex = findLastIndex(arr, tar, idx + 1);

        if (lastIndex == -1 && arr[idx] == tar) {
            return idx;
        }
        return lastIndex;
    }

    // Find All Indices of an Element in an Array
    public static int[] findAllIndices(int[] arr, int tar, int idx, int fsf) {
        if (idx == arr.length) {
            int baseArr[] = new int[fsf];
            return baseArr;
        }
        int[] ans;
        if (arr[idx] == tar) {
            ans = findAllIndices(arr, tar, idx + 1, fsf + 1);
            ans[fsf] = idx;
        } else {
            ans = findAllIndices(arr, tar, idx + 1, fsf);
        }
        return ans;
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 7, 45, 8, 11 };
        // printArray(arr, 0);
        // printArrayReverse(arr, 0);
        // System.out.println(findMax(arr, 0));

        int arr[] = { 10, 19, 4, 5, 1, 19, 4, 4, 11, 19 };
        // System.out.println(findFirstIndex(arr, 4, 0));
        // System.out.println(findLastIndex(arr, 19, 0));

        int ans[] = findAllIndices(arr, 4, 0, 0);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
