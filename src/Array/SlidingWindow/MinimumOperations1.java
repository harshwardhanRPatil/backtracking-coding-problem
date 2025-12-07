package Array.SlidingWindow;

// https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/?envType=daily-question&envId=2025-03-19

class MinimumOperations1Solution {
  public int minOperations(int[] nums) {
    int left = 0;
    int count = 0;
    while (left <= nums.length - 3) {
      if (nums[left] == 0) {
        nums[left] = (nums[left] % 2 == 0) ? 1 : 0;
        nums[left + 1] = (nums[left + 1] % 2 == 0) ? 1 : 0;
        nums[left + 2] = (nums[left + 2] % 2 == 0) ? 1 : 0;
//// optimal way is copy from leet code
//          nums[left] ^= 1;
//          nums[left + 1] ^= 1;
//          nums[left + 2] ^= 1;
        count++;
      }
      left++;
    }
    for (int i : nums) {
      if (i == 0) {
        return -1;
      }
    }
    return count;
  }
}

public class MinimumOperations1 {
  public void main(String args[]) {
    MinimumOperations1Solution minimumOperations1Solution = new MinimumOperations1Solution();
    System.out.println(minimumOperations1Solution.minOperations(new int[] {0, 1, 1, 1, 0, 0}));
  }
}
