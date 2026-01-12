import java.util.Scanner;

public class assignmentQ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Array size input le rahe hain
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        
        // Edge case: empty array
        if (n <= 0) {
            System.out.println("0");
            return;
        }
        
        int[] arr = new int[n];
        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // 1st element hamesha count hoga as per question note
        int count = 1;
        int maxSoFar = arr[0];
        
        // Loop range: 2nd element se end tak
        for (int i = 1; i < n; i++) {
            // Agar current element pichle sabse bade element se bhi bada hai
            if (arr[i] > maxSoFar) {
                count++;
                maxSoFar = arr[i]; // Update max to current element
            }
        }
        
        System.out.println("Count of elements greater than prior elements: " + count);
    }
}
