package MaximumTripletI;

//https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/submissions/1594164315/?envType=daily-question&envId=2025-04-02
//force long becaus eit go out of bound
class MaximumTripletISolution {
    public long maximumTripletValue(int[] nums) {
        long ans=0L;
        int n=nums.length;
        int i=nums[0];

        for(int j=1 ; j<n;j++){
            if(i<nums[j]){
                i=nums[j];
            }
                for(int k=j+1;k<n;k++){

                    ans=Math.max(ans,(long)(i-nums[j])*nums[k]);
                    }
                }
        return ans;
    }
}
public class MaximumTripletI {
    public static void main(String args[]){
        MaximumTripletISolution maximumTripletISolution=new MaximumTripletISolution();
    System.out.println(maximumTripletISolution.maximumTripletValue(new int[]{1000000,1,1000000}));
    }
}
