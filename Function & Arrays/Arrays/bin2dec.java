import java.util.Scanner;

public class bin2dec {
    public static int binToDec(int binary) {
        int decimal = 0;
        int power = 0;
        while (binary > 0) {
            int lastDigit = binary % 10;
            decimal += lastDigit * Math.pow(2, power);
            binary /= 10;
            power++;
        }
        return decimal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        int binary = sc.nextInt();
        int decimal = binToDec(binary);
        System.out.println("The decimal equivalent of " + binary + " is: " + decimal);
        sc.close();
    }
}
