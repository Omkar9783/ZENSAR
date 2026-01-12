import java.util.Scanner;

public class assignmentQ5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input: Total number of members (N)
        System.out.print("Enter number of members (N): ");
        int n = sc.nextInt();
        
        // Base case: 2 se kam members mein pair seating possible nahi hai
        if (n < 2) {
            System.out.println("Ways: 0 (At least 2 members required for a pair)");
            return;
        }

        /* 
           Logic:
           1. President aur PM ko 1 unit maan lo.
           2. Ab total items huye (N - 2 + 1) = (N - 1).
           3. Circular table par (m) items arrange karne ke (m-1)! treeke hote hain.
           4. To (N-1) items ke liye ((N-1) - 1)! = (N-2)! ways.
           5. President aur PM aapas mein 2! = 2 tareeke se baith sakte hain.
           Total Ways = (N-2)! * 2
        */

        long factorial = 1;
        for (int i = 1; i <= (n - 2); i++) {
            factorial *= i;
        }

        long totalWays = factorial * 2;
        
        System.out.println("Possible ways (P): " + totalWays);
    }
}
