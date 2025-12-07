package DailyQue;


import java.util.*;

// https://leetcode.com/problems/maximum-total-damage-with-spell-casting/description/?envType=daily-question&envId=2025-10-11
//O(Nlogn)

class MaximumTotalDamageSolution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> map = new HashMap<>();
        for (int x : power) map.put(x, map.getOrDefault(x, 0L) + x);

        List<long[]> arr = new ArrayList<>();
        for (var e : map.entrySet()) arr.add(new long[]{e.getKey(), e.getValue()});
        arr.sort(Comparator.comparingLong(a -> a[0]));

        return solve(arr, 0);
    }
    long solve(List<long[]> arr, int i) {
        int n = arr.size();
        if (i >= n) return 0;

        long notTake = solve(arr, i + 1);
        long take = arr.get(i)[1];
        int j = i + 1;
        while (j < n && arr.get(j)[0] - arr.get(i)[0] <= 2) j++;
        take += solve(arr, j);

        return Math.max(take, notTake);
    }

    // this will solve the que in using DP
//    class Solution {
//        public long maximumTotalDamage(int[] power) {
//            Map<Integer, Long> map = new HashMap<>();
//            // take help from the soltution part for this part to skip the repeative part
//            for (int x : power) map.put(x, map.getOrDefault(x, 0L) + x);
//
//            List<long[]> arr = new ArrayList<>();
//            for (var e : map.entrySet()) arr.add(new long[]{e.getKey(), e.getValue()});
//            // Step 3: Create dp array initialized to -1
//            // copy froim solution as we try recusion and it not pass few test case
//            long[] dp = new long[arr.size()];
//            Arrays.fill(dp, -1);
//            arr.sort(Comparator.comparingLong(a -> a[0]));
//
//            return solve(arr, 0, dp);
//        }
//        long solve(List<long[]> arr, int i, long[] dp) {
//
//            int n = arr.size();
//            if (i >= n) return 0;
//            if(dp[i]!=-1) return dp[i];
//
//            long notTake = solve(arr, i + 1,dp);
//            long take = arr.get(i)[1];
//            int j = i + 1;
//            while (j < n && arr.get(j)[0] - arr.get(i)[0] <= 2){
//                // as we have to skip the part for not take 2 value and not check -2 as we are alreday take them
//                j++;
//            }
//            take += solve(arr, j,dp);
//
//            return dp[i]= Math.max(take, notTake);
//        }
//    }
}
class MaximumTotalDamage {
    public static void main(String args[]){

        MaximumTotalDamageSolution maximumTotalDamageSolution= new MaximumTotalDamageSolution();
    System.out.println(maximumTotalDamageSolution.maximumTotalDamage(new int[]{1,1,3,4}));
    }
}
