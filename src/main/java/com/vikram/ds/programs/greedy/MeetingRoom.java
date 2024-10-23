package com.vikram.ds.programs.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingRoom {
    public static void main(String[] args) {
        int [] starts = {0,3,1,5,5,8};
        int [] ends = {5,4,2,9,7,9};
        MeetingRoom meetingRoom = new MeetingRoom();
        int maxMeetings = meetingRoom.getMaxMeetings(starts, ends);
        System.out.println("Max meetings = "+maxMeetings);
    }

    private int getMaxMeetings(int[] starts, int[] ends) {
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0;i<starts.length;i++)
            meetings.add(new Meeting(starts[i], ends[i]));
        Collections.sort(meetings, (a,b) -> a.end() - b.end());
        int total = 0;
        int endingAt = -1;
        for(Meeting meeting: meetings) {
            if (endingAt < meeting.start()) {
                total++;
                endingAt = meeting.end();
            }
        }
        return total;
    }

}

record Meeting(int start, int end) {}
