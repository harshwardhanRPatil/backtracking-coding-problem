package BackTracking;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

class letterSolution {
  public List<String> letterCombinations(String digits) {

    List<String> combination = new ArrayList<>();
    if(digits.length()==0){
      return  combination;
    }
    Map<Character, String> digitToLetters = new HashMap<>();

    digitToLetters.put('2', "abc");
    digitToLetters.put('3', "def");
    digitToLetters.put('4', "ghi");
    digitToLetters.put('5', "jkl");
    digitToLetters.put('6', "mno");
    digitToLetters.put('7', "pqrs");
    digitToLetters.put('8', "tuv");
    digitToLetters.put('9', "wxyz");
    List<String> temp = new ArrayList<>();

    soluve(digits,0,combination,temp,digitToLetters);
    return combination;
  }

  public void soluve(String s,int start,List<String> combination,List<String> temp,Map<Character, String> dict){
    System.out.println("lenght of string :" + s.length() +" and index is "+start);
    if(s.length()==start){
      combination.add(stringconverter(temp).toString());
      return;
    }

    for (char i : dict.get(s.charAt(start)).toCharArray()) {
      temp.add(String.valueOf(i));
      soluve(s,start+1,combination,temp,dict);
      temp.remove(temp.size()-1);
    }

  }
  public StringBuilder stringconverter(List<String> data){
    StringBuilder word = new StringBuilder("");
    for (String i : data){
      word.append(i);

    }
    return word;
  }
}

public class LetterCombinationsOfAPhoneNumber {

  public static void main(String args[]) {

    letterSolution letterSolution = new letterSolution();
    System.out.println(letterSolution.letterCombinations("456").toString());
  }
}
