package Binary_Search;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

// Note when we have a min in max  or max in a min then try to find a BS in that que
class MinimumBouquetsSolution {
  public int minDays(int[] bloomDay, int m, int k) {

    //    int low = Arrays.stream(bloomDay).min().getAsInt();
    //    int high = Arrays.stream(bloomDay).max().getAsInt();

    int size = bloomDay.length;
    // uppdate that i see from chatgpt
    if ((long) m * k > size) return -1;
    int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
    for (int day : bloomDay) {
      low = Math.min(low, day);
      high = Math.max(high, day);
    }
    int ans = 0;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (counterFolwer(bloomDay, k, m, size, mid)) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return ans;
  }

  public boolean counterFolwer(int[] bloomDay, int size, int count, int n, int min_day) {
    int flower = 0;
    int counter_flower = 0;
    for (int i = 0; i < n; i++) {
      if (bloomDay[i] <= min_day) {
        counter_flower++;
        if (counter_flower == size) {
          flower++;
          counter_flower = 0;
          if (flower == count) return true;  // early exit
        }
      } else {
        counter_flower = 0;
      }
    }
    return false;
  }
}

public class MinimumBouquets {
  public static void main(String args[]) {
    MinimumBouquetsSolution minimumBouquetsSolution = new MinimumBouquetsSolution();
    //    System.out.println(minimumBouquetsSolution.minDays(new int[]{1,10,3,10,2},3,2));
    System.out.println(minimumBouquetsSolution.minDays(new int[] {7, 7, 7, 7, 12, 7, 7}, 2, 3));
  }
}
