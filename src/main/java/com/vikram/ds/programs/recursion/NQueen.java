package com.vikram.ds.programs.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        List<List<String>> solutions = nQueen.solveNQueens(5);
        solutions.forEach(System.out::println);
    }

    public List<List<String>> solveNQueens(int n) {
        char [][] board = new char [n][n];
        fillBoard(board);
        List<List<String>> solutions = new ArrayList<>();
        solve(0, board, solutions);
        return solutions;
    }

    private void solve(int col, char [][] board, List<List<String>> solutions) {
        if (col == board.length) {
            addBoardToSolutions(board, solutions);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(i, col, board)) {
                board[i][col] = 'Q';
                solve(col+1, board, solutions);
                board[i][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board) {
        //check left
        for (int i = col-1; i>=0; i--) {
            if (board[row][i] == 'Q')
                return false;
        }

        //check up-left diagonal
        for (int j = col-1, i = row - 1; j >=0 && i >= 0 ; j--,i--) {
            if(board[i][j] == 'Q')
                return false;
        }

        //check down-left diagonal
        for (int j = col-1, i = row+1; j>=0 && i<board.length; j--,i++) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
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
