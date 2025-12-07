package Binary_Search;

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
class ShipWithinDayspakageSolution {
  public int shipWithinDays(int[] weights, int days) {

    // no need for the sorting the array
    // we need to have a high as the min because we have the min weiht we can ship as 1 day but this will reduce the time comple
    //      int[] prefix = new int[n+1];
    //        for (int i = 0; i < n; i++) {
    //            prefix[i+1] = prefix[i] + weights[i];
    //        }
    //
    //        int low = Arrays.stream(weights).max().getAsInt();
    //        int high = prefix[n];
    //        int ans = high;
    int low = 0, high = 0;
    int size = weights.length;
    for (int w : weights) {
      low = Math.max(low, w);
      high += w;
    }
    int ans = -1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (shipcounter(weights, days, mid, size)) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return ans;
  }

  public boolean shipcounter(int[] weights, int days, int weight, int size) {

    int pakage_weight = 0;
    int day_done = 1;
    for (int i = 0; i < size; i++) {
      if (weights[i] > weight) {
        return false;
      }
      if (pakage_weight + weights[i] <= weight) {
        pakage_weight += weights[i];
      } else {
        if (pakage_weight <= weight) {
          day_done++;
        }
        pakage_weight = weights[i];
      }
    }
    if (day_done <= days) {
      return true;
    }
    return false;
  }
}

public class ShipWithinDayspakage {
  public static void main(String args[]) {
    ShipWithinDayspakageSolution shipWithinDayspakageSolution = new ShipWithinDayspakageSolution();
    //    System.out.println(shipWithinDayspakageSolution.shipWithinDays(new int[] {1, 2, 3, 4, 5,
    // 6, 7, 8, 9, 10}, 5));
    System.out.println(shipWithinDayspakageSolution.shipWithinDays(new int[] {1, 2, 3, 1, 1}, 4));
  }
}
