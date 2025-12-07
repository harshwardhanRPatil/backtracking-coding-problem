package BackTracking;

import java.util.*;

class SolveNQueensSolution {
  public List<List<String>> solveNQueens(int n) {
    char[][] metrix = new char[n][n];

    for (int i = 0; i < n; i++) {
      Arrays.fill(metrix[i], '.');
    }

    List<List<String>> ans = new ArrayList<>();

    solveNQueensAns(metrix, 0, 0, n, ans);
    return ans;
  }

  public void solveNQueensAns(char[][] metrix, int row, int col, int n, List<List<String>> ans) {
    if (row == n) {
      ans.add(build(metrix));
      return;
    }

    for (int j = col; j < n; j++) {
      if (isSafe(metrix, row, j, n)) {
        metrix[row][j] = 'Q';
        solveNQueensAns(metrix, row + 1, col, n, ans);
        metrix[row][j] = '.';
      }
    }
  }

  private List<String> build(char[][] board) {
    List<String> res = new ArrayList<>();
    for (char[] row : board) {
      res.add(new String(row));
    }
    return res;
  }

  // Check if placing a queen at (r, c) is safe
  public boolean isSafe(char[][] board, int r, int c, int n) {

    // 8 directions: (row change, col change)
    int[][] dirs = {
      {-1, 0}, // up
      {1, 0}, // down
      {0, -1}, // left
      {0, 1}, // right
      {-1, -1}, // up-left diagonal
      {-1, 1}, // up-right diagonal
      {1, -1}, // down-left diagonal
      {1, 1} // down-right diagonal
    };

    for (int[] d : dirs) {
      int x = r;
      int y = c;

      while (true) {
        x += d[0];
        y += d[1];

        // boundary check
        if (x < 0 || y < 0 || x >= n || y >= n) break;

        // if queen found in this direction → unsafe
        if (board[x][y] == 'Q') return false;
      }
    }

    return true; // no queen seen in any direction
  }

  public List<String> boardToList(int[][] board) {
    List<String> res = new ArrayList<>();
    for (int[] row : board) {
      StringBuilder sb = new StringBuilder();
      for (int x : row) {
        sb.append(x == 1 ? 'Q' : '.');
      }
      res.add(sb.toString());
    }
    return res;
  }
}

public class SolveNQueens {
  public static void main(String args[]) {
    SolveNQueensSolution solveNQueensSolution = new SolveNQueensSolution();
    System.out.println(solveNQueensSolution.solveNQueens(4));
  }
}
