import java.util.Scanner;

public class assignmentQ6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input: Number N (liya string mein kyunki N bahut bada ho sakta hai)
        System.out.print("Enter number (N): ");
        String nStr = sc.next();
        
        // Input: Number of repetitions (R)
        System.out.print("Enter repetitions (R): ");
        long r = sc.nextLong();
        
        // Step 1: N ke digits ka initial sum nikal lo
        long initialSum = 0;
        for (char ch : nStr.toCharArray()) {
            initialSum += (ch - '0');
        }
        
        // Step 2: Pure number ka total sum (initialSum * R)
        long totalSum = initialSum * r;
        
        // Step 3: Single digit sum (Digital Root) nikalne ka efficient tarika
        /* 
           Property: Digital root of X is (X % 9). 
           Agar remainder 0 hai aur X > 0, to digital root 9 hota hai.
        */
        long result = totalSum % 9;
        if (result == 0 && totalSum > 0) {
            result = 9;
        }
        
        System.out.println("Single digit sum: " + result);
    }
}
