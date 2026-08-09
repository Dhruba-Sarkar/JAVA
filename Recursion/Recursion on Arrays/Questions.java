import java.util.ArrayList;

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

    // Get all subsequences of an array
    public static ArrayList<String> getSubsequences(String str) {

        ArrayList<String> ans = new ArrayList<>();

        if (str.length() == 0) {
            ans.add("");
            return ans;
        }
        char ch = str.charAt(0);
        String smallerString = str.substring(1);

        ArrayList<String> smallerAns = getSubsequences(smallerString);
        for (String s : smallerAns) {
            ans.add(s);
            ans.add(ch + s);
        }
        return ans;
    }

    // Get Keypad Combinations
    static String[] keys = { ";#,", "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz" };

    public static ArrayList<String> getKpc(String str) {

        ArrayList<String> ans = new ArrayList<>();
        if (str.length() == 0) {
            ans.add("");
            return ans;
        }

        char firstNum = str.charAt(0);
        String smallerString = str.substring(1);

        ArrayList<String> smallerAns = getKpc(smallerString);
        int idx = firstNum - '0';
        String key = keys[idx];
        for (int i = 0; i < key.length(); i++) {
            char keyChar = key.charAt(i);

            for (String s : smallerAns) {
                ans.add(keyChar + s);
            }
        }
        return ans;
    }

    public static ArrayList<String> getStairPaths(int n) {

        ArrayList<String> allPaths = new ArrayList<>();

        // Base Case
        if (n == 0) {
            allPaths.add("");
            return allPaths;
        }
        if (n < 0) {
            return allPaths;
        }

        ArrayList<String> oneStepPaths = getStairPaths(n - 1);
        ArrayList<String> twoStepPaths = getStairPaths(n - 2);
        ArrayList<String> threeStepPaths = getStairPaths(n - 3);

        // paths after taking 1 step
        for (String path : oneStepPaths) {
            allPaths.add("1" + path);
        }

        // paths after taking 2 step
        for (String path : twoStepPaths) {
            allPaths.add("2" + path);
        }

        // paths after taking 3 step
        for (String path : threeStepPaths) {
            allPaths.add("3" + path);
        }
        return allPaths;
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 7, 45, 8, 11 };
        // printArray(arr, 0);
        // printArrayReverse(arr, 0);
        // System.out.println(findMax(arr, 0));
        // System.out.println(getSubsequences("abcd"));
        // System.out.println(getKpc("789"));
        System.out.println(getStairPaths(4));
    }
}