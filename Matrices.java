import java.util.*;

public class Matrices {
    public static void printArrays(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void matrices(int arr[][]) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        printArrays(arr);
    }

    public static boolean findKey(int arr[][], int key) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == key) {
                    System.out.println("key found at index (" + i + "," + j + ")");
                    return true;
                }
            }
        }
        System.out.println("key not found");
        return false;
    }

    public static void largestOrSmallest(int arr[][]) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (largest < arr[i][j]) {
                    largest = arr[i][j];
                }
                if (smallest > arr[i][j]) {
                    smallest = arr[i][j];
                }
            }
        }
        System.out.println("Largest number is " + largest);
        System.out.println("Smallest number is " + smallest);
    }

    public static int diagonalSum(int arr[][]) {
        matrices(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
            if (i != arr.length - 1 - i) {
                sum += arr[i][arr.length - 1 - i];
            }
        }
        return sum;
    }

    public static boolean staircaseSearch(int matrix[][], int key) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("key found at (" + row + "," + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }

        }
        System.out.println("Key not found");
        return false;
    }

    public static int count7(int arr[][], int key) {
        int count7 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[i].length; j++) {
                if (arr[i][j] == 7) {
                    count7++;
                }
            }
        }
        System.out.println("count of 7 is " + count7);
        return count7;
    }

    public static int sumOf2ndArray(int arr[][]) {
        int sum = 0;
        for (int i = 0; i < arr[0].length; i++) {
            sum += arr[1][i];
        }
        System.out.println("sum is " + sum);
        return sum;
    }

    public static void main(String args[]) {
        int matrix[][] = { { 4, 7, 8 },
                { 8, 8, 7 } };
        sumOf2ndArray(matrix);
    }
}