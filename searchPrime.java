import java.util.Scanner;
import java.util.ArrayList;

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

        if (end < 2) {
            System.out.println("Koi primes nahi milenge is range mein.");
            return;
        }

        // Linear Sieve (O(N) Time Complexity)
        // Har composite number exactly ek baar process hota hai
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

        System.out.printf("Primes from %d to %d (using O(N) Linear Sieve):\n", start, end);
        for (int p : primes) {
            if (p >= start) System.out.print(p + " ");
        }
        System.out.println();
    }
}
