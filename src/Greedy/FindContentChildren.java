package Greedy;

// https://leetcode.com/problems/assign-cookies
import java.lang.reflect.Array;
import java.util.Arrays;

class FindContentChildrenSolution {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int child = 0;
    int cookie = 0;

    while (child < g.length && cookie < s.length) {
      if (s[cookie] >= g[child]) child++;
      cookie++;
    }
    return child;
  }
}

public class FindContentChildren {
  public static void main(String args[]) {
    FindContentChildrenSolution findContentChildrenSolution = new FindContentChildrenSolution();
    System.out.println(
        findContentChildrenSolution.findContentChildren(new int[] {1, 2, 3}, new int[] {1, 1}));
  }
}
