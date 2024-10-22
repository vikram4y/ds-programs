package com.vikram.ds.programs.greedy;

public class JumpGame1 {
    public static void main(String[] args) {
        JumpGame1 jumpGame1 = new JumpGame1();
        int[] arr = {2,3,1,0,4};
        int[] arr2 = {3,2,1,0,4};
        System.out.println("Able to Reach = "+jumpGame1.canReachFinal(arr));
        System.out.println("Able to Reach = "+jumpGame1.canReachFinal(arr2));
    }

    private boolean canReachFinal(int[] arr) {
        int maxIndexReached = 0;
        for (int i=0;i<arr.length;i++) {
            if (maxIndexReached >= arr.length-1)
                return true;
            if (maxIndexReached < i)
                return false;
            int currentMax = i+arr[i];
            maxIndexReached = Math.max(currentMax, maxIndexReached);
        }
        return false;
    }
}
