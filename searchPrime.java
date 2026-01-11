import java.util.Scanner;

public class searchPrime {
    
    public static void main(String[] args) {
        // Prime number find karne ke liye start aur end range lete hain
        int start, end;
        
        // Agar argument nahi diye to user se puchte hain
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
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    // Ye method check karta hai ki number prime hai ya nahi
    // static rakha hai taki main se call ho sake
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false; // 0 aur 1 prime nahi hote
        }
        
        // Optimised logic: sirf sqrt(n) tak check karo
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // agar kisi se divide ho gaya to prime nahi hai
            }
        }
        return true; // warna prime hai
    }
}
