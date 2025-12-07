package Dynamic_Programming;

class PalindromePartitioningIISolution {

    Integer[] memo;
    public int minCut(String s) {
        memo=new Integer[s.length()];
        return cutcounter(s,0,s.length()-1);
    }

  public int cutcounter(String s,int position,int end) {

    if (isPalindrome(s.substring(position,end+1)) || position>=end ) {
        return 0;
}
      if(memo[position]!=null){
          return memo[position];
      }

    int counter=Integer.MAX_VALUE;;

    for (int i = position; i <=end; i++) {
      if (isPalindrome(s.substring(position, i+1))) {
        counter = Math.min(counter, 1 + cutcounter(s, i + 1, end));
       }
    }
      memo[position]=Math.min(counter, 1+cutcounter(s,position+1,end) );

    return memo[position];
}
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() -1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
public class PalindromePartitioningII {
    public static void main(String args[]){
        PalindromePartitioningIISolution palindromePartitioningIISolution=new PalindromePartitioningIISolution();

    System.out.println(palindromePartitioningIISolution.minCut("acbdfr"));
    }
}
