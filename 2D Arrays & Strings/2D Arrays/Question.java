import java.util.ArrayList;
import java.util.List;

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
    public static void WaveTraversal(int[][] arr) {
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
    public static void SpiralMatrix(int[][] arr) {

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

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4, 5, 6 },
                { 17, 19, 13, 11, 9, 7 },
                { 22, 15, 12, 10, 8, 20 },
                { 18, 21, 23, 14, 23, 16 }
        };
        // WaveTraversal(arr);
        SpiralMatrix(arr);
    };
}
