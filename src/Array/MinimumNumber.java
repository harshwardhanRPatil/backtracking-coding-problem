package Array;



// have same code just copy the code because have same logic in notebook

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MinimumNumberSolution {
    public int minimumOperations(int[] nums) {
    Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
        if (isDistinct(freq)) return 0;
    System.out.println(freq.toString());
        int k = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        int n=nums.length;
        int i=0;
        while (i<n) {
            if (n-i < 3) return k + 1;

            for (int j = i; j < i+3; j++) {
                int val = nums[j];
        System.out.println(val);
                freq.put(val, freq.get(val) - 1);
                if (freq.get(val) == 0) freq.remove(val);
            }
            k++;
            i+=3;
            if (isDistinct(freq)) return k;
        }

        return k;
    }


    private boolean isDistinct(Map<Integer, Integer> freq) {
        for (int v : freq.values()) {
            if (v > 1) return false;
        }
        return true;
    }
}
public class MinimumNumber {
    public static void main(String args[]){
MinimumNumberSolution minimumNumberSolution=new MinimumNumberSolution();
    System.out.println(minimumNumberSolution.minimumOperations(new int[]{1,2,3,4,2,3,3,5,7}));
    }
}
