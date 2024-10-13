package com.vikram.ds.programs.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumKPositivesAndNegatives {
    public static void main(String[] args) {
        int[] a = {3,4,7,8,4,6,-1,-1,9};
        int k = 4;
        int len = getLongestSubarray(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }

    private static int getLongestSubarray(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;  // Initialize to 0 to handle cases where no valid subarray is found

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum equals k, then the whole array from 0 to i is the subarray
            if (sum == k) {
                maxLength = i + 1;
            }

            // If (sum - k) is found in the map, we have a subarray sum equal to k
            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }

            // Only insert the sum into the map if it's not already present
            // This ensures that we get the longest subarray
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}
