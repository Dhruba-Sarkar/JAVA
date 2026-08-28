public class Main {
    public static void printAllSubset(int[] nums, int idx, int targetSum, String asf) {
        if (idx == nums.length) {
            if (targetSum == 0) {
                System.out.println(asf);
            }
            return;
        }

        printAllSubset(nums, idx + 1, targetSum - nums[idx], asf + nums[idx] + ","); // Yes Call
        printAllSubset(nums, idx + 1, targetSum, asf); // No Call
    }

    // Lets play Chess
    // N Queens
    public static void printVisitedMatrix(boolean[][] vis) {
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[0].length; j++) {
                if (vis[i][j] == true) {
                    System.out.print("( " + i + "," + j + " ) ");
                }
            }
        }
        System.out.println();
    }

    public static boolean isPossibleToPlaceHere(int row, int col, boolean[][] vis) {
        int n = vis.length;
        int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };
        // { -1, -1 }, { -1, 0 }, { -1, 1 } only these directions are required

        for (int rad = 1; rad < n; rad++) {
            for (int[] dir : dirs) {
                int nRow = row + rad * dir[0];
                int nCol = col + rad * dir[1];

                if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < n && vis[nRow][nCol] == true) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void nQueens(int row, int n, boolean[][] vis) {
        if (row == n) {
            printVisitedMatrix(vis);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isPossibleToPlaceHere(row, col, vis) == true) {
                vis[row][col] = true;
                nQueens(row + 1, n, vis);
                vis[row][col] = false;
            }
        }
    }

    // Knight Tour
    public static void printKnightTour(int sr, int sc) {
        int[][] board = new int[8][8];

        knightTour(sr, sc, 0, board);
    }

    public static void knightTour(int row, int col, int moveNumber, int[][] board) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 0) {
            return;
        }
        if (moveNumber == board.length * board.length) { // moveNumber == 64
            printChessBoard(board);
            return;
        }

        board[row][col] = moveNumber;

        knightTour(row - 2, col - 1, moveNumber + 1, board);
        knightTour(row - 2, col + 1, moveNumber + 1, board);
        knightTour(row - 1, col + 2, moveNumber + 1, board);
        knightTour(row + 1, col + 2, moveNumber + 1, board);
        knightTour(row + 2, col + 1, moveNumber + 1, board);
        knightTour(row + 2, col - 1, moveNumber + 1, board);
        knightTour(row + 1, col - 2, moveNumber + 1, board);
        knightTour(row - 1, col - 2, moveNumber + 1, board);

        board[row][col] = 0;
    }

    public static void printChessBoard(int[][] board) {
        System.out.println("Printing a solution ========");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int nums[] = { 2, 2, 3, 11, 1, 4, 0 };
        // int targetSum = 5;

        // printAllSubset(nums, 0, targetSum, "");

        // int n = 4;
        // boolean[][] vis = new boolean[n][n];
        // nQueens(0, n, vis);

        printKnightTour(3, 4);
    }
}
