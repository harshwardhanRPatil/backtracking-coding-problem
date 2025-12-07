package Binary_Search;

import java.util.Arrays;
//https://leetcode.com/problems/split-array-largest-sum/

class SplitArraylargeSolution {
    public int splitArray(int[] nums, int k) {

        int low= Arrays.stream(nums).max().getAsInt();
        int high=Arrays.stream(nums).sum();

        while (low<=high){
            int mid= low+(high-low)/2;
            int peopleGot=countStudent(nums,mid);
            if(peopleGot>k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }

    public int countStudent(int[] nums, int page){
        int student =1;
        long pagestudent=0;

        for (int i =0;i<nums.length;i++){
            if(pagestudent+nums[i]<=page){
                pagestudent+=nums[i];
            }else{
                pagestudent=nums[i];
                student++;
            }
        }
        return student;
    }
}
public class SplitArraylarge {

    public static void main(String args[]){
        SplitArraylargeSolution splitArraylargeSolution=new SplitArraylargeSolution();
    System.out.println(splitArraylargeSolution.splitArray(new int[]{7,2,5,10,8},2));
    }
}
