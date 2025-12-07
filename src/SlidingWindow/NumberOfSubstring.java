package SlidingWindow;

class NumberOfSubstringSolution {
  public int numberOfSubstrings(String s) {
    int counter = 0;

    int left = 0;
    int right = 0;
      int[] count = new int[3];
      int uniqueChars = 0;
    for (right = 0; right < s.length(); right++) {
        if (count[s.charAt(right) - 'a'] == 0) {
            uniqueChars++; // Increment when a new character appears
        }

//        dict.put(s.charAt(right), dict.getOrDefault(s.charAt(right), 0) + 1);
        count[s.charAt(right) - 'a']++;
        while (uniqueChars==3) {
            counter+=s.length()-right;
            count[s.charAt(left) - 'a']--;
            if(count[s.charAt(left) - 'a']==0){
                uniqueChars--;
            }
          left++;
        }
      }

    return counter;
  }
}
//aaacb
//1 +
public class NumberOfSubstring {
  public static void main(String args[]) {
    NumberOfSubstringSolution numberOfSubstringSolution = new NumberOfSubstringSolution();
    System.out.println(numberOfSubstringSolution.numberOfSubstrings("aaacb"));
  }
}
