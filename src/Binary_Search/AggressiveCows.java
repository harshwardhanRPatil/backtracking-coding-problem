package Binary_Search;

import java.lang.reflect.Array;
import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/aggressive-cows/1
class AggressiveCowsSolution {
  public int aggressiveCows(int[] stalls, int k) {
    // code here

    Arrays.sort(stalls);
    int min_val = 1;
    int n = stalls.length - 1;
    int max_val = stalls[n] - stalls[0];
    int max_differ = 1;
    while (min_val < max_val) {

      int mid = min_val + (max_val - min_val) / 2;

      if (aggressiveCowsDiff(stalls, mid, n, k)) {
        max_differ = mid;
        min_val = mid + 1;
      } else {
        max_val = mid - 1;
      }
    }
    return max_differ;
  }

  public boolean aggressiveCowsDiff(int[] stalls, int min_dis, int size, int cow) {
    int cow_put = 1;
    int next = stalls[0];
    int start = 0;
    for (int i = 1; i < size; i++) {
      if (stalls[i] - next >= min_dis) {
        cow_put++;
        next = stalls[i];
      }
      if (cow_put >= cow) {
        return true;
      }
    }
    return false;
  }
}

public class AggressiveCows {
  public static void main(String args[]) {

    AggressiveCowsSolution aggressiveCowsSolution = new AggressiveCowsSolution();
    System.out.println(aggressiveCowsSolution.aggressiveCows(new int[] {1, 2, 4, 8, 9}, 3));
  }
}
