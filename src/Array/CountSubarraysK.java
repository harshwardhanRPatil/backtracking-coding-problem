package Array;

// https://leetcode.com/problems/count-subarrays-with-score-less-than-k/submissions/1620408484/?envType=daily-question&envId=2025-04-28
// space -> O(N)
// Time -> O(1)

class CountSubarraysKSolution {
  public long countSubarrays(int[] nums, long k) {
    long ans = 0;

    int start = 0;
    long product = 0;
    for (int i = 0; i < nums.length; i++) {

      product += nums[i];
      while (start < i && product * (i - start + 1) >= k) {

        product -= nums[start];
        start++;
      }
      ans += i - start + 1;
    }
    return ans;
  }
}

public class CountSubarraysK {
  public static void main(String args[]) {}
}
