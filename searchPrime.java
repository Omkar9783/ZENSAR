import java.util.Scanner;

public class searchPrime {
    
    public static void main(String[] args) {
        // Range input lene ke liye variables
        int start, end;
        
        // Input handle kar rahe hain
        if (args.length < 2) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Start value dalo: ");
            start = sc.nextInt();
            System.out.print("End value dalo: ");
            end = sc.nextInt();
        } else {
            start = Integer.parseInt(args[0]);
            end = Integer.parseInt(args[1]);
        }

        System.out.println("Prime numbers in range " + start + " to " + end + " are:");
        
        // Saara logic main method ke andar hi hai
        for (int i = start; i <= end; i++) {
            if (i <= 1) continue; // 0 aur 1 prime nahi hote
            
            boolean isPrime = true;
            // Optimised loop: sqrt(i) tak hi check karenge
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false; // Divide ho gaya matlab prime nahi hai
                    break;
                }
            }
            
            if (isPrime) {
                System.out.println(i);
            }
        }
    }
}
