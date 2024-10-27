package com.vikram.ds.programs.recursion;

import java.util.ArrayList;

//Print all unique subsets
//To print all unique subsets, first we sort the input array, then process
public class Subset2 {
    public static void main(String[] args) {
        int[] arr = {1,1,2};
        printSubsets(0, arr, new ArrayList<>());
    }

    private static void printSubsets(int index, int[] arr, ArrayList<Integer> list) {
        System.out.println(list);
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            list.add(arr[i]);
            printSubsets(i + 1, arr, list);
            list.remove(list.size() - 1);
        }
    }
}
