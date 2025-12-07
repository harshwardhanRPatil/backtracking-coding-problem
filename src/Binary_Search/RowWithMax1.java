package Binary_Search;

// https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1

class RowWithMax1Solution {
  public int rowWithMax1s(int arr[][]) {

      int n = arr.length;
      int m = arr[0].length;
      int row = -1;   // store the answer row
      int maxOnes = 0; // store max count of 1s found

      for (int i = 0; i < n; i++) {
          int firstOneIndex = firstOne(arr[i], m);
          if (firstOneIndex != -1) {
              int onesCount = m - firstOneIndex;
              if (onesCount > maxOnes) {
                  maxOnes = onesCount;
                  row = i;
              }
          }
      }

    return row;
  }
    // binary search for index of first 1 in the row
    private int firstOne(int[] row, int m) {
        int left = 0, right = m - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == 1) {
                ans = mid;       // possible candidate
                right = mid - 1; // search further left
            } else {
                left = mid + 1;  // move right
            }
        }
        return ans;
    }
}

public class RowWithMax1 {
  public static void main(String args[]) {
    RowWithMax1Solution rowWithMax1Solution = new RowWithMax1Solution();
    System.out.println(
        rowWithMax1Solution.rowWithMax1s(
            new int[][] {{0, 0, 0, 0}, {0, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 1}}));
  }
}
