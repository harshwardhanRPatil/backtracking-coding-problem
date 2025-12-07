package Dynamic_Programming;

import java.util.Arrays;

// https://leetcode.com/problems/solving-questions-with-brainpower/submissions/1593276202/?envType=daily-question&envId=2025-04-01
class SolvingQuestionsBrainpowerSolution {

    public long mostPoints(int[][] questions) {
        long[] dp=new long[questions.length];
        Arrays.fill(dp,-1);
        return solve(questions,0,questions.length,dp);
    }
    public long solve(int[][] questions,int position,int end,long[] dp ){
        if(position>=end){
            return 0;
        }
        if(dp[position]!=-1){
            return dp[position];
        }

        dp[position]=Math.max(solve(questions,position+1,end,dp),questions[position][0]+solve(questions,position+questions[position][1]+1,end,dp));
        return dp[position];
    }
}
public class SolvingQuestionsBrainpower {
    public static void main(String args[]){
        SolvingQuestionsBrainpowerSolution solvingQuestionsBrainpowerSolution=new SolvingQuestionsBrainpowerSolution();
    System.out.println(solvingQuestionsBrainpowerSolution.mostPoints(new int[][]{{3,2},{4,3},{4,4},{2,5}}));
    }
}
