package BackTracking;

import java.util.ArrayList;
import java.util.List;

class PermutationSequenceSolution {
  public String getPermutation(int n, int k) {
    List<List<String>> ans = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    solve(n, temp, ans, k, new boolean[n + 1]);
    return String.join("", ans.get(k - 1));
  }

  public void solve(int start, List<String> temp, List<List<String>> ans, int k, boolean[] used) {
    if (temp.size() == start) {

      ans.add(new ArrayList<>(temp));
      return;
    }
    if (ans.size() == k) {
      return;
    }
    for (int i = 1; i < start + 1; i++) {
      if (used[i]) continue;
      used[i] = true;
      temp.add(String.valueOf(i));
      solve(start, temp, ans, k, used);
      temp.remove(temp.size() - 1);
      used[i] = false;
    }
  }
}

public class PermutationSequence {
  public static void main(String args[]) {
    PermutationSequenceSolution permutationsSolution = new PermutationSequenceSolution();
    System.out.println(permutationsSolution.getPermutation(9, 138270));
  }
}
