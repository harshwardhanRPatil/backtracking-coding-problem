package Dynamic_Programming;

class LongestPalindromebyConcatenatingTwoLetterWordsSolution {

  public int longestPalindrome(String[] words) {
    int[][] dp = new int[26][26];
    int ans = 0;

    for (String w : words) {
      int m = w.charAt(0) - 'a';
      int n = w.charAt(1) - 'a';

      if (dp[n][m] > 0) {
        ans += 4;
        dp[n][m]--;
      } else {
        dp[m][n]++;
      }
        // Print current word and dp matrix
        System.out.println("After processing word: " + w);
        printDP(dp);
        System.out.println("---------------");

    }


    // one center palindromic word if available
    for (int i = 0; i < 26; i++) {
      if (dp[i][i] > 0) {
        ans += 2;
        break;
      }
    }

    return ans;
  }

    private void printDP(int[][] dp) {
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (dp[i][j] != 0) {
                    System.out.print((char) ('a' + i) + "" + (char) ('a' + j) + ":" + dp[i][j] + "  ");
                }
            }
        }
        System.out.println();
    }
}

public class LongestPalindromebyConcatenatingTwoLetterWords {
  public static void main(String args[]) {
      LongestPalindromebyConcatenatingTwoLetterWordsSolution longestPalindromebyConcatenatingTwoLetterWordsSolution=new LongestPalindromebyConcatenatingTwoLetterWordsSolution();
    System.out.println(longestPalindromebyConcatenatingTwoLetterWordsSolution.longestPalindrome(new String[]{"lc","cl","gg","dd"}));
  }
}
