package Dynamic_Programming;

import javax.xml.crypto.dsig.keyinfo.KeyName;
import java.util.HashMap;
import java.util.Map;


class HouseRobberIVSolution {
  Map<String, Integer> cachedata = new HashMap<>();

  public int minCapability(int[] nums, int k) {
    return solve(0, k, nums);
  }

  public int solve(int i, int k, int[] num) {
      if (i >= num.length) {
          return (k == 0) ? 0 : Integer.MAX_VALUE; // Fixing incorrect return
      }
    String key = i + "," + k;
    if (cachedata.containsKey(key)) {
      return cachedata.get(key);
    }
    int res1 = Math.max(num[i], solve(i + 2, k - 1, num));
    int res2 = solve(i + 1, k, num);
    int res = Math.min(res2, res1);
      cachedata.put(key,res);
    return res;
  }
}

public class HouseRobberIV {
  public static void main(String args[]) {
    HouseRobberIVSolution houseRobberIVSolution = new HouseRobberIVSolution();
    System.out.println(houseRobberIVSolution.minCapability(new int[] {2,7,9,3,1}, 2));
  }
}
