package Binary_Search;

class SqrtxSolution {
    public int mySqrt(int x) {

        int low=1;
        int high=x;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid==x/mid)  return mid;
            if(mid>x/mid){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return high;
    }
}
public class Sqrtx {
    public static void main(String args[]){
     SqrtxSolution sqrtxSolution=new SqrtxSolution();
    System.out.println(sqrtxSolution.mySqrt(3));
    }
}
