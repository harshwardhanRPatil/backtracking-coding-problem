package BackTracking;

import java.util.ArrayList;
import java.util.*;

class PermutationsSolutionII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        Set<Set<Integer>> tempans= new HashSet<>();
        solve(nums,0,temp,ans);
        Set<List<Integer>> uniqueSet = new LinkedHashSet<>(ans);
        List<List<Integer>> uniqueList = new ArrayList<>(uniqueSet);

        return uniqueList;
    }

  public void solve(int[] nums, int start, List<Integer> temp, List<List<Integer>> ans) {

    if (nums.length == start) {
//      System.out.println(temp.toString());
      ans.add(new ArrayList<>(temp));

      return;
    }

    for (int i = start; i < nums.length; i++) {
      temp.add(nums[i]);
      swap(nums, start, i);
      solve(nums, start + 1, temp, ans);
      swap(nums, i, start);
      temp.remove(temp.size() - 1);
    }
  }

  public void swap(int[] str, int i, int j) {
    if (i < 0 || j < 0 || i >= str.length || j >= str.length) {
      throw new IllegalArgumentException("Invalid indices");
    }

    int temp = str[i];
    str[i] = str[j];
    str[j] = temp;
  }
}

public class PermutationsII {

  public static void main(String args[]) {
    PermutationsSolutionII solution = new PermutationsSolutionII();
    System.out.println(solution.permuteUnique(new int[] {1, 1, 3}));
  }
}
