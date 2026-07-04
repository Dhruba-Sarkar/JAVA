import java.util.*;

public class Billing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter price of First Product: ");
        double product1 = sc.nextDouble();
        System.out.println("Enter price of Second Product: ");
        double product2 = sc.nextDouble();
        System.out.println("Enter price of Third Product: ");
        double product3 = sc.nextDouble();
        double gst = 0.18;
        double totalMRP = product1 + product2 + product3;
        double totalBasePrice = totalMRP / (1 + gst);
        double totalGST = totalMRP - totalBasePrice;
        System.out.println("===GST BILL===");
        System.out.println("Product 1 :- Excluding GST : " + (product1 / (1 + gst)) + " | GST : " + (product1 * gst)
                + " | : MRP : " + product1);
        System.out.println("Product 2 :- Excluding GST : " + (product2 / (1 + gst)) + " | GST : " + (product2 * gst)
                + " | : MRP : " + product2);
        System.out.println("Product 3 :- Excluding GST : " + (product3 / (1 + gst)) + " | GST : " + (product3 * gst)
                + " | : MRP : " + product3);
        System.out.println("TOTAL BASE PRICE (Without Tax): " + totalBasePrice);
        System.out.println("TOTAL GST PAID : " + totalGST);
        System.out.println("Total Price RS: " + totalMRP);
        sc.close();
    }
}
