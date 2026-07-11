package Arrays;

import java.util.Scanner;

public class nCr {
    public static int findFactorial(int num) {
        int res = 1;
        for (int mul = 1; mul <= num; mul++) {
            res = res * mul;
        }
        return res;
    }

    public static int findNcR(int n, int r) {
        int nFact = findFactorial(n);
        int rFact = findFactorial(r);
        int NmRFact = findFactorial(n - r);
        int ncrResult = nFact / (rFact * NmRFact);
        return ncrResult;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        int n = sc.nextInt();
        System.out.println("Enter the value of r: ");
        int r = sc.nextInt();
        System.out.println("nCr(" + n + ", " + r + ") = " + findNcR(n, r));
        int res = findNcR(n, r);
        System.out.println("The value of nCr is: " + res);
        sc.close();
    }
}