import java.util.*;

public class Question {

    // Find Exit Point
    public List<Integer> findExitPoint(int[][] mat) {
        int row = 0;
        int col = 0;
        int dir = 0;
        int n = mat.length;
        int m = mat[0].length;

        while (row < n && col < m && row >= 0 && col >= 0) {
            if (mat[row][col] == 1) {
                mat[row][col] = 0;
                dir = (dir + 1) % 4;
            }
            if (dir == 0) {
                col++;
            } else if (dir == 1) {
                row++;
            } else if (dir == 2) {
                col--;
            } else if (dir == 3) {
                row--;
            }

        }
        if (row < 0)
            row++;
        if (col < 0)
            col++;
        if (row == n)
            row--;
        if (col == m)
            col--;

        List<Integer> al = new ArrayList<>();
        al.add(row);
        al.add(col);

        return al;
    }

    // Wave Traversal
    public static void waveTraversal(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        for (int col = 0; col < m; col++) {

            // For Even Columns
            if (col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    System.out.print(arr[row][col] + ",");
                }

            }
            // For Odd Columns
            else {
                for (int row = n - 1; row >= 0; row--) {
                    System.out.print(arr[row][col] + ",");
                }
            }
            System.out.println();
        }
    }

    // Spiral Matrix
    public static void spiralMatrix(int[][] arr) {

        int n = arr.length;
        int m = arr[0].length;

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;

        while (top <= bottom && left <= right) {

            // Top Rows
            for (int row = top, col = left; col <= right; col++) {
                System.out.print(arr[row][col] + "  ");
            }
            top++;

            // Right Cols
            for (int row = top, col = right; row <= bottom; row++) {
                System.out.print(arr[row][col] + " ");
            }
            right--;

            // Bottom Rows
            if (top <= bottom) {
                for (int row = bottom, col = right; col >= left; col--) {
                    System.out.print(arr[row][col] + " ");
                }
                bottom--;
            }

            // Left Cols
            if (left <= right) {
                for (int row = bottom, col = left; row >= top; row--) {
                    System.out.print(arr[row][col] + " ");

                }
                left++;
            }
            System.out.println();
        }
    }

    // Transpose of Matrix
    public static void transposeMatrix(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            reverse(arr[i]);
        }
    }

    // Reverse of Matrix
    public static void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4, 5, 6 },
                { 17, 19, 23, 31, 37, 39 },
                { 22, 24, 32, 40, 41, 50 },
                { 13, 26, 33, 44, 43, 56 },
                { 27, 35, 44, 46, 48, 53 },
                { 58, 61, 52, 54, 63, 69 }

        };
        // waveTraversal(arr);
        // spiralMatrix(arr);
        transposeMatrix(arr);
    };
}
