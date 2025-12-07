package Array.SlidingWindow;

// https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/description/?envType=daily-question&envId=2025-03-10

import java.util.*;

class CountOfSubstringsConsonantsIISolution {
  public static long countOfSubstrings(String word, int k) {
    return altestk(word, k) - altestk(word, k + 1);
  }

  public static int altestk(String word, int k) {
    int i = 0;
    HashMap<Character, Integer> dict = new HashMap<>();
    List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
    int counter = 0;
    int nonVowelCount = 0;

    for (int j = 0; j < word.length(); j++) {
      char ch = word.charAt(j);

      if (vowels.contains(ch)) {
        dict.put(ch, dict.getOrDefault(ch, 0) + 1);

      } else {
        nonVowelCount++;
      }

      // Ensure k is within valid range
      while (dict.size() == 5 && nonVowelCount >= k ) {
        counter += (word.length() - j);
        char leftChar = word.charAt(i);


        if (vowels.contains(leftChar)) {
          dict.put(leftChar, dict.get(leftChar) - 1);
          if (dict.get(leftChar) == 0) {
            dict.remove(leftChar);
          }
        } else {
          nonVowelCount--;
        }
        System.out.println(dict.toString());
        i++;
      }
    }

    return counter;
  }
}

public class CountOfSubstringsConsonantsII {
  public static void main(String args[]) {
    CountOfSubstringsConsonantsIISolution countOfSubstringsConsonantsIISolution =
        new CountOfSubstringsConsonantsIISolution();
    System.out.println(
        countOfSubstringsConsonantsIISolution.countOfSubstrings("ieaouqqieaouqq", 1));
  }
}
