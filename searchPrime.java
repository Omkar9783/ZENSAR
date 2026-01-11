// Scanner utility import kiya keyboard se input lene ke liye
import java.util.Scanner;
// Arrays utility import kiya boolean array ko check karne aur fill karne ke liye
import java.util.Arrays;

// Main class declare ki jiska naam searchPrime rakha hai
public class searchPrime {
    // Program ka starting point static main method define kiya
    public static void main(String[] args) {
        // System input read karne ke liye Scanner ka ek object sc banaya
        Scanner sc = new Scanner(System.in);
        // Start aur End range calculate aur store karne ke liye integer variables liye
        int start, end;

        // Command line arguments check kiye taaki bina manual input ke bhi chale
        if (args.length >= 2) {
            // Pehla argument liya aur usko start range mark kiya
            start = Integer.parseInt(args[0]);
            // Dusra argument liya aur usko end range mark kiya
            end = Integer.parseInt(args[1]);
        // Agar arguments nahi diye gaye toh manual prompt denge
        } else {
            // User ko input dene ke liye display message diya
            System.out.print("Enter start and end: ");
            // Keyboard se first integer scan karke start mein store kiya
            start = sc.nextInt();
            // Keyboard se second integer scan karke end mein store kiya
            end = sc.nextInt();
        // Manual input ka block yahan end hota hai
        }

        // Check kiya ki user ne jo range di hai usmein primes mil sakte hain ya nahi
        if (end < 2) {
            // Agar range 2 se kam hai toh seedha message print kiya
            System.out.println("Koi primes nahi milenge is range mein.");
            // Program ko yahan se terminate kar diya
            return;
        // Range check ka logic end hua
        }

        // Boolean array banaya jismein true matlab prime aur false matlab non-prime
        boolean[] isPrime = new boolean[end + 1];
        // Shuruat mein maanke chala ki saare numbers prime hain toh sabko true fill kiya
        Arrays.fill(isPrime, true);
        // Ganit ke hisaab se 0 aur 1 prime nahi hote isliye manually false mark kiya
        isPrime[0] = isPrime[1] = false;

        // Sieve algorithm start kiya, loop prime factors 2 se lekar square root range tak
        for (int p = 2; p * p <= end; p++) {
            // Check kiya ki current number 'p' abhi bhi prime category mein hai ya nahi
            if (isPrime[p]) {
                // Agar p prime hai, toh uske saare multiples range mein composite honge
                for (int i = p * p; i <= end; i += p)
                    // In saare multiples ko false mark kiya kyunki ye kisi se divide ho rahe hain
                    isPrime[i] = false;
            // Multiples hatane ka loop khatam
            }
        // Main algorithm ka loop khatam
        }

        // Output beautify karne ke liye header message print kiya
        System.out.printf("Primes from %d to %d:\n", start, end);
        // User ki mangi gayi range (start se end) mein numbers check kiye
        for (int i = Math.max(start, 2); i <= end; i++) {
            // Agar array mein value true bachi hai toh wo definitely prime hai
            if (isPrime[i]) System.out.print(i + " ");
        // Printing ka loop end hua
        }
        // Saare primes dikhane ke baad output row ko end kiya
        System.out.println();
    // Main method ki body band ki
    }
// Puri class ka boundary yahan end hota hai
}
