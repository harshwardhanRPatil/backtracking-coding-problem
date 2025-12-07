package DailyQue;

// https://leetcode.com/problems/minimum-operations-to-make-binary-palindrome/

class MinOperationsSolution {
    public int[] minOperations(int[] nums) {
        int n= nums.length;
        int[] ans= new int[n];
    for (int i = 0; i < n; i++) {
        int temp=nums[i];
        int decrese_temp=nums[i];
        int counter=0;
      while(!isBinaryPalindrome(temp) && !isBinaryPalindrome(decrese_temp)){
          temp+=1;
          decrese_temp-=1;
          counter++;
      }
      ans[i]=counter;
}
        return ans;
    }

    public boolean isBinaryPalindrome(int num){
        String bin = Integer.toBinaryString(num);
        int left = 0, right = bin.length() - 1;
        while(left<right){
            if(!(bin.charAt(left)==bin.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
public class MinOperations {
  public static void main(String args[]) {
      MinOperationsSolution minOperationsSolution= new MinOperationsSolution();
    System.out.println(minOperationsSolution.minOperations(new int[]{1624}));
  }
}
