package Binary_Search;

public class Basic_Binary_Search {
    public static void main(String args[]){
        int[] element_data=new int[]{3,6,7,8,10,34,57,87};

        int left=0,right=element_data.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;
      if (element_data[mid] == 34) {
        break;
            }else if(element_data[mid]>32){
          right=mid-1;
      }else{
          left=mid+1;
      }
        }
    System.out.println(left);
    }
}
