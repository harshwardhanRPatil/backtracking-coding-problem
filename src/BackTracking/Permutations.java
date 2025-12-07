package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PermutationsSolution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
      List<Integer> temp=new ArrayList<>();
    solve(nums,0,temp,ans);
    return ans;
  }

  public void solve(int[] nums, int start, List<Integer> temp, List<List<Integer>> ans) {

    if (nums.length == start) {
      System.out.println(temp.toString());
      ans.add(new ArrayList<>(temp));
      return;
    }

    for (int i = start; i < nums.length; i++) {
        temp.add(nums[i]);
        swap(nums,start,i);
        solve(nums,start+1,temp,ans);
        swap(nums,i,start);
        temp.remove(temp.size()-1);
    }
  }

    public  void swap(int[] str, int i, int j) {
        if (i < 0 || j < 0 || i >= str.length || j >= str.length) {
            throw new IllegalArgumentException("Invalid indices");
        }


        int temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}

public class Permutations {

  public static void main(String args[]) {
    PermutationsSolution solution = new PermutationsSolution();
    System.out.println(solution.permute(new int[] {1, 2, 3}));
  }
}
