import java.util.*;

public class SwapString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The String : ");
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder(input);

        for (int i = 0; i < sb.length() / 2; i++) {
            int front = i;
            int back = sb.length() - i - 1;

            char frontChar = sb.charAt(front);
            char backChar = sb.charAt(back);
            sb.setCharAt(front, backChar);
            sb.setCharAt(back, frontChar);

            sc.close();
        }

        System.out.println("The Reverse String is : " + sb);
    }
}

// Output:-
// Enter The String :
// dhruba sarkar
// rakras aburhd