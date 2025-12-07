package Dynamic_Programming;

import java.util.Arrays;
import java.util.SortedMap;

class BestTimeBuySellStockIVSolution {
    public int maxProfit(int k,int[] prices) {

        int[][][] dp=new int[prices.length][2][k+1];
        for(int[][] t:dp)
        {
            for(int[] c:t)
            {
                Arrays.fill(c,-1);
            }
        }
        return profitFinder(prices, k, 0,0, 1,dp);
    }

    public int profitFinder(int[] prices, int k, int position, int count,int buy_flg,int[][][] dp) {
        if (prices.length == position) {
            return 0;
        }
        if (k == count) {
            return 0;
        }

        if(dp[position][buy_flg][count]!=-1)
            return dp[position][buy_flg][count];
        int sum=0;
        if (buy_flg==1 && count<k ) {
            sum =
                    Math.max(
                            -prices[position]+profitFinder(prices, k, position + 1,count, 0,dp),
                            profitFinder(prices, k, position + 1,count, 1,dp));
        } else {

            sum =
                    Math.max(
                            prices[position]+profitFinder(prices, k, position + 1,count+1, 1,dp),
                            profitFinder(prices, k, position + 1,count, 0,dp));

        }
        dp[position][buy_flg][count]=sum;
        return dp[position][buy_flg][count];
    }
}

public class BestTimeBuySellStockIV {
    public static void main(String args []){
    BestTimeBuySellStockIVSolution bestTimeBuySellStockIVSolution =
        new BestTimeBuySellStockIVSolution();
    System.out.println(bestTimeBuySellStockIVSolution.maxProfit(2,new int[]{3,2,6,5,0,3}));
}
}
