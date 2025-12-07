package Dynamic_Programming;


import java.util.Arrays;

class PartitionEqualSubsetSumSolution {
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        long sum=Arrays.stream(nums).sum();


        if(sum%2==1){
            return false;
        }
        long target=sum/2;
        dp = new Boolean[nums.length + 1][(int) (target+ 1)];
        return solve(nums,0,nums.length,target);
    }
    public boolean solve(int[] nums, int position, int end,long target){
        if(target==0){
            return true;
        }
        if(position>=end || target<0){
            return false;
        }
        if(dp[position][(int) target]!=null) return dp[position][(int) target];
        dp[position][(int) target]=solve(nums,position+1,end,target-nums[position]) || solve(nums,position+1,end,target);
        return dp[position][(int) target];
    }
}
public class PartitionEqualSubsetSum {
    public static void main(String args[]){
        PartitionEqualSubsetSumSolution partitionEqualSubsetSumSolution=new PartitionEqualSubsetSumSolution();
    System.out.println(partitionEqualSubsetSumSolution.canPartition(new int[]{1,5,11,5}));
    }
}
