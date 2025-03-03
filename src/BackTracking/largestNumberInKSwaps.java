package BackTracking;



class SolutionKSwap{
    public int solve(String s, int K){
        return 0;
    }

    public void  swapping(String s, int k,int start,String res){
        if(k==0 || start==s.length()){
            return;
        }
        for (int i=start+1;i<s.length();i++){

            swap(s,start,i);
            if(s.compareTo(res)>0){
                res=s;
                swapping(s,k-1,i,res);
            }
            swap(s,i,start);
        }

    }
    public  String swap(String str, int i, int j) {
        if (i < 0 || j < 0 || i >= str.length() || j >= str.length()) {
            throw new IllegalArgumentException("Invalid indices");
        }

        char[] charArray = str.toCharArray(); // Convert string to char array
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;

        return new String(charArray); // Convert back to string
    }
}
public class largestNumberInKSwaps {

    public static void main(String args[]) {
        SolutionKSwap solution = new SolutionKSwap();
        System.out.print(solution.solve("122345",3));
    }
}
