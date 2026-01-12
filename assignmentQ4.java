import java.util.Scanner;

public class assignmentQ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input: Code of any item N
        System.out.print("Enter item code (N): ");
        int n = sc.nextInt();
        
        // Product of digits calculate karne ke liye
        int product = 1;

        // Agar N 0 hai to product 0 hoga
        if (n == 0) {
            product = 0;
        } else {
            // Negative numbers ke liye absolute value le kar handle kar sakte hain
            int temp = Math.abs(n);
            while (temp > 0) {
                int digit = temp % 10;
                product *= digit;
                temp /= 10;
            }
        }
        
        System.out.println("Price of the item (Product of digits): " + product);
    }
}
