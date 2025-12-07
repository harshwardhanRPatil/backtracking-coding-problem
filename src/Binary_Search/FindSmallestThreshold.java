package Binary_Search;


class FindSmallestThresholdSolution {
    public int smallestDivisor(int[] nums, int threshold) {
        int size = nums.length;
        // uppdate that i see from chatgpt
        int low = 1, high = Integer.MIN_VALUE;
        for (int day : nums) {
            high = Math.max(high, day);
        }
    System.out.println("high and low "+low+"::"+high);
        int ans=Integer.MAX_VALUE;
        while (low<=high){

            int mid=low+(high-low)/2;
      System.out.println("value of mid is "+mid);

            if(thresholdchecker(nums,size,mid,threshold)){
                ans=Math.min(ans,mid);
                low=mid+1;
            }
            else{
                low=mid+1;
            }
        }

        return ans;
    }

    public boolean thresholdchecker(int[] nums,int size ,int threshold,int k){
        int sum=0;
        for(int i=0;i<size;i++){
            //(c / divisor) in integer division truncates down.
//            Adding (divisor - 1) before dividing ensures the result rounds up instead of down.
            sum+=(nums[i]+threshold-1)/threshold;
        }
    System.out.println("value of sum is "+sum);
        if(sum<=k){
            return true;
        }
        return false;
    }
}
public class FindSmallestThreshold {
    public static void main(String args[]){
  FindSmallestThresholdSolution findSmallestThreshold=new FindSmallestThresholdSolution();
    System.out.println(findSmallestThreshold.smallestDivisor(new int[]{1,2,5,9},6));
    }
}
