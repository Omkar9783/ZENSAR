import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class searchPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start, end;

        if (args.length >= 2) {
            start = Integer.parseInt(args[0]);
            end = Integer.parseInt(args[1]);
        } else {
            System.out.print("Enter start and end: ");
            start = sc.nextInt();
            end = sc.nextInt();
        }

        System.out.println("\n--- Comparison of Prime Finding Algorithms ---");

        // 1. Normal Method (O(N^2))
        System.out.println("\n1. Normal Method (Trial Division O(N^2)):");
        normalSieve(start, end);

        // 2. Sieve of Eratosthenes (O(N log log N))
        System.out.println("\n2. Sieve of Eratosthenes (O(N log log N)):");
        eratosthenesSieve(start, end);

        // 3. Linear Sieve (O(N))
        System.out.println("\n3. Linear Sieve (O(N)):");
        linearSieve(start, end);
    }

    // Method 1: Normal Trial Division (2 for loops, O(N^2))
    public static void normalSieve(int start, int end) {
        // Bahar ka loop range ke liye
        for (int i = start; i <= end; i++) {
            if (i <= 1) continue;
            boolean isPrime = true;
            // Andar ka loop divisor check karne ke liye (Naive O(N) check inside O(N) loop)
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) System.out.print(i + " ");
        }
        System.out.println();
    }

    // Method 2: Sieve of Eratosthenes (O(N log log N))
    public static void eratosthenesSieve(int start, int end) {
        if (end < 2) return;
        boolean[] isPrime = new boolean[end + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int p = 2; p * p <= end; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= end; i += p)
                    isPrime[i] = false;
            }
        }

        for (int i = Math.max(start, 2); i <= end; i++) {
            if (isPrime[i]) System.out.print(i + " ");
        }
        System.out.println();
    }

    // Method 3: Linear Sieve (O(N))
    public static void linearSieve(int start, int end) {
        if (end < 2) return;
        int[] minPrime = new int[end + 1];
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= end; i++) {
            if (minPrime[i] == 0) {
                minPrime[i] = i;
                primes.add(i);
            }
            for (int p : primes) {
                if (p > minPrime[i] || (long)i * p > end) break;
                minPrime[i * p] = p;
            }
        }

        for (int p : primes) {
            if (p >= start) System.out.print(p + " ");
        }
        System.out.println();
    }
}
