package Binary_Search;


//https://leetcode.com/problems/minimum-time-to-repair-cars/?envType=daily-question&envId=2025-03-16
//Note  -> use long becasuse of int value range
class MinTimeRepairCarsSolution {
    public long repairCars(int[] ranks, int cars) {

        long l=0,r=(long)ranks[0]*cars*cars;
        long ans=-1;

        while (l<r){
           long mid=l+(r-l)/2;
            long reparied=countRepair(mid,ranks,cars);
           if(reparied>=cars){
               ans=mid;
               r=mid-1;
           }
           else{
               l=mid+1;
           }
        }
        return ans;
    }
    public long countRepair(long time,int[] ranks, int cars){
        long count=0;
        for(int i:ranks){
            count+=(long)Math.sqrt(time/i);
        }
        return count;
    }
}
public class MinTimeRepairCars {
    public static void main(String args[]){
        MinTimeRepairCarsSolution minTimeRepairCarsSolution=new MinTimeRepairCarsSolution();
    System.out.println(minTimeRepairCarsSolution.repairCars(new int[]{4,2,3,1},10));
    }
}
