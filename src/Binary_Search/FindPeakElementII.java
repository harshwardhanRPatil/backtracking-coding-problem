package Binary_Search;

import java.util.Arrays;

class FindPeakElementIISolution {
  public int[] findPeakGrid(int[][] mat) {
    int m = mat.length, n = mat[0].length;
    int startCol = 0, endCol = n - 1;

    while (startCol <= endCol) {
      int midCol = startCol + (endCol - startCol) / 2;

      // Find the row index of the max element in the middle column
      int maxRowIdx = 0;
      for (int i = 0; i < m; i++) {
        if (mat[i][midCol] > mat[maxRowIdx][midCol]) {
          maxRowIdx = i;
        }
      }

      // Check if the max element is a peak
      int currentVal = mat[maxRowIdx][midCol];
      int leftVal = (midCol - 1 >= 0) ? mat[maxRowIdx][midCol - 1] : -1;
      int rightVal = (midCol + 1 < n) ? mat[maxRowIdx][midCol + 1] : -1;

      if (currentVal > leftVal && currentVal > rightVal) {
        return new int[] {maxRowIdx, midCol};
      } else if (currentVal < rightVal) {
        startCol = midCol + 1;
      } else {
        endCol = midCol - 1;
      }
    }

    return new int[] {-1, -1}; // Should not be reached
  }
}

public class FindPeakElementII {
  public static void main(String args) {
    FindPeakElementIISolution findPeakElementIISolution = new FindPeakElementIISolution();
    System.out.println(
        Arrays.toString(findPeakElementIISolution.findPeakGrid(new int[][] {{1, 4}, {3, 2}})));
  }
}
