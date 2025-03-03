package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WordBreakSolution {

  public List<String> wordBreak(String s, List<String> wordDict) {
      List<String> ans=new ArrayList<>();
      List<String> temp=new ArrayList<>();
      StringBuilder word = new StringBuilder("");
      solution(s,wordDict,ans,0,word,temp);
    return ans;
  }
  public void solution(String s ,List<String> wordDict ,List<String> ans , int start , StringBuilder word,List<String> temp){
      if (start==s.length()){
      System.out.println("we are at end "+ start);
        ans.add(stringconverter(temp).toString());
        return;
      }
      StringBuilder tempword = new StringBuilder("");
      for(int i=start;i<s.length();i++){
          tempword.append(Character.toString(s.charAt(i)));
          String finalWord = tempword.toString();
          boolean exists =wordDict.stream().anyMatch(wordhelper -> wordhelper.equalsIgnoreCase(finalWord));
          System.out.println("we have a value in dict "+ finalWord);
          if (exists){
              temp.add(tempword.toString());
              solution(s,wordDict,ans,i+1,word,temp);
              temp.removeLast();
          }
      }
//      tempword.deleteCharAt(word.length()-1);
  }
  public StringBuilder stringconverter(List<String> data){
      StringBuilder word = new StringBuilder("");
      for (String i : data){
          word.append(i);
          word.append(" ");
      }
      word.deleteCharAt(word.length() - 1);
      return word;
  }
}

public class WordBreakII {
  public static void main(String args[]) {
    WordBreakSolution wordBreakSolution = new WordBreakSolution();
    System.out.println(wordBreakSolution.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
  }
}
