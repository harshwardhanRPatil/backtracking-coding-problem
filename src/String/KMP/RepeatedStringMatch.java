package String.KMP;


class RepeatedStringMatchSolution {
    public int repeatedStringMatch(String a, String b) {
        int index=b.length()/a.length();
        StringBuilder str = new StringBuilder();
        int count=0;
//      index logic is that in worst casse we can have a legnt match at the end of the data
//        ling of the course  is attch below   ->https://youtu.be/_R3POMXMk4I?t=840
        for(int i=0;i<=index+2;i++){

            if(str.toString().contains(b))
                return count;
            else{
                str.append(a);
                count++;
            }
        }
        return -1;
    }
}
public class RepeatedStringMatch {
    public static void main(String args[]){
        RepeatedStringMatchSolution repeatedStringMatchSolution=new RepeatedStringMatchSolution();
    System.out.println(repeatedStringMatchSolution.repeatedStringMatch("abcd","cdabcdab"));
    }
}
