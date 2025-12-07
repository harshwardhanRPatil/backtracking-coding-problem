package BackTracking;

import java.util.*;

class CombinationSumIISolution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    Set<Set<Integer>> tempans = new HashSet<>();
//    sort for removing the dublicate
      Arrays.sort(candidates);
    solve(candidates, 0, temp, ans, target);
    Set<List<Integer>> uniqueSet = new LinkedHashSet<>(ans);
    List<List<Integer>> uniqueList = new ArrayList<>(uniqueSet);

    return uniqueList;
  }

  public void solve(
      int[] nums, int start, List<Integer> temp, List<List<Integer>> ans, int target) {

    if (target == 0) {
      ans.add(new ArrayList<>(temp));
      return;
    }
    if (nums.length == start) {
      return;
    }

    for (int i = start; i < nums.length; i++) {
      if (target - nums[i] >= 0) {
        temp.add(nums[i]);
        solve(nums, i + 1, temp, ans, target - nums[i]);
        temp.remove(temp.size() - 1);
      }
    }
  }
}

public class CombinationSumII {

  public static void main(String args[]) {
    CombinationSumIISolution combinationSumIISolution = new CombinationSumIISolution();
    System.out.println(
        combinationSumIISolution.combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
  }
}
