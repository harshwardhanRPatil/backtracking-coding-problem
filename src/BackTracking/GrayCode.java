package BackTracking;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GrayCodeSolution {
    public List<Integer> grayCode(int n) {
        Set<String> result = new HashSet<>();
        String s= "0".repeat(n);
        combination(n,result,0,s);
        List<Integer> list = new ArrayList<>();
        for (String bin : result) {
            list.add(Integer.parseInt(bin, 2));
        }

        return list;
    }

    public void combination(int n, Set<String> ans,int position, String value ){
        if(position==n){
            ans.add(value);
            return;
        }

        for(int i=position;i<n;i++){
            combination(n,ans,i+1,value);
            value=replaceAt(value,i,'1');
            combination(n,ans,i+1,value);
            value=replaceAt(value,i,'0');
        }
    }
    public String replaceAt(String s, int pos, char ch) {
        return s.substring(0, pos) + ch + s.substring(pos + 1);
    }
}
public class GrayCode {
    public static void main(String args[]){
        GrayCodeSolution grayCodeSolution= new GrayCodeSolution();
    System.out.println(grayCodeSolution.grayCode(3));
    }
}
