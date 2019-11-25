import java.util.Arrays;

/**
 * Rotate matrix using O(1) space
 */

public class MatrixRotate {

    public static void main(String[] args) {
        // Init test matrix
        final int MATRIX_SIZE = 4;
        int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 4;
        matrix[1][0] = 5;
        matrix[1][1] = 6;
        matrix[1][2] = 7;
        matrix[1][3] = 8;
        matrix[2][0] = 9;
        matrix[2][1] = 10;
        matrix[2][2] = 11;
        matrix[2][3] = 12;
        matrix[3][0] = 13;
        matrix[3][1] = 14;
        matrix[3][2] = 15;
        matrix[3][3] = 16;
        // Show init matrix
        matrixPrn(matrix);
        // Rotate matrix by elements
        for (int layer = 0; layer < MATRIX_SIZE / 2; layer++) {
            int first = layer;
            int last = MATRIX_SIZE - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top
                matrix[first][i] = matrix[last - offset][first]; // left -> top
                matrix[last - offset][first] = matrix[last][last - offset]; // bottom -> left
                matrix[last][last - offset] = matrix[i][last]; // right -> bottom
                matrix[i][last] = top;// saved top -> right
            }
        }
        // Show result
        matrixPrn(matrix);
    }

    // Show matrix
    public static void matrixPrn(int[][] matrix) {
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
        System.out.print("\n");
    }

}
