package MergeSort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//
class MergeIntervalsSolution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int[] newInterval =intervals[0];
        for(int i=1;i<intervals.length;i++) {
            if (newInterval[1] < intervals[i][0]) {
                res.add(newInterval);
                newInterval = intervals[i];
            } else if (newInterval[0] > intervals[i][1]) {
                res.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[+1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}
public class MergeIntervals {
    public static void main(String args[]){
        MergeIntervalsSolution mergeIntervalsSolution=new MergeIntervalsSolution();
    Arrays.stream(mergeIntervalsSolution.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})).forEach(row->Arrays.stream(row).forEach(System.out::println));
    }
}
