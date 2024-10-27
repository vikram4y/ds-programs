package com.vikram.ds.programs.recursion;

import java.util.Arrays;
import java.util.List;

public class AllPermutations {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        //List<Integer> list = new ArrayList<>();
        //boolean[] taken = new boolean[arr.length];
        //printAllPermutations(arr, list, taken);
        printAllPermBySwap(0, arr);
    }

    // 1. Using a boolean array
    private static void printAllPermutations
            (int[] arr, List<Integer> list, boolean[] taken) {
        if (list.size() == arr.length) {
            System.out.println(list);
            return;
        }
        for (int i = 0; i < arr.length ; i++) {
            if (taken[i])
                continue;
            taken[i] = true;
            list.add(arr[i]);
            printAllPermutations(arr, list, taken);
            list.remove(list.size()-1);
            taken[i] = false;
        }
    }


    // 2. Using swapping technique
    private static void printAllPermBySwap(int index, int[] arr) {
        if (index >= arr.length) {
            System.out.println(Arrays.toString(arr));
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            printAllPermBySwap(index+1, arr);
            swap(arr, index, i);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
