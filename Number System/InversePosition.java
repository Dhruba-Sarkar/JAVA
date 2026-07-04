
import java.util.*;

public class InversePosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        System.out.print("Enter the number: ");
        int n = sc.nextInt();        
        int inverse = 0;
        int pos = 1;        
        while(n > 0) {
            int originalValue = n % 10;
            int powerOf10 = (int) Math.pow(10, originalValue - 1);
            inverse = inverse + (pos * powerOf10);            
            n = n / 10;
            pos++;
            
            
        }        
        System.out.println("Inverse is: " + inverse);  
        sc.close();    
    }
}