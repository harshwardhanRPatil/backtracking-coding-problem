//package BackTracking;
//
//
//import java.util.*;
//
//class NextSpecialPalindromeNumberSolution {
//    public long specialPalindrome(long n) {
//        List<List<Integer>> ans = new ArrayList<>();
//        long temp=0;
//        Set<Set<Integer>> tempans= new HashSet<>();
//        int num = (int) (n%10);
//        int[] nums=new int[num-1];
//        for(int i =1;i<=num;i++){
//            nums[i-1]=i;
//        }
//        return solve(nums,0,temp,ans);
//
//    }
//
//    public void solve(int[] nums, int start, long temp, long ans) {
//
//        if (nums.length == start) {
//            isPalindrome(String.valueOf(temp));
//            ans=temp;
//            return;
//        }
//
//        for (int i = start; i < nums.length; i++) {
//            temp=temp*10+nums[i];
//            swap(nums, start, i);
//            solve(nums, start + 1, temp, ans);
//            swap(nums, i, start);
//            temp.remove(temp.size() - 1);
//        }
//    }
//
//    public void swap(int[] str, int i, int j) {
//        if (i < 0 || j < 0 || i >= str.length || j >= str.length) {
//            throw new IllegalArgumentException("Invalid indices");
//        }
//
//        int temp = str[i];
//        str[i] = str[j];
//        str[j] = temp;
//    }
//    public boolean isPalindrome(String str) {
//        int left = 0, right = str.length() - 1;
//        while (left < right) {
//            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }
//}
//public class NextSpecialPalindromeNumber {
//    public static void main(String args[]){
//        NextSpecialPalindromeNumberSolution nextSpecialPalindromeNumberSolution=new NextSpecialPalindromeNumberSolution();
//    System.out.println(nextSpecialPalindromeNumberSolution.specialPalindrome(44));
//    }
//}
