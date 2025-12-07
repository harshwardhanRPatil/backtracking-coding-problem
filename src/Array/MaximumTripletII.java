package Array;


import java.util.Arrays;

class MaximumTripletISolutionII {
    public long maximumTripletValue(int[] nums) {
        long ans=0L;
        int n=nums.length;
        int i=nums[0];
        long[] prefix=new long[n];
        prefix[0]=nums[0];

        for(int j=1 ; j<n;j++){
            if(i<nums[j]){
                i=nums[j];
            }
            prefix[j]=(long)(i-nums[j]);
        }
        for (long num : prefix) {
            System.out.print(num+" ");
        }
        int postfix=nums[n-1];
        for(int j=n-2;j>0;j--){

            ans=Math.max(ans,(long)prefix[j]*postfix);
            if(postfix<nums[j]){
                postfix=nums[j];
            }
        }
//        System.out.println(prefix.toString());
        return ans;
    }
}
public class MaximumTripletII {
    public static void main(String args[]){
        MaximumTripletISolutionII maximumTripletISolutionII=new MaximumTripletISolutionII();
    System.out.println(maximumTripletISolutionII.maximumTripletValue(new int[]{10,13,6,2}));
    }
}
