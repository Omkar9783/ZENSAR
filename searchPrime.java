import java.util.Scanner;
import java.util.Arrays;

public class searchPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start, end;

        // Argument validation and input handling
        if (args.length >= 2) {
            start = Integer.parseInt(args[0]);
            end = Integer.parseInt(args[1]);
        } else {
            System.out.print("Enter start and end: ");
            start = sc.nextInt();
            end = sc.nextInt();
        }

        if (end < 2) {
            System.out.println("Koi primes nahi milenge is range mein.");
            return;
        }

        // Sieve of Eratosthenes - engineering student approach
        boolean[] isPrime = new boolean[end + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int p = 2; p * p <= end; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= end; i += p)
                    isPrime[i] = false;
            }
        }

        // Results display
        System.out.printf("Primes from %d to %d:\n", start, end);
        for (int i = Math.max(start, 2); i <= end; i++) {
            if (isPrime[i]) System.out.print(i + " ");
        }
        System.out.println(); // newline for clean exit
    }
}
