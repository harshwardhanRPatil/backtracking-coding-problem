package Binary_Search;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/?envType=problem-list-v2&envId=binary-search
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/?envType=problem-list-v2&envId=binary-search

//use same code for both problem
class FindMiniRotatedSortedArraySolution {
    public int findMin(int[] nums) {
        int low= 0;
        int high= nums.length-1;
        while(low<high){
            int mid = low + (high - low)/2;
            if(nums[mid]<nums[high]){
                high=mid;
            } else if (nums[mid]> nums[high]){
                low = mid +1;
            }else{
                high--;
            }
        }
        return nums[low];
    }
}
public class FindMiniRotatedSortedArray {
    public static void main(String args){
     FindMiniRotatedSortedArraySolution findMiniRotatedSortedArraySolution=new FindMiniRotatedSortedArraySolution();
    System.out.println(findMiniRotatedSortedArraySolution.findMin(new int[]{2,2,2,0,1}));
    }
}
