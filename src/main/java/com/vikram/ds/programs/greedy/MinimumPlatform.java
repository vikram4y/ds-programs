package com.vikram.ds.programs.greedy;

import java.util.Arrays;

public class MinimumPlatform {
    public static void main(String[] args) {
        MinimumPlatform minimumPlatform = new MinimumPlatform();
        int [] arrival = {900, 945, 955, 1100, 1500, 1800};
        int [] dep = {920, 1130, 1150, 1200, 1900, 2000};
        System.out.println("Minimum platform needed = "
                +minimumPlatform.getMinimumPlatform(arrival, dep));
    }

    private int getMinimumPlatform(int[] arrivals, int[] dep)  {
        Arrays.sort(arrivals);
        Arrays.sort(dep);
        int aPointer = 0;
        int dPointer = 0;
        int currentCount = 0;
        int maxCount = 0;
        while(aPointer < arrivals.length && dPointer < dep.length) {
            if (arrivals[aPointer] <= dep[dPointer]) {
                currentCount++;
                maxCount = Math.max(currentCount, maxCount);
                aPointer++;
            } else {
                currentCount--;
                dPointer++;
            }
        }
        return maxCount;
    }
}
