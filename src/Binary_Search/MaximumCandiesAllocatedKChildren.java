package Binary_Search;

import java.util.Arrays;

class MaximumCandiesAllocatedKChildrenSolution {
    public int maximumCandies(int[] candies, long k) {
        int counter = 0;
        long sum_value = Arrays.stream(candies).asLongStream().sum();

        if (sum_value < k) {
            return 0;
        }
        int left = 1;
        int right = (int) (sum_value / k);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long temp = 0;
            for (int candy : candies) {
                temp += candy / mid;
                if (temp >= k) break;
            }
            if (temp >=k) {
//                if i cast it in int it cause limitiation of int
                counter = mid;
                left = mid+1;
            } else {
                right = mid - 1;
            }
        }
        return counter;
    }
}

public class MaximumCandiesAllocatedKChildren {
  public static void main(String args[]) {
    MaximumCandiesAllocatedKChildrenSolution maximumCandiesAllocatedKChildrenSolution =
        new MaximumCandiesAllocatedKChildrenSolution();
    System.out.println(
        maximumCandiesAllocatedKChildrenSolution.maximumCandies(new int[] {5, 8, 6}, 3));
  }
}
