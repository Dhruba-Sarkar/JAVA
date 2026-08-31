import java.util.*;

public class Sudoku {
    public static boolean canPlaceNumber(int row, int col, char[][] board, int num) {
        // Check Row==============
        for (int j = 0; j < 9; j++) {
            if (board[row][j] - '0' == num) {
                return false;
            }
        }

        // Check Col==============
        for (int i = 0; i < 9; i++) {
            if (board[i][col] - '0' == num) {
                return false;
            }
        }

        // Check 3X3 Box===========
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] - '0' == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean fillEmptyCells(ArrayList<int[]> emptyCells, int idx, char[][] board) {
        if (idx == emptyCells.size())
            return true;

        int row = emptyCells.get(idx)[0];
        int col = emptyCells.get(idx)[1];

        for (int num = 1; num <= 9; num++) {
            if (canPlaceNumber(row, col, board, num)) {
                board[row][col] = (char) (num + '0');

                if (fillEmptyCells(emptyCells, idx + 1, board)) {
                    return true; // Dont change it to next num, This is the solution
                }
                board[row][col] = '.'; // go on to next num
            }
        }
        return false;
    }

    // Leetcode 37 =================
    public static void solveSudoku(char[][] board) {
        ArrayList<int[]> emptyCells = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    emptyCells.add(new int[] { row, col });
                }
            }
        }
        fillEmptyCells(emptyCells, 0, board);
    }

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }
}
