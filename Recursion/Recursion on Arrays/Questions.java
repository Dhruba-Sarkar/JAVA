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

    // Get Stair Paths
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

    // Get All Maze Paths
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        ArrayList<String> allPaths = new ArrayList<>();
        if (sr > dr || sc > dc) {
            return allPaths;
        }
        if (sr == dr && sc == dc) {
            allPaths.add("");
            return allPaths;
        }

        ArrayList<String> pathsAfterHStep = getMazePaths(sr, sc + 1, dr, dc);
        ArrayList<String> pathsAfterVStep = getMazePaths(sr + 1, sc, dr, dc);

        for (String path : pathsAfterHStep) {
            allPaths.add("h" + path);
        }
        for (String path : pathsAfterVStep) {
            allPaths.add("v" + path);
        }
        return allPaths;
    }

    // Get Maze Paths With Jumps
    public static ArrayList<String> getMazePathWithJumps(int sr, int sc, int dr, int dc) {
        ArrayList<String> allPaths = new ArrayList<>();
        if (sr == dr && sc == dc) {
            allPaths.add("");
            return allPaths;
        }
        // Horizontal Jumps
        for (int jump = 1; jump <= dc - sc; jump++) {
            ArrayList<String> pathsAfterHJump = getMazePathWithJumps(sr, sc + jump, dr, dc);

            for (String path : pathsAfterHJump) {
                allPaths.add("h" + jump + path);
            }
        }

        // Vertical Jumps
        for (int jump = 1; jump <= dr - sr; jump++) {
            ArrayList<String> pathsAfterVJump = getMazePathWithJumps(sr + jump, sc, dr, dc);

            for (String path : pathsAfterVJump) {
                allPaths.add("v" + jump + path);
            }
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
        // System.out.println(getStairPaths(4));
        // int arr[] = { 10, 19, 4, 5, 1, 19, 4, 4, 11, 19 };
        // System.out.println(findFirstIndex(arr, 4, 0));
        // System.out.println(findLastIndex(arr, 19, 0));

        // int ans[] = findAllIndices(arr, 4, 0, 0);
        // for (int i = 0; i < ans.length; i++) {
        // System.out.print(ans[i] + " ");
        // }

        ArrayList<String> ans = getMazePathWithJumps(0, 0, 2, 2);
        System.out.println(ans);
    }
}