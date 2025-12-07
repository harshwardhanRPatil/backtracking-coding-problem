package Array;

//https://leetcode.com/problems/count-the-number-of-fair-pairs/submissions/1611496282/?envType=daily-question&envId=2025-04-19

import java.util.Arrays;

class CountNumberPairSolution {
    public long countFairPairs(int[] nums, int lower, int upper) {

        Arrays.sort(nums);
        return lower_bound(nums, upper + 1) - lower_bound(nums, lower);
    }
    private long lower_bound(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        long result = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            // If sum is less than value, add the size of window to result and move to the
            // next index.
            if (sum < value) {
                result += (right - left);
                left++;
            } else {
                // Otherwise, shift the right pointer backwards, until we get a valid window.
                right--;
            }
        }
    System.out.println(result);

        return result;
    }
}

public class CountNumberPair {
    public static void main(String args[]){
        CountNumberPairSolution countNumberPairSolution=new CountNumberPairSolution();
        System.out.println(countNumberPairSolution.countFairPairs(new int[]{0,1,7,4,4,5},3,6));
    }
}
