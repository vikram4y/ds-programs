package com.vikram.ds.programs.binarysearch.easy;

public class BinarySearchInArray {
    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4,5,6,7,8,9};
        int index = findElement(arr, 5);
        int indexR = findElement(arr, 0, arr.length-1, 5);
        System.out.println("Element fount at: "+index);
        System.out.println("Element fount (Recursive) at: "+indexR);
    }

    // Binary search recursive
    private static int findElement(int[] arr, int low, int high, int x) {
        if (low<=high) {
            int mid = low + (high-low) / 2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] > x) {
                return findElement(arr, low, mid-1, x);
            } else {
                return findElement(arr, mid+1, high, x);
            }
        }
        return -1;
    }

    //Binary Search
    private static int findElement(int[] arr, int x) {
        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] < x) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }


}
