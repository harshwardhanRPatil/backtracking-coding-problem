package SlidingWindow;

// https://leetcode.com/problems/alternating-groups-ii/?envType=daily-question&envId=2025-03-09

// [1,2,3]
// [f,t,t,t]
//i=1 j=0
class AlternatingGroupsIISolution {
  public int numberOfAlternatingGroups(int[] colors, int k) {
      int left=0;
      int right=1;
      int result=0;

      int n=colors.length;
      for (right=1;right<n+k-1;right++){
          if(colors[right%n]==colors[(right+1)%n]){
              left=right;
          }

          if (right-left+1>k){
              left+=1;
          }
          if(right-left+1==k){
              result+=1;
          }
      }
      return result;
  }
    }
// 0 1 0 1 0 0 1
// 0 1 2 3 4 0 1
// 5+3-1=7
public class AlternatingGroupsII {
  public static void main(String args[]) {
    AlternatingGroupsIISolution alternatingGroupsIISolution = new AlternatingGroupsIISolution();
    System.out.println(
        alternatingGroupsIISolution.numberOfAlternatingGroups(new int[] {0,1,0,1,0}, 3));
  }
}
