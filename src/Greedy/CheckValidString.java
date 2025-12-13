package Greedy;


// https://leetcode.com/problems/valid-parenthesis-string/description/

//  Metric	        Value
//Time Complexity	O(n)
//Space Complexity	O(1)

class CheckValidStringSolution {
  public boolean checkValidString(String s) {
    int max_count = 0;
    int min_count = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        min_count = min_count + 1;
        max_count = max_count + 1;
      } else if (s.charAt(i) == ')') {
        min_count = min_count - 1;
        max_count = max_count - 1;
      } else {
        min_count = min_count - 1;
        max_count = max_count + 1;
      }
      if (min_count <= 0) min_count = Math.max(min_count, 0);
      if (max_count < 0) return false;
    }
    return (min_count == 0);
  }
}

public class CheckValidString {
  public static void main(String args[]) {
    CheckValidStringSolution checkValidStringSolution = new CheckValidStringSolution();
    System.out.println(checkValidStringSolution.checkValidString("(*))"));
  }
}
