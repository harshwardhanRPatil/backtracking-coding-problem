package Sorting.MergeSort;

import java.util.Arrays;

// https://leetcode.com/problems/count-days-without-meetings/?envType=daily-question&envId=2025-03-24
class CountDaysWithoutMeetingsSolution {
    public int countDays(int days, int[][] meetings) {

        Arrays.stream(meetings).sorted();
        System.out.println(meetings.toString());
        int prev_end=0;

        for (int i =0 ;i<meetings.length;i++){
            int start= Math.max(meetings[i][0],prev_end+1);
            int end =meetings[i][1]-start+1;
            days-= Math.max(end,0);
            prev_end=Math.max(prev_end,end);
        }
        return days;
    }
}
public class CountDaysWithoutMeetings {
    public static void main(String args[]){
        CountDaysWithoutMeetingsSolution countDaysWithoutMeetingsSolution=new CountDaysWithoutMeetingsSolution();
    System.out.println(countDaysWithoutMeetingsSolution.countDays(5,new int[][]{{5,7},{1,3},{9,10}}));
    }
}
