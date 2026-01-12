import java.util.Scanner;

public class assignmentQ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long MOD = 1000000007L;
        
        // Input: Number of elements and queries
        System.out.print("Enter n and q: ");
        int n = sc.nextInt();
        int q = sc.nextInt();
        
        long[] A = new long[n + 1]; // 1-based indexing use kar rahe hain
        System.out.println("Enter array elements: ");
        for (int i = 1; i <= n; i++) {
            A[i] = sc.nextLong();
        }
        
        long totalType2Sum = 0;
        
        System.out.println("Enter " + q + " queries (type, l, r): ");
        for (int k = 0; k < q; k++) {
            int type = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            
            if (type == 1) {
                // Type 1: Replace A[i] with (i - l + 1) * A[l]
                long baseValue = A[l];
                for (int i = l; i <= r; i++) {
                    A[i] = (long)(i - l + 1) * baseValue;
                }
            } else if (type == 2) {
                // Type 2: Calculate sum from l to r
                long currentQuerySum = 0;
                for (int i = l; i <= r; i++) {
                    currentQuerySum = (currentQuerySum + A[i]) % MOD;
                }
                // Type 2 query ka result total sum mein add karo
                totalType2Sum = (totalType2Sum + currentQuerySum) % MOD;
            }
        }
        
        System.out.println("Total sum of all Type 2 answers: " + totalType2Sum);
    }
}
