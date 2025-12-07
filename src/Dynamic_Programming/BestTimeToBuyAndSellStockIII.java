package Dynamic_Programming;

import java.util.Arrays;

class BestTimeToBuyAndSellStockIIISolution {
  public int maxProfit(int[] prices) {
      int[][][] dp=new int[prices.length][2][5];
      for(int[][] t:dp)
      {
          for(int[] c:t)
          {
              Arrays.fill(c,-1);
          }
      }
    return profitFinder(prices, 4, 0, 1,dp);
  }

  public int profitFinder(int[] prices, int k, int position, int buy_flg,int[][][] dp) {
    if (k == 0) {
      return 0;
    }
    if (prices.length == position) {
      return 0;
    }
      if(dp[position][buy_flg][k]!=-1)
          return dp[position][buy_flg][k];
      int sum=0;
    if (buy_flg==1) {
      sum =
          Math.max(
                  -prices[position]+profitFinder(prices, k, position + 1, 0,dp),
              profitFinder(prices, k, position + 1, 1,dp));
    } else {
      if (sum + prices[position] > 0) {
        sum =
            Math.max(
                    prices[position]+profitFinder(prices, k - 1, position + 1, 1,dp),
                profitFinder(prices, k, position + 1, 0,dp));
      }
    }
      dp[position][buy_flg][k]=sum;
    return dp[position][buy_flg][k];
  }
}

public class BestTimeToBuyAndSellStockIII {
  public static void main(String args[]) {
    BestTimeToBuyAndSellStockIIISolution bestTimeToBuyAndSellStockIIISolution =
        new BestTimeToBuyAndSellStockIIISolution();
    System.out.println(bestTimeToBuyAndSellStockIIISolution.maxProfit(new int[] {1,2,4,2,5,7,2,4,9,0}));
  }
}
