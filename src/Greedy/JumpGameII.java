package Greedy;

// https://leetcode.com/problems/jump-game-ii
// ⏱ Time: O(n)
// 💾 Space: O(1)
class JumpGameIISolution {
  public int jump(int[] nums) {

    int least = 0;
    int range = 0;
    int ans = 0;
    while(least<nums.length-1) {
      int temp = range;
      while (least < range + 1) {
        temp = Math.max(temp, nums[least] + least);
        least++;
      }
      least = range + 1;
      range = temp;
      ans++;
      if (range >= nums.length-1) {
        return ans;
      }
    }
    return ans;
  }
}

public class JumpGameII {
  public static void main(String args[]) {
    JumpGameIISolution jumpGameIISolution = new JumpGameIISolution();
    System.out.println(jumpGameIISolution.jump(new int[] {2, 3, 1, 1, 4}));
  }
}
