
public class Main {
    public static void filValues(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (i + j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[5][3];
        filValues(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + ",");
            }
            System.out.println();
        }
    }
}
