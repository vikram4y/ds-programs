package com.vikram.ds.programs.arrays.easy;

public class LongestSubArrayWithSumKPositivesOnly {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,1,1,4,2,3};
        int k = 3;
        //int longest = longestSubArrayLengthWithSumKBruteForce(arr, k);
        //int longest = longestSubArrayLengthWithSumKBetter(arr, k);
        int longest = longestSubArrayLengthWithSumKOptimal(arr, k);
        System.out.println("Longest = "+longest);
    }

    //Optimal
    private static int longestSubArrayLengthWithSumKOptimal(int[] arr, int k) {
        int left = 0;  // Left pointer of the sliding window
        int sum = 0;   // Sum of the current window
        int maxLength = 0;

        // Traverse with right pointer
        for (int right = 0; right < arr.length; right++) {
            // Add the current element to the window's sum
            sum += arr[right];

            // If the sum exceeds k, shrink the window from the left
            while (sum > k && left <= right) {
                sum -= arr[left];
                left++;
            }

            // If the sum equals k, update the maximum length
            if (sum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }

    //Better O(n^2)
    private static int longestSubArrayLengthWithSumKBetter(int[] arr, int k) {
        int maxLength = 0;
        int sum = 0;

        // Fix: j should start from i
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k)
                    maxLength = Math.max(j-i+1, maxLength);

            }
        }

        return maxLength;
    }

    //Brute Force O(n^3)
    private static int longestSubArrayLengthWithSumKBruteForce(int[] arr, int k) {
        int maxLength = 0;
        int sum = 0;

        // Fix: j should start from i
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                for (int x = i; x <= j; x++) {
                    sum += arr[x];
                }
                if (sum == k) {
                    maxLength = Math.max(j-i+1, maxLength);
                }
            }
        }

        return maxLength;
    }
}
