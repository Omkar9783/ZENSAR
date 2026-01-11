// best time complexity O(n^2) and space complexity O(1)
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
        rotateMatrixClockwise(odd_matrix);
        System.out.println("Rotated Odd Matrix:");
        printMatrix(odd_matrix);

        System.out.println("\nOriginal Even Matrix:");
        printMatrix(even_matrix);
        rotateMatrixClockwise(even_matrix);
        System.out.println("Rotated Even Matrix:");
        printMatrix(even_matrix);
    }

    public static void rotateMatrixClockwise(int[][] matrix) {
        int n = matrix.length;

        // 1. Transpose: row ko column bana diya
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 2. Reverse each row: horizontal flip
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
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
