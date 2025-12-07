package DailyQue;

import java.lang.reflect.Array;
import java.util.Arrays;

class SuccessfulPairsSolution {
  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    Arrays.sort(potions);
    int n = potions.length;
    int m = spells.length;
    int[] ans = new int[m];

    for (int i = 0; i < m; i++) {
      int left = 0;
      int right = n - 1;

      while (left <= right) {
        int mid = left + (right - left) / 2;
        // need long as it have a 10power10
        long prod = (long) spells[i] * potions[mid];
        if (prod >= success) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      ans[i] = n - left;
    }
    return ans;
  }
}

public record SuccessfulPairs() {
  public static void main(String args[]) {
    SuccessfulPairsSolution successfulPairsSolution = new SuccessfulPairsSolution();
    System.out.println(
        successfulPairsSolution.successfulPairs(new int[] {5, 1, 3}, new int[] {1, 2, 3, 4, 5}, 7));
  }
}
