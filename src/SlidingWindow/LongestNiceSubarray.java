package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/longest-nice-subarray/description/
class LongestNiceSubarraySolution {
    public int longestNiceSubarray(int[] nums) {
        int left=0;
        int right=1;
        List<Integer> holder=new ArrayList<>();
        int n =nums.length;
        int ans=1;
        holder.add(nums[0]);
        while (right<n){
            if((nums[left]&nums[right])==0){
                int temp=left;
                while (temp<right){
                    if((nums[temp]&nums[right])==0){
                        temp++;
                    }
                    else{
                        left++;
                        temp++;
                    }
                }
                ans=Math.max(ans,right-left+1);
        System.out.println("ans for the index :: right and left is :: "+ right + "::"+ left +" =>"+ans);
            }else{

                left=right;
            }
            right++;
        }
        return ans;
    }

//    correct oproch
//public int longestNiceSubarray(int[] nums) {
//    int left = 0, bitMask = 0, maxLen = 0;
//
//    for (int right = 0; right < nums.length; right++) {
//        // If nums[right] has overlapping bits, shift left until it's valid
//        while ((bitMask & nums[right]) != 0) {
//            bitMask ^= nums[left]; // Remove leftmost element from bitmask
//            left++;  // Move the window
//        }
//
//        // Include nums[right] in the bitmask
//        bitMask |= nums[right];
//
//        // Update max length
//        maxLen = Math.max(maxLen, right - left + 1);
//    }
//    return maxLen;
//}
}

public class LongestNiceSubarray {
    public static void main(String args[]){
     LongestNiceSubarraySolution longestNiceSubarraySolution=new LongestNiceSubarraySolution();
    System.out.println(longestNiceSubarraySolution.longestNiceSubarray(new int[]{1,3,8,48,10}));
    }
}
