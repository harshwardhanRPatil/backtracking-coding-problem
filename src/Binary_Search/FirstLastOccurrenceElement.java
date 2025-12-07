package Binary_Search;


import java.lang.annotation.Target;

class FirstLastOccurrenceElementSolution{
    public int[] solve(int[] element_data,int target){
//            int left=0,right=element_data.length-1;
//            int result=-1;
//        int[] data=new int[2];

//            my approch
//            while(left<right){
//                int mid=left+(right-left)/2;
//      System.out.println(element_data[mid]);
//                if(element_data[mid]==target){
//                    right=mid;
//                }else if(element_data[mid]<target){
//                    left=mid+1;
//                }else{
//                    right=mid-1;
//                }
//
//            }
//            return left;

//        AV approch
        int left=0,right=element_data.length-1;
        int result=-1,resultlast=-1;
        int[] data=new int[2];
        while(left<=right){
            int mid=left+(right-left)/2;
            if(element_data[mid]==target){
                right=mid-1;
                result=mid;
            }else if(element_data[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }

        }
        left=0;
        right=element_data.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(element_data[mid]==target){
                left=mid+1;
                resultlast=mid;
            }else if(element_data[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }

        }
        data[0]=result;
        data[1]=resultlast;
        return data;
    }
}
public class FirstLastOccurrenceElement {
    public static void main(String args[]){
        FirstLastOccurrenceElementSolution firstLastOccurrenceElementSolution=new FirstLastOccurrenceElementSolution();
    System.out.println(firstLastOccurrenceElementSolution.solve(new int[]{1,2,4,6,8,10,10,10,15,60}, 10));
    }
}
