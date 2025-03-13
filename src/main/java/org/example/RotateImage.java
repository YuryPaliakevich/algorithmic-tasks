package org.example;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int [][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        new Solution().rotate(matrix);

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static class Solution {
        public void rotate(int[][] matrix) {
            int startPoint = 0;
            int n = matrix[0].length;
            while (startPoint < n / 2) {
                for (int i = startPoint, j = 0; i < n - startPoint - 1; i++, j++) {
                    int var = matrix[i][n - startPoint - 1];
                    matrix[i][n - startPoint - 1] = matrix[startPoint][i];

                    int var1 = matrix[n - startPoint - 1][n - startPoint - j - 1];
                    matrix[n - startPoint - 1][n - startPoint - j - 1] = var;

                    var = matrix[n - startPoint - j - 1][startPoint];
                    matrix[n - startPoint - j - 1][startPoint] = var1;

                    matrix[startPoint][i] = var;
                }
                startPoint++;
            }
        }
    }

}
