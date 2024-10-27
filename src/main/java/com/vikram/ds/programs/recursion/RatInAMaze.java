package com.vikram.ds.programs.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RatInAMaze {
    public static void main(String[] args) {
        RatInAMaze r = new RatInAMaze();
        int[][] mat =
                {
                    {1,0,0,0},
                    {1,1,0,1},
                    {1,1,0,0},
                    {0,1,1,1}
                };
        List<String> list = r.findPath(mat);
        System.out.println(list);
    }

    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> paths = new ArrayList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        visited[0][0] = true;
        if (mat[0][0] == 0) {
            paths.add("-1");
            return paths;
        }
        getPath(0,0,mat,"",paths,visited);
        Collections.sort(paths);
        return paths;
    }

    private void getPath
            (int row, int col, int[][] mat,
             String curPath,
             ArrayList<String> paths, boolean[][] visited) {
        if (row == mat.length-1 && col == mat[0].length-1) {
            paths.add(curPath);
            return;
        }
        //go right
        if (canGo(row,col+1, mat, visited)) {
            visited[row][col+1] = true;
            getPath(row, col+1, mat, curPath+"R", paths, visited);
            visited[row][col+1] = false;
        }
        //go down
        if (canGo(row+1,col, mat, visited)) {
            visited[row+1][col] = true;
            getPath(row+1, col, mat, curPath+"D", paths, visited);
            visited[row+1][col] = false;
        }
        //go up
        if (canGo(row-1,col, mat, visited)) {
            visited[row-1][col] = true;
            getPath(row-1, col, mat, curPath+"U", paths, visited);
            visited[row-1][col] = false;
        }
        //go left
        if (canGo(row,col-1, mat, visited)) {
            visited[row][col-1] = true;
            getPath(row, col-1, mat, curPath+"L", paths, visited);
            visited[row][col-1] = false;
        }
    }

    private boolean canGo(int row, int col, int[][] mat, boolean[][] visited) {
        if (row >= mat.length || row < 0)
            return false;
        if (col >= mat[0].length || col < 0)
            return false;
        if (mat[row][col] == 0)
            return false;
        if (visited[row][col])
            return false;
        return true;
    }
}
