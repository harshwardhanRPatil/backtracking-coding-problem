package Binary_Search;

class B4SReverseSortedArraySolution{
    public int solve(int[] element_data,int taeget){
        int left=0,right=element_data.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;

            if(element_data[mid]==taeget){
                return mid;
            }else if(element_data[mid]>taeget){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
}
public class B4SReverseSortedArray {
    public static void main(String args[]){
        B4SReverseSortedArraySolution b4SReverseSortedArraySolution=new B4SReverseSortedArraySolution();
    System.out.println(b4SReverseSortedArraySolution.solve(new int[]{15,14,12,10,6,4,3},10));
    }
}
