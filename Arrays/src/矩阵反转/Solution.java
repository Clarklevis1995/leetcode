package 矩阵反转;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(transpose(A)));

    }

    public static int[][] transpose(int[][] A){
        int row = A.length;
        int column = A[0].length;

        int newRow = column;
        int newColumn = row;

        int[][] result = new int[newRow][newColumn];

        for (int i = 0; i < newRow; i++) {
            for (int j = 0; j < newColumn; j++) {
                result[i][j] = A[j][i];
            }
        }
        return result;
    }
}
