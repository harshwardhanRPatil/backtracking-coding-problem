package MergeSort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//
class NonOverlappingIntervalsSolution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> Integer.compare(a[1],b[1]));
        int ans=0;
        int[] newInterval =intervals[0];
        for(int i=1;i<intervals.length;i++) {
            if (newInterval[1] <= intervals[i][0]) {
                newInterval = intervals[i];
            }  else {

                ans++;
            }
        }

        return ans;
    }

}

public class NonOverlappingIntervals {
    public static void main(String args[]){
        NonOverlappingIntervalsSolution nonOverlappingIntervalsSolution=new NonOverlappingIntervalsSolution();
    System.out.println(nonOverlappingIntervalsSolution.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
    }
}
