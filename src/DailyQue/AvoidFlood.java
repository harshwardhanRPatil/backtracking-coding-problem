package DailyQue;

// https://leetcode.com/problems/avoid-flood-in-the-city/?envType=daily-question&envId=2025-10-07

import java.util.*;

class AvoidFloodSolution {
  public int[] avoidFlood(int[] rains) {
      int n = rains.length;
      int[] ans = new int[n];

      TreeSet<Integer> dryDays = new TreeSet<>();
      Map<Integer, Integer> full = new HashMap<>();

    for (int i = 0; i < n; i++) {
      if (rains[i] == 0) {
          dryDays.add(i);
          ans[i] = 1; // default
      } else {
          int lake = rains[i];
          ans[i] = -1;
          if (full.containsKey(lake)) {
              // find the next dry day after last filled
              Integer dry = dryDays.higher(full.get(lake));
              if (dry == null) return new int[0]; // flood happens
              ans[dry] = lake;
              dryDays.remove(dry);
          }
          full.put(lake, i);

      }
//      Arrays.stream(ans).forEach(System.out::print);
//      System.out.println("::");
    }
    return ans;
  }
}

public class AvoidFlood {
  public static void main(String args[]) {
    AvoidFloodSolution avoidFloodSolution = new AvoidFloodSolution();
    System.out.println(avoidFloodSolution.avoidFlood(new int[] {1, 2, 0, 0, 2, 1}));
    System.out.println(avoidFloodSolution.avoidFlood(new int[] {1,2,0,1,2}));
  }
}
