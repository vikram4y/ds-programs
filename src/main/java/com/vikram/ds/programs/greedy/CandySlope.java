package com.vikram.ds.programs.greedy;

public class CandySlope {
    public static void main(String[] args) {
        CandySlope candySlope = new CandySlope();
        int[] ratings = {1,0,2};
        int[] ratings2 = {0,2,4,7,6,5,4,3,2,1,1,1,2,3,4,2,1,1,1};
        System.out.println("Minimum candies = "+candySlope.candyWithSlopeSolution(ratings2));
    }

    private int candyWithSlopeSolution(int[] ratings) {
        int sum = 1;
        int i = 1;
        int n = ratings.length;
        while (i < n) {
            //flat
            if (ratings[i] == ratings[i-1]) {
                sum = sum+1;
                i++;
                continue;
            }
            //increasing
            int peak = 1;
            while(i < n && ratings[i] > ratings[i-1]) {
                peak++;
                sum = sum+peak;
                i++;
            }
            //decrease
            int down = 1;
            while (i < n && ratings[i] < ratings[i-1]) {
                sum = sum+down;
                down++;
                i++;
            }
            if (down > peak) {
                sum = sum-peak+down;
            }
        }
        return sum;
    }


    private int candy(int[] ratings) {
        if (ratings.length == 0)
            return 0;
        if (ratings.length == 1)
            return 1;
        int[] left = new int[ratings.length];
        left[0] = 1;
        for (int i=1;i< ratings.length; i++) {
            if (ratings[i] > ratings[i-1])
                left[i] = left[i-1]+1;
            else {
                left[i] = 1;
            }
        }
        int currentCandy = 1;
        //unnecessary
        //left[ratings.length-1] = Math.max(currentCandy, left[ratings.length-1]);
        int sum = left[ratings.length-1];
        for (int i=ratings.length-2;i>=0; i--) {
            if (ratings[i] > ratings[i+1])
                currentCandy = currentCandy+1;
            else {
                currentCandy = 1;
            }
            left[i] = Math.max(currentCandy, left[i]);
            sum += left[i];
        }
        return sum;
    }
}
