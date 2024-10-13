package com.vikram.ds.programs.arrays.medium;

public class MaximumSubArraySumKadane {
    public static void main(String[] args) {
        int arr[] = {5,-9,2,4,-6,-1,7,-2,3};
        int maximum = maximumSubArraySum(arr);
        System.out.println("Maximum Sum = "+maximum);
    }

    //Kadane's Algo
    private static int maximumSubArraySum(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++) {
            sum = Math.max(arr[i], sum+arr[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

}
