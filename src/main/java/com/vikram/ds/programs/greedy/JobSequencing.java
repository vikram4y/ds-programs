package com.vikram.ds.programs.greedy;

import java.util.ArrayList;
import java.util.List;

public class JobSequencing {
    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(2,80));
        jobs.add(new Job(2,10));
        jobs.add(new Job(2,22));
        jobs.add(new Job(4,25));
        jobs.add(new Job(4,20));
        jobs.add(new Job(5,60));
        jobs.add(new Job(6,65));
        jobs.add(new Job(6,70));
        int maxProfit = maximizeProfit(jobs);
        System.out.println("Maximum profit = "+maxProfit);
    }

    private static int maximizeProfit(List<Job> jobs) {
        jobs.sort((a, b) -> b.profit - a.profit);
        int maxDeadline = jobs.stream().mapToInt(j -> j.deadline).max().orElse(0);
        boolean [] performed = new boolean[maxDeadline];
        int maxProfit = 0;
        for (Job job : jobs) {
            int deadlineIndex = job.deadline - 1;
            while (deadlineIndex >= 0 && performed[deadlineIndex])
                deadlineIndex--;
            if (deadlineIndex >= 0) {
                performed[deadlineIndex] = true;
                maxProfit += job.profit;
            }
        }
        return maxProfit;
    }
}

class Job {
    public int deadline;
    public int profit;
    public Job(int deadline, int profit) {
        this.deadline = deadline;
        this.profit = profit;
    }
}
