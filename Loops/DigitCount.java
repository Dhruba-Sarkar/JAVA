package Loops;
import java.util.*;
public class DigitCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      System.out.println("Enter a number to check: ");  
      int num = sc.nextInt();
        int count = 0;
        while(num>0){
            num=num/10;
            count++;
    }
    System.out.println(count);
}
}
