package Array;


// Time -> O(N)
// Space -> O(1)

//https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2025-04-29

import java.util.Arrays;
import java.util.OptionalInt;


// Approch from the right side have same affect
//class Solution {
//    public int countSubarrays(int[] nums, int k) {
//        int max = Arrays.stream(nums).max().getAsInt();
//        int count = 0, left = 0, maxFound = 0, n = nums.length;
//
//        for (int right = 0; right < n; right++) {
//            if (nums[right] == max) maxFound++;
//
//            while (maxFound == k) {
//                count += n - right;
//                if (nums[left] == max) maxFound--;
//                left++;
//            }
//        }
//
//        return count;
//    }
//}
class CountSubarraysMAXKSolution {
    public long countSubarrays(int[] nums, int k) {
        long ans=0;
        int max_value = Arrays.stream(nums).max().getAsInt();
        int counter=0;
        int start=0;
    System.out.println(max_value);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max_value){
                counter++;
            }
            int temp=0;
//            while (counter>=k){
//                temp=start+1;
//
//                if(nums[start]==max_value){
//                    counter--;
//                }
//                start++;
//            }
//            System.out.println("for the i value ::" +i + "the ans is ::" +temp);
//            ans+=temp;
            while (counter==k){
                if(max_value==nums[start]){
                    counter--;
                }
                start++;
            }
            ans+=start;
        }

        return ans;
    }
}
public class CountSubarraysMAXK {
    public static void main(String args[]){
    CountSubarraysMAXKSolution countSubarraysKSolution=new CountSubarraysMAXKSolution();
    System.out.println(countSubarraysKSolution.countSubarrays(new int[]{61,23,38,23,56,40,82,56,82,82,82,70,8,69,8,7,19,14,58,42,82,10,82,78,15,82},2));
    }
}
