// best time complexity O(n^2) and space complexity O(1)
// Special Case: Diagonal elements remain fixed
public class rotate_2d_matrix_clockwise {
    public static void main(String[] args) {
        int[][] odd_matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] even_matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        System.out.println("Original Odd Matrix:");
        printMatrix(odd_matrix);
        rotateMatrixClockwiseFixedDiagonals(odd_matrix);
        System.out.println("Rotated Odd Matrix (Diagonals Fixed):");
        printMatrix(odd_matrix);

        System.out.println("\nOriginal Even Matrix:");
        printMatrix(even_matrix);
        rotateMatrixClockwiseFixedDiagonals(even_matrix);
        System.out.println("Rotated Even Matrix (Diagonals Fixed):");
        printMatrix(even_matrix);
    }

    // Logic: Diagonal elements skip kar rahe hain rotation process se
    public static void rotateMatrixClockwiseFixedDiagonals(int[][] matrix) {
        int n = matrix.length;

        // Layer by layer 4-way swap logic use kar rahe hain
        // Taki diagonal condition check karna aasan ho
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                
                // Diagonal elements ka check: i==j or i+j == n-1
                // Agar source or target diagonally fixed hai to skip
                if (isDiagonal(i, j, n) || isDiagonal(j, n - 1 - i, n) || 
                    isDiagonal(n - 1 - i, n - 1 - j, n) || isDiagonal(n - 1 - j, i, n)) {
                    continue;
                }

                // Standard 4-way swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    // Private helper method to check if a cell is on a diagonal
    private static boolean isDiagonal(int r, int c, int n) {
        return (r == c) || (r + c == n - 1);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}
