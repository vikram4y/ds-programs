package com.vikram.ds.programs.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueenSafeCheckOptimized {
    public static void main(String[] args) {
        NQueenSafeCheckOptimized nQueen = new NQueenSafeCheckOptimized();
        List<List<String>> solutions = nQueen.solveNQueens(4);
        solutions.forEach(System.out::println);
    }

    public List<List<String>> solveNQueens(int n) {
        char [][] board = new char [n][n];
        fillBoard(board);
        List<List<String>> solutions = new ArrayList<>();
        int [] row = new int[board.length];
        int [] lowerDiagonal = new int[2*board.length+1];
        int [] upperDiagonal = new int[2*board.length+1];
        solve(0, board, solutions, row, lowerDiagonal, upperDiagonal);
        return solutions;
    }

    private void solve
            (int col, char [][] board, List<List<String>> solutions,
             int[] row, int[] lowerDiagonal, int[] upperDiagonal) {
        if (col == board.length) {
            addBoardToSolutions(board, solutions);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (row[i] != 1 && lowerDiagonal[i+col] != 1 && upperDiagonal[col+board.length-1-i] != 1) {
                //set
                row[i] = 1;
                lowerDiagonal[i+col] = 1;
                upperDiagonal[col+board.length-1-i] = 1;

                board[i][col] = 'Q';
                solve(col+1, board, solutions, row, lowerDiagonal, upperDiagonal);
                board[i][col] = '.';

                //unset
                row[i] = 0;
                lowerDiagonal[i+col] = 0;
                upperDiagonal[col+board.length-1-i] = 0;
            }
        }
    }

    private void addBoardToSolutions(char [][] board, List<List<String>> solutions) {
        List<String> solution = new ArrayList<>();
        for (int i=0; i<board.length;i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<board[i].length; j++) {
                sb.append(board[i][j]);
            }
            solution.add(sb.toString());
        }
        solutions.add(solution);
    }

    private void fillBoard(char[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board.length;j++) {
                board[i][j] = '.';
            }
        }
    }
}
