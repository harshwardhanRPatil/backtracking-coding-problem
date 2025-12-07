package Binary_Search;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FourSumSolution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans=new ArrayList<>();
        int len = nums.length;

        Arrays.sort(nums);

        return  ans;
    }
}
//-2,-1,0,0,1,2
public class FourSum {
    public static void main(String args []){
        FourSumSolution fourSumSolution=new FourSumSolution();
    System.out.println(fourSumSolution.fourSum(new int[]{1,0,-1,0,-2,2},0));
    }
}
