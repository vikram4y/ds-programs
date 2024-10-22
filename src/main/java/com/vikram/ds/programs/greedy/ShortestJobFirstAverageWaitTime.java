package com.vikram.ds.programs.greedy;

import java.util.Arrays;

public class ShortestJobFirstAverageWaitTime {
    public static void main(String[] args) {
        int[] p = {4,3,7,1,2};
        System.out.println("Average wait time: "+averageWaitTime(p));
    }

    public static double averageWaitTime(int[] p) {
        Arrays.sort(p);
        int elapsed = 0;
        int totalWaitTime = 0;
        for (int i=0;i<p.length;i++) {
            totalWaitTime += elapsed;
            elapsed += p[i];
        }
        return totalWaitTime/p.length;
    }
}
