import java.util.*;

public class findX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Rows Count : ");
        int rows = sc.nextInt();
        System.out.println("Enter Colms Count : ");
        int colms = sc.nextInt();
        int[][] numbers = new int[rows][colms];

        System.out.println("Enter Input : ");
        // input
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colms; j++) {
                numbers[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter Number to find : ");
        int x = sc.nextInt();

        // output
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colms; j++) {
                if (numbers[i][j] == x) {
                    System.out.println("X found at " + i + "," + j);
                }
            }
        }
        sc.close();
    }
}