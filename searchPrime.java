import java.util.Scanner;
import java.util.Arrays;

public class searchPrime {
    
    public static void main(String[] args) {
        // Range input handle kar rahe hain
        int start, end;
        
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

        if (end < 2) {
            System.out.println("2 se bada end range dalo prime numbers ke liye.");
            return;
        }

        // Sieve of Eratosthenes implementation
        // Ek boolean array banaya 'isPrime' size 'end + 1'
        boolean[] isPrime = new boolean[end + 1];
        
        // Sabko initially true set kar diya
        Arrays.fill(isPrime, true);
        
        // 0 aur 1 prime nahi hote
        isPrime[0] = false;
        isPrime[1] = false;

        // Sieve ka main logic
        // p*p <= end tak check karenge
        for (int p = 2; p * p <= end; p++) {
            // Agar p prime hai, to uske saare multiples ko false mark kar do
            if (isPrime[p]) {
                for (int i = p * p; i <= end; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // Final result range me print kar rahe hain
        System.out.println("Prime numbers in range " + start + " to " + end + " (using Sieve of Eratosthenes):");
        for (int i = Math.max(start, 2); i <= end; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}
