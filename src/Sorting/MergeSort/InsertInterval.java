package Sorting.MergeSort;


import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/insert-interval/
class InsertIntervalSolution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {
            if (newInterval[1] < interval[0]) {
                res.add(newInterval);
                newInterval = interval;
            } else if (newInterval[0] > interval[1]) {
                res.add(interval);
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[+1] = Math.max(newInterval[1], interval[1]);
            }
        }

        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}
public class InsertInterval {
    public static void main(String args[]){
        InsertIntervalSolution insertIntervalSolution=new InsertIntervalSolution();
                System.out.println(insertIntervalSolution.insert(new int[][]{{1,5},{6,9}},new int[]{2,3}));
    }
}
