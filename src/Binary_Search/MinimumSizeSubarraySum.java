package Binary_Search;


// https://leetcode.com/problems/minimum-size-subarray-sum/

class MinimumSizeSubarraySumSolution {
  public int minSubArrayLen(int target, int[] nums) {
    int low = 1;
    int size = nums.length;
    int high = size;
    int ans = Integer.MAX_VALUE;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (counter(target, nums, size, mid)) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return ans;
  }

  public boolean counter(int target, int[] nums, int n, int bucet) {
      if (bucet > n) return false;
    int j = 0;
    int i = 0;
    int sum = 0;
    int mx = Integer.MIN_VALUE;
    while (j < n) {
      sum += nums[j];

      if (j - i + 1 == bucet) {
        mx = Math.max(sum, mx);
        sum -= nums[i];
        i++;
      }
      j++;
    }
    if (mx >= target) {
      return true;
    }
    return false;
  }
}

public class MinimumSizeSubarraySum {
  public static void main(String args[]) {
    MinimumSizeSubarraySumSolution minimumSizeSubarraySumSolution =
        new MinimumSizeSubarraySumSolution();
    System.out.println(
        minimumSizeSubarraySumSolution.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
  }
}
