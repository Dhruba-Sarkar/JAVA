package Pattern;
import java.util.Scanner;
public class Pattern2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = sc.nextInt(); 
        int total_lines = input; 
        int current_line = 1; 
        int star = input; 
        while(current_line <= total_lines){
             for(int i = 1; i <= star;i++){ 
                System.out.print("* ");
             } System.out.println(); 
             star--; 
             current_line++; 
            } 
            sc.close();
        }
    }    
