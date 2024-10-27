package com.vikram.ds.programs.recursion;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        SudokuSolver solver = new SudokuSolver();
        solver.solveSudoku(board);
        printBoard(board);
    }

    public void solveSudoku(char[][] board) {
        solve(0,0, board);
    }

    private boolean solve(int row, int col, char[][] board) {
        // Base case: If we've reached the end of the board, we've solved it
        if (row == 9) {
            return true;
        }

        // Move to the next cell in the row or go to the next row if col reaches 9
        if (board[row][col] != '.') {
            if (col != 8) {
                return solve(row, col + 1, board);
            } else {
                return solve(row + 1, 0, board);
            }
        }

        // Try placing each number from '1' to '9' in the current cell
        for (char k = '1'; k <= '9'; k++) {
            if (canFill(row, col, k, board)) {
                board[row][col] = k;

                boolean isSolved;
                if (col != 8) {
                    isSolved = solve(row, col + 1, board);
                } else {
                    isSolved = solve(row + 1, 0, board);
                }
                if (isSolved) {
                    return true;
                }

                // Backtrack if placing k didn't lead to a solution
                board[row][col] = '.';
            }
        }

        // No valid number could solve the board at this position
        return false;
    }

    private boolean canFill(int row, int col, char k, char[][] board) {
        //check row
        for (int j = 0; j < 9; j++) {
            if(board[row][j] == k)
                return false;
        }

        //check col
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == k)
                return false;
        }

        //find box start row
        int startBoxRow = row;
        while (startBoxRow!=0 && startBoxRow!=3 && startBoxRow!=6)
            startBoxRow--;

        //find box start col
        int startBoxCol = col;
        while (startBoxCol!=0 && startBoxCol!=3 && startBoxCol!=6)
            startBoxCol--;

        //check box
        for (int i = startBoxRow; i<startBoxRow+3 ; i++) {
            for (int j = startBoxCol; j<startBoxCol+3; j++) {
                if (board[i][j] == k)
                    return false;
            }
        }
        return true;
    }

    private static void printBoard(char[][] board) {
        for(int i=0; i<9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
