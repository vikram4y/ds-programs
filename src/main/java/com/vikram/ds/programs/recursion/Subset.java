package com.vikram.ds.programs.recursion;

import java.util.ArrayList;

//Print all subsets
public class Subset {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        printSubsets(0, arr, new ArrayList<Integer>());
    }

    private static void printSubsets(int i, int[] arr, ArrayList<Integer> list) {
        if (i >= arr.length) {
            System.out.println(list);
            return;
        }
        list.add(arr[i]);
        printSubsets(i+1, arr, list);
        list.remove(list.size()-1);
        printSubsets(i+1, arr, list);
    }
}
