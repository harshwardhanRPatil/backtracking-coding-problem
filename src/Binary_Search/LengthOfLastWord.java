package Binary_Search;

import java.util.Arrays;

class LengthOfLastWordSolution {
    public int lengthOfLastWord(String s) {
        int length = Arrays.stream(s.trim().split("\\s+"))
                .reduce((first, second) -> second) // Get the last word
                .map(String::length) // Get the length of the last word
                .orElse(0);
        return  length;
    }
}
public class LengthOfLastWord {
    public static void main(String args []){
        LengthOfLastWordSolution lengthOfLastWordSolution=new LengthOfLastWordSolution();
        System.out.println(lengthOfLastWordSolution.lengthOfLastWord("Hello World"));
    }
}
