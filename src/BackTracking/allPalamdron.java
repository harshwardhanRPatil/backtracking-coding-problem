package BackTracking;


import java.util.ArrayList;

class SolutionPalmdron{

    public ArrayList<String> solve(String s){
        ArrayList<String> ans =new ArrayList<>();
        ArrayList<String> temp =new ArrayList<>();
        dividerlist(s,ans,temp,0);
        return ans;
    }

    public void dividerlist(String s,ArrayList ans, ArrayList<String> temp,int start){
//        System.out.println(start);
        if (start==s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i =start ;i<s.length();i++){
            String palemdron = s.substring(start, i + 1);
            if(isPalindrome(palemdron)){
               temp.add(palemdron);
               dividerlist(s,ans,temp,i+1);
               System.out.println(palemdron+ " "+temp.size()+ " "+temp.get(0));
               temp.remove(temp.size()-1);
           }
        }

    }

    public boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
public class allPalamdron {
    public static void main(String args []){
        SolutionPalmdron solutionPalmdron=new SolutionPalmdron();
        System.out.println(solutionPalmdron.solve("aa"));
    }
}
