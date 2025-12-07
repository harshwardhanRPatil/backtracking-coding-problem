package Binary_Search;

// https://leetcode.com/problems/find-peak-element/
class FindPeakElementSolution {
    public int findPeakElement(int[] nums) {

        int low=0;
        int high=nums.length-1;
        while (low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=nums[mid+1]){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return high;
    }
}
public class FindPeakElement {
    public static void main(String args){
FindPeakElementSolution findPeakElementSolution = new FindPeakElementSolution();
    System.out.println(findPeakElementSolution.findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
