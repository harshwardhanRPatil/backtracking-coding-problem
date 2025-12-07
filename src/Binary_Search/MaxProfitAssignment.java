package Binary_Search;

import java.util.ArrayList;
import java.util.List;

class MaxProfitAssignmentSolution{
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    int n = difficulty.length;
    List<int[]> infos = new ArrayList<>();

    // Step 1: Combine difficulty and profit
        for (int i = 0; i < n; i++) {
        infos.add(new int[]{difficulty[i], profit[i]});
    }

    // Step 2: Sort by difficulty
        infos.sort((a, b) -> a[0] - b[0]);

    // Step 3: Build prefix array of max profit for each difficulty
    List<int[]> maxProfitForDifficulty = new ArrayList<>();
    int maxp = 0;
        for (int[] info : infos) {
        maxp = Math.max(maxp, info[1]);
        maxProfitForDifficulty.add(new int[]{info[0], maxp});
    }

    // Step 4: For each worker, find highest difficulty ≤ worker ability
    int totalProfit = 0;
        for (int w : worker) {
        int left = 0, right = maxProfitForDifficulty.size() - 1;
        int idx = -1;  // store best valid job index

        // binary search for largest difficulty <= w
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (maxProfitForDifficulty.get(mid)[0] <= w) {
                idx = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (idx != -1) {
            totalProfit += maxProfitForDifficulty.get(idx)[1];
        }
    }

        return totalProfit;
}

}
public class MaxProfitAssignment {
    public static void main(String args[]){

    }
}
