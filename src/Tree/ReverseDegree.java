package Tree;

class ReverseDegreeSolution {
    public int reverseDegree(String s) {

        int ans=0;
        int n=s.length();
        for(int i=0;i<n;i++){
      System.out.println(26 - (s.charAt(i)- 'a'));
            ans += (26 - (s.charAt(i)- 'a'))*(i+1);

        }
        return ans;
    }
}
public class ReverseDegree {
    public static void main(String args []){
        ReverseDegreeSolution reverseDegreeSolution=new ReverseDegreeSolution();
    System.out.println(reverseDegreeSolution.reverseDegree("zabz"));
    }
}
