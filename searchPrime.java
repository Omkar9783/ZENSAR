import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

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

        System.out.println("\n1. Normal Method (Trial Division):");
        normalSieve(start, end);

        System.out.println("\n2. Sieve of Eratosthenes (Boolean Array):");
        eratosthenesSieve(start, end);

        System.out.println("\n3. Linear Sieve (O(N)):");
        linearSieve(start, end);

        System.out.println("\n4. Manual Deletion Sieve (Literal Removal):");
        manualDeletionSieve(start, end);
    }

    /**
     * Method 1: Normal Trial Division
     * TC: O(N^2), SC: O(1)
     */
    public static void normalSieve(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (i <= 1) continue;
            boolean isPrime = true;
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

    /**
     * Method 2: Sieve of Eratosthenes (Optimized with marking)
     * TC: O(N log log N), SC: O(N)
     */
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

    /**
     * Method 3: Linear Sieve
     * TC: O(N), SC: O(N)
     */
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

    /**
     * Method 4: Manual Deletion Sieve
     * Logic: Literally "removes" multiples from a list one by one.
     * Time Complexity (TC): O(N * (N/log N)) - Slow due to list shifting during removal.
     * Space Complexity (SC): O(N) - Uses an ArrayList to store all numbers.
     */
    public static void manualDeletionSieve(int start, int end) {
        if (end < 2) return;
        
        // 1. Fill a list from 2 to end
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 2; i <= end; i++) nums.add(i);

        // 2. Start from first prime (2)
        for (int i = 0; i < nums.size(); i++) {
            int currentPrime = nums.get(i);
            
            // 3. Literally remove all multiples of currentPrime that come AFTER it
            Iterator<Integer> it = nums.iterator();
            while (it.hasNext()) {
                int nextVal = it.next();
                if (nextVal > currentPrime && nextVal % currentPrime == 0) {
                    it.remove(); // This is the "removal" step you described
                }
            }
            
            // Optimization: Stop if currentPrime exceeds sqrt(end)
            if (currentPrime * currentPrime > end) break;
        }

        // 4. Print remaining result in range
        for (int n : nums) {
            if (n >= start) System.out.print(n + " ");
        }
        System.out.println();
    }
}
