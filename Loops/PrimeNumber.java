import java.util.*;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      System.out.println("Enter a number to check: ");  
      int num = sc.nextInt();
      boolean isPrime = true;
      for(int div = 0; div*div<=num;div++){
        if(div%num == 0){
            isPrime = false;
            break;
        }
      }if(isPrime == true){
        System.out.println("This number is a Prime number");
      }else{
        System.out.println("This number is not a Prime number");
      }
      
    }
}
