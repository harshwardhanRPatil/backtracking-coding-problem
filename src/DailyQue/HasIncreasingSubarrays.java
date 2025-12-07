package DailyQue;

import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/?envType=daily-question&envId=2025-10-14
class HasIncreasingSubarraysSolution {
  public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
    int n = nums.size();
    HashSet<Integer> set =
        new HashSet<>(); // stores start indices of strictly increasing subarrays of length k
    int i = 0;

    while (i < n) {
      // Try to find an increasing subarray starting at index i
      int j = i + 1;
      int prev = nums.get(i);

      // Expand the window as long as elements are strictly increasing
      // and subarray length < k
      while (j < n && j - i < k && nums.get(j) > prev) {
        prev = nums.get(j);
        j++;
      }

      // If we found a strictly increasing subarray of size k
      if (j - i == k) {
        // Check if there’s another increasing subarray ending exactly k elements before this one
        // i.e., the subarrays are non-overlapping but adjacent
        // as we have store the index 0 and weh check for the 3 index it will do 3-3 and 0 so we
        // have that and we return true
        if (set.contains(i - k)) return true;

        // Store start index of this increasing subarray
        set.add(i);
        i=j;
      } else {
        i = j;
      }

      System.out.println("value of i is ::"+ i);
    }

    // If no two adjacent increasing subarrays of length k are found
    return false;
  }
}

public class HasIncreasingSubarrays {
  public static void main(String args[]) {
    HasIncreasingSubarraysSolution hasIncreasingSubarraysSolution =
        new HasIncreasingSubarraysSolution();
    System.out.println(
        hasIncreasingSubarraysSolution.hasIncreasingSubarrays(
            List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1), 3));
  }
}
