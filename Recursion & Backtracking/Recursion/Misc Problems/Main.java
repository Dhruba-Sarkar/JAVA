import java.util.ArrayList;

public class Main {

    // Find Max Path Sum
    public static int findMaxSum(int[][] grid, int row, int col, int n, int m) {

        if (row >= n || col >= m) {
            return Integer.MIN_VALUE;
        }

        if (row == n - 1 && col == m - 1) {
            return grid[row][col];
        }

        int rightMaxSum = findMaxSum(grid, row, col + 1, n, m);
        int downMaxSum = findMaxSum(grid, row + 1, col, n, m);

        int maxSum = Math.max(rightMaxSum, downMaxSum) + grid[row][col];

        return maxSum;

    }

    public static int maxSum(int[][] grid) {
        return findMaxSum(grid, 0, 0, grid.length, grid[0].length);
    }

    // Permutations of String
    public static ArrayList<String> permutationsOfString(String str) {
        ArrayList<String> ans = new ArrayList<>();

        if (str.length() == 0) {
            ans.add("");
            return ans;
        }

        char firstChar = str.charAt(0);
        String smst = str.substring(1);
        ArrayList<String> sm = permutationsOfString(smst);

        for (int i = 0; i < sm.size(); i++) {
            String s = sm.get(i);
            for (int j = 0; j <= s.length(); j++) {
                String leftPart = s.substring(0, j);
                String rightPart = s.substring(j);
                ans.add(leftPart + firstChar + rightPart);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // int[][] grid = { { 3, 6, 1 }, { 2, 3, 4 }, { 5, 5, 1 } };
        // System.out.println(maxSum(grid));

        System.out.println(permutationsOfString("ABC"));
    }
}
