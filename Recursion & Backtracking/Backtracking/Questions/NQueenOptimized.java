public class NQueenOptimized {

    public static void nQueensOptimized(int row, boolean[] colVis, boolean[] diagVis, boolean[] aDiagVis, String asf,
            int n) {
        if (row == n) {
            System.out.println(asf);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (colVis[col] == false && diagVis[col - row + n - 1] == false && aDiagVis[row + col] == false) {
                colVis[col] = true;
                diagVis[col - row + n - 1] = true;
                aDiagVis[row + col] = true;

                nQueensOptimized(row + 1, colVis, diagVis, aDiagVis, asf + "[" + row + "," + col + "]", n);

                colVis[col] = false;
                diagVis[col - row + n - 1] = false;
                aDiagVis[row + col] = false;
            }
        }
    }

    // Leetcode 52 ========================
    public static void printAllSolutions(int n) {
        boolean[] colVis = new boolean[n];
        boolean[] diagVis = new boolean[2 * n - 1];
        boolean[] aDiagVis = new boolean[2 * n - 1];

        nQueensOptimized(0, colVis, diagVis, aDiagVis, "", n);
    }

    public static void main(String[] args) {

        int n = 4;
        System.out.println("All solutions for " + n + "x" + n + " board:");
        printAllSolutions(n);

    }
}
