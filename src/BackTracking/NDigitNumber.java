package BackTracking;

import java.util.ArrayList;
import java.util.List;

class Solution{

    public List swapK(int k){
        List<Integer> ans = new ArrayList();
        List<Integer> combine=new ArrayList();
//        combine.add(1);
        solution_ans(k,0,ans, combine);
        return ans;
    }
    public void solution_ans(int original,int n,List<Integer> ans,List<Integer> combine){

//            System.out.println(original);
        if (combine.size() == original && original==1) { // Ensure it's exactly 'n' digits
            ans.add(combineNumbers(combine));
            return;
        }
            if (combine.size() == original) {
                if(combine.get(0)==0){return;}// Ensure it's exactly 'n' digits
                ans.add(combineNumbers(combine));
                return;
            }



//        System.out.println(combine.get(combine.size()-1));
        for (int i=n;i<=9;i++){
            if (combine.isEmpty() || combine.get(combine.size()-1) < i){
                combine.add(i);
                solution_ans(original,i+1,ans,combine);
                combine.remove(combine.size()-1);
            }
        }
    }
    public static int combineNumbers(List<Integer> numbers) {
        StringBuilder combined = new StringBuilder();
        for (int num : numbers) {
            combined.append(num);
        }
//        System.out.println(combined);
        return Integer.parseInt(combined.toString());
    }
}

public class NDigitNumber {
    public static void main(String args []){
        Solution data= new Solution();
        System.out.println(data.swapK(1));
    }
}
