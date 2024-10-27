package com.vikram.ds.programs.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int [][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        InsertInterval insertInterval = new InsertInterval();

        int [][] array = insertInterval.insert(intervals, newInterval);
        // Print the 2D array of pairs
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (j < array[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Step 1: Add all intervals that come before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]); // Merge start
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]); // Merge end
            i++;
        }
        result.add(newInterval); // Add the merged new interval

        // Step 3: Add all remaining intervals that come after the new interval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert list back to array
        return result.toArray(new int[result.size()][]);
    }
}

class Interval {
    public int start;
    public int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}