package String.KMP;

//https://leetcode.com/problems/longest-happy-prefix/description/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LongestHappyPrefixSolution {
    public String longestPrefix(String s) {

        int index=0;
        int i=1;
        int n=s.length();
//        use a array for beter time complexcity
        List<Integer> value=new ArrayList<>(Collections.nCopies(n,0));


        while(i<n){
            if (s.charAt(i)==s.charAt(index)){
                index++;
                value.set(i,index);
                i++;
            }else{
                if(index!=0){
                    index=value.get(index-1);
                }else{
                    value.set(i,0);
                    i++;
                }
            }

        }
        String ans="";
        ans=s.substring(0,index);
        return ans;

    }
}
public class LongestHappyPrefix {
    public static void main(String args[]){

    }
}
