package Array.SlidingWindow;

//https://leetcode.com/problems/sliding-subarray-beauty/
class GetSubarrayBeautySolution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        // for the negative array

//        int n = arr.length;
//        List<Integer> ans = new ArrayList<>();
//        Deque<Integer> negatives = new LinkedList<>();
//
//
//        int left = 0;
//        for (int right = 0; right < n; right++) {
//            // Add current element if it's negative
//            if (arr[right] < 0) {
//                negatives.addLast(right);
//            }
//            if (right - left + 1 == k) {
//                // The first negative is at the front of the deque
//                if (!negatives.isEmpty()) {
//                    ans.add(arr[negatives.peekFirst()]);
//                } else {
//                    ans.add(0); // no negative in this window
//                }
//
//                // Remove element going out of window
//                if (!negatives.isEmpty() && negatives.peekFirst() == left) {
//                    negatives.pollFirst();
//                }
//
//                left++; // shrink window from left
//            }
//        }
//        return ans;

        // for the negative array for a smart element
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int[] freq = new int[51]; // for negatives -1 to -50 (mapped to 1..50)

        for (int i = k; i <= n; i++) {

            int count = 0;
            int beauty = 0;
            for (int j = 50; j >= 1; j--) { // from most negative to least
                count += freq[j];
                if (count >= x) {
                    beauty = -j; // actual negative number
                    break;
                }
            }
            result[i - k] = beauty; // record result for this window

            // Slide the window
            if (i < n) {
                if (nums[i] < 0) freq[-nums[i]]++;
                if (nums[i - k] < 0) freq[-nums[i - k]]--;
            }
        }
        return result;
    }
}
public class GetSubarrayBeauty {
    public static void main(String args[]){
GetSubarrayBeautySolution getSubarrayBeautySolution = new GetSubarrayBeautySolution();
System.out.println(getSubarrayBeautySolution.getSubarrayBeauty(new int[]{1,-1,-3,-2,3},3,2));
    }
}
