import java.util.Scanner;

public class assignmentQ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input: Start day of the month (e.g., mon, tue, sun)
        System.out.print("Enter starting day of the month (e.g., sun, mon, tue): ");
        String startDay = sc.next().toLowerCase();
        
        // Input: Total number of days
        System.out.print("Enter total number of days: ");
        int n = sc.nextInt();
        
        if (n <= 0) {
            System.out.println("0");
            return;
        }

        // Days mapping code (sun=0 to sat=6)
        String[] days = {"sun", "mon", "tue", "wed", "thu", "fri", "sat"};
        int startIdx = -1;
        for (int i = 0; i < 7; i++) {
            if (days[i].equals(startDay)) {
                startIdx = i;
                break;
            }
        }

        if (startIdx == -1) {
            System.out.println("Invalid day entered.");
            return;
        }

        // Logic: Pehla Sunday aane mein kitne din lagenge
        // Agar aaj Sunday hai to 1st day hi Sunday hai
        int daysToFirstSunday = (7 - startIdx) % 7;
        
        int count = 0;
        if (n > daysToFirstSunday) {
            // Formula: 1 (for first sunday) + remaining complete weeks
            count = 1 + (n - daysToFirstSunday - 1) / 7;
        }

        System.out.println("Number of Sundays: " + count);
    }
}
