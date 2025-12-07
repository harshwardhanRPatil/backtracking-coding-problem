package Binary_Search;

//https://leetcode.com/problems/koko-eating-bananas/

class KokoEatingBananasSolution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        // if we use size performace decrese
// int size=piles.length;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(countMinEatingSpeed(piles,h,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public boolean countMinEatingSpeed(int[] piles, int h,int hourEating){
        int counter_day=0;
        for(int pipe:piles){
            // use double so we can have round up a value
            counter_day+=(int) Math.ceil((double) pipe / hourEating);
            if(counter_day>h) return false;

        }
        return true;
    }
}
public class KokoEatingBananas {
    public static void main(String args[]){
KokoEatingBananasSolution kokoEatingBananasSolution=new KokoEatingBananasSolution();
    System.out.println(kokoEatingBananasSolution.minEatingSpeed(new int[]{3,6,7,11},8));
    }
}
