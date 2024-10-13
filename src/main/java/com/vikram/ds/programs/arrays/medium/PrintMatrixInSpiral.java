package com.vikram.ds.programs.arrays.medium;

public class PrintMatrixInSpiral {
    public static void main(String[] args) {
        int[][] arr = {
                {1 , 2  , 3  , 4},
                {5 , 6  , 7  , 8},
                {9 , 10 , 11 , 12},
                {13, 14 , 15 , 16}
        };
        //printMatrix(arr);
        printMatrixInSpiral(arr);
    }

    private static void printMatrixInSpiral(int[][] arr) {
        int l = 0;                    // left boundary
        int r = arr[0].length - 1;     // right boundary
        int u = 0;                    // upper boundary
        int b = arr.length - 1;        // bottom boundary

        while (l <= r && u <= b) {
            // Print top row (left to right)
            for (int i = l; i <= r; i++)
                System.out.print(arr[u][i] + " ");
            u++; // move the upper boundary down

            // Print right column (top to bottom)
            for (int i = u; i <= b; i++)
                System.out.print(arr[i][r] + " ");
            r--; // move the right boundary left

            // Check if there are remaining rows and columns
            if (u <= b) {
                // Print bottom row (right to left)
                for (int i = r; i >= l; i--)
                    System.out.print(arr[b][i] + " ");
                b--; // move the bottom boundary up
            }

            if (l <= r) {
                // Print left column (bottom to top)
                for (int i = b; i >= u; i--)
                    System.out.print(arr[i][l] + " ");
                l++; // move the left boundary right
            }
        }
    }

    private static void printMatrix(int[][] arr) {
        for (int i=0;i<arr.length;i++) {
           for (int j=0;j<arr.length;j++) {
               System.out.print(arr[i][j]+" ");
           }
            System.out.println();
        }
        System.out.println();
    }
}
