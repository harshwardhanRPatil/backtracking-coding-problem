package DailyQue;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class MaxIncreasingSubarraysSolution {
    public int hasIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int ans=0;
        Map<Integer,Integer> storage=new HashMap<>();
        HashSet<Integer> set = new HashSet<>(); // stores start indices of strictly increasing subarrays of length k

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int prev = nums.get(i);

            while (j < n && nums.get(j) > prev) {
                prev = nums.get(j);
                j++;
            }
            int len = j - i;
            if(len>1){
                // as we have store the index 0 and weh check for the 3 index it will do 3-3 and 0 so we have that and we return true

                storage.put(i,len);
                if (set.contains(i - len))
                    ans=Math.max(ans,len);
                set.add(i);
            }
        }

        return ans;
    }
}
public class MaxIncreasingSubarrays {
    public static void main(String args[]){
        MaxIncreasingSubarraysSolution MaxIncreasingSubarraysSolution= new MaxIncreasingSubarraysSolution();
    System.out.println(MaxIncreasingSubarraysSolution.hasIncreasingSubarrays(List.of(2,5,7,8,9,2,3,4,5,3,1)));
    }
}
