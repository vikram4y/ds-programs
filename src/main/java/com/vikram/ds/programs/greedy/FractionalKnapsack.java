package com.vikram.ds.programs.greedy;

import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[][] arr = {{100,20}, {60,10}, {100,50}, {200,50}};
        int W = 90;
        int maxValue = getMaxValue(arr, W);
        System.out.println("Maximum Value = "+maxValue);
    }

    private static int getMaxValue(int[][] arr, int w) {
        Arrays.sort(arr, (a, b) -> Double.compare((double) b[0] / b[1], (double) a[0] / a[1]));
        int filled = 0;
        int i = 0;
        int value = 0;
        while (filled < w && i < arr.length) {
            if (filled + arr[i][1] <= w) {
                filled = filled + arr[i][1];
                value = value + arr[i][0];
                i++;
            } else {
                break;
            }
        }
        if (i < arr.length && filled < w) {
            int remains = w-filled;
            value += (arr[i][0] * remains) / arr[i][1];
        }
        return value;
    }
}
