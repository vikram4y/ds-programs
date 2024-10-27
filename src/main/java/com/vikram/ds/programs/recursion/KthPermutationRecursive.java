package com.vikram.ds.programs.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthPermutationRecursive {
    public static void main(String[] args) {
        int n = 4;
        int k = 17;
        KthPermutationRecursive perm = new KthPermutationRecursive();
        System.out.println(perm.kthPerm(n,k));
    }

    //With Recursion
    public String kthPerm(int n, int k) {
        int[] arr = new int[n];
        for(int i = 0;i<n;i++) {
            arr[i] = i+1;
        }
        List<String> list = new ArrayList<>();
        getPerm(0, arr, "", list);
        Collections.sort(list);
        //System.out.println(list);
        //return null;
        return list.get(k-1);
    }

    private void getPerm(int index, int[] arr, String s, List<String> list) {
        if (index == arr.length) {
            list.add(s);
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            s = s+arr[index];
            getPerm(index+1, arr,s, list);
            s = s.substring(0,s.length()-1);
            swap(arr, i, index);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
