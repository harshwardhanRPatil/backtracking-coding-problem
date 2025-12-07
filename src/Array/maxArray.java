package Array;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/minimum-moves-to-equal-array-elements-iii/description/
class maxArraySolution{
    public int solutionMAx(int[] nums ){
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=maxValue){
                ans+=maxValue-nums[i];
            }
        }
        return ans;
    }
}

//https://leetcode.com/problems/count-subarrays-with-majority-element-i/
class CountMajoritySubarrays{
    public int countMajoritySubarrays(int[] nums, int target) {
        int ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int counter=0;
            for(int j=i;j<n;j++){
                if(nums[j]==target){
                    counter++;
                }
                int temp=j-i+1;
                if(counter>temp/2){
                    ans++;
                }
            }
        }
        return ans;
    }
}

class LongestSubarraySolution{
    public int  longestSubarray(int[] num){
        int n= num.length;

        int[] left= new int[n];
        int[] right = new int[n];

        Arrays.fill(left,1);
        Arrays.fill(right,1);

        for (int i =0;i<n-1;i++){
            if(num[i]<=num[i+1]){
                left[i+1]=left[i]+1;
            }
        }

        for (int i=n-1;i>0;i--){
            if(num[i]>=num[i-1]){
                right[i-1]=right[i]+1;
            }
        }

        int ans=Arrays.stream(left).max().getAsInt()+1;
        for(int i=1;i<n-1;i++){
            if(num[i-1]<=num[i+1]){
                ans=Math.max(ans, left[i - 1] + 1 + right[i + 1]);
            }
        }

        return Math.min(n,ans);
    }
}

class ComboNumber{

    public void comboSolution(String nums){
        Set<String> result = new HashSet<>();
        combineAns( nums,result,"",0,nums.length());

    }
    public void  combineAns(String nums, Set<String> ans, String temp,int position,int n){
        if (position == n) {
            ans.add(temp);
            return;
        }
        for (int i = position; i < n; i++) {
            nums = swapChars(nums, position, i);
            temp += nums.charAt(position);
            combineAns(nums,ans,temp,position+1,n);
            temp = temp.substring(0, temp.length() - 1);
            nums = swapChars(nums, i, position);

        }

    }
    public String swapChars(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}


public class maxArray {
    public static void main(String args[]){

    }
}
