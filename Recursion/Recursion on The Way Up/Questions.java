public class Questions {
    // Print Substring
    public static void printSubSequence(String str, String asf) {
        if (str.length() == 0) {
            System.out.println(asf);
            return;
        }
        char firstChar = str.charAt(0);
        String smallString = str.substring(1);

        printSubSequence(smallString, asf + firstChar);
        printSubSequence(smallString, asf);
    }

    // Get Keypad Combinations
    static String[] keys = { ";#,", "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz" };

    public static void printKPC(String str, String asf) {

        if (str.length() == 0) {
            System.out.print(asf + ",");
            return;
        }

        char firstChar = str.charAt(0);
        String smallerString = str.substring(1);

        int firstNum = firstChar - '0';
        String key = keys[firstNum];
        for (int i = 0; i < key.length(); i++) {
            char keyChar = key.charAt(i);
            printKPC(smallerString, asf + keyChar);
        }

    }

    // Print Stair Paths
    public static void printStairPaths(int n, String psf) {

        if (n < 0)
            return;
        if (n == 0) {
            System.out.print(psf + ",");
            return;
        }
        printStairPaths(n - 1, psf + "1");
        printStairPaths(n - 2, psf + "2");
        printStairPaths(n - 3, psf + "3");

    }

    // Print Maze Path
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {

        if (sr > dr || sc > dc) {
            return;
        }
        if (sr == dr && sc == dc) {
            System.out.println(psf + ",");
            return;
        }

        printMazePaths(sr, sc + 1, dr, dc, psf + "h");
        printMazePaths(sr + 1, sc, dr, dc, psf + "v");

    }

    // Print Maze Path with Jumps
    public static void printMazePathWithJumps(int sr, int sc, int dr, int dc, String psf) {
        if (sr > dr || sc > dc) {
            return;
        }
        if (sr == dr && sc == dc) {
            System.out.print(psf + ", ");
        }

        // Horizontal Jumps
        for (int jump = 1; jump <= dc - sc; jump++) {
            printMazePathWithJumps(sr, sc + jump, dr, dc, psf + "h" + jump);
        }

        // Vertical Jumps
        for (int jump = 1; jump <= dr - sr; jump++) {
            printMazePathWithJumps(sr + jump, sc, dr, dc, psf + "v" + jump);
        }
    }

    public static void main(String[] args) {
        // printSubSequence("abc", " ");
        // printKPC("789", "");
        // printStairPaths(4, "");
        // printMazePaths(0, 0, 1, 2, "");
        printMazePathWithJumps(0, 0, 2, 2, "");
    }
}
