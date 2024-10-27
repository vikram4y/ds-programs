package com.vikram.ds.programs.recursion;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationNonRecursive {
    public static void main(String[] args) {
        int n = 4;
        int k = 17;
        System.out.println("Result = "+getPermutation(n, k));
    }

    public static String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        k -= 1;

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        StringBuilder permutation = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int index = k / factorial[n - 1 - i];
            permutation.append(numbers.get(index));
            numbers.remove(index);
            k %= factorial[n - 1 - i];
        }
        return permutation.toString();
    }
}
