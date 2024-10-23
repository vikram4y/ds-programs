package com.vikram.ds.programs.greedy;

public class JumpGame2 {
    public static void main(String[] args) {
        JumpGame2 jumpGame2 = new JumpGame2();
        int[] arr = {2,3,1,4,1,1,1,2};
        //int minJums = jumpGame2.minJum(arr, 0, 0, Integer.MAX_VALUE);
        System.out.println("Minimum jumps = "+jumpGame2.minJumpGreedy(arr));
    }

    //Brute Force - n!
    private int minJum(int[] arr, int currentIndex, int jumpCount, int minJum) {
        if (currentIndex >= arr.length-1) {
            return jumpCount;
        }
        for (int i=1;i<=arr[currentIndex];i++) {
            int jumps = minJum(arr, currentIndex+i, jumpCount+1, minJum);
            minJum = Math.min(jumps, minJum);
        }
        return minJum;
    }

    //Greedy - n
    private int minJumpGreedy(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        int jumps = 0;
        int i = 0;
        while (i < arr.length - 1) {
            if (arr[i] == 0)
                return -1;
            int maxReach = i + arr[i];
            jumps++;
            if (maxReach >= arr.length - 1) {
                return jumps;
            }
            int indexJ = i;
            for (int j = 1; j <= arr[i]; j++) {
                if (i + j >= arr.length - 1) {
                    indexJ = j;
                    break;
                }
                if (i + j + arr[i + j] > maxReach) {
                    maxReach = i + j + arr[i + j];
                    indexJ = j;
                }
            }
            i += indexJ;
        }
        return jumps;
    }

}
