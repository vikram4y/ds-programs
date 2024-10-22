package com.vikram.ds.programs.greedy;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        AssignCookies assignCookies = new AssignCookies();
        int[] g = {1,5,3,3,4};
        int[] s = {4,2,1,2,1,3};
        System.out.println("Maximum Satisfied = "+assignCookies.findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gSize = g.length;
        int sSize = s.length;
        int gIndex = 0;
        int sIndex = 0;
        while (sIndex < sSize && gIndex < gSize) {
            if (g[gIndex] <= s[sIndex]) {
                gIndex++;
            }
            sIndex++;
        }
        return gIndex;
    }
}
