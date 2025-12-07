package Array.SlidingWindow;

// https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/?envType=daily-question&envId=2025-03-08
class MinimumRecolorsKSolution {
  public int minimumRecolors(String blocks, int k) {
    int total = k;

    for (int i = 0; i <= blocks.length() - k; i++) {
      int temp_ans = 0;
      System.out.println("value of i ins :" + i + "end is :" + (blocks.length()));
      for (int j = i; j < k+i; j++) {
        if (blocks.charAt(j) == 'W') {
          temp_ans += 1;
        }
      }
      total = Math.min(total, temp_ans);
    }

    return total;
  }
}

public class MinimumRecolorsK {

  public static void main(String args[]) {
    MinimumRecolorsKSolution minimumRecolorsKSolution = new MinimumRecolorsKSolution();
    System.out.println(minimumRecolorsKSolution.minimumRecolors("BWWWBB", 6));
  }
}
