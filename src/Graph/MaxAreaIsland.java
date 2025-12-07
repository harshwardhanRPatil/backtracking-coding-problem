package Graph;

// https://leetcode.com/problems/max-area-of-island/

import java.util.*;

class MaxAreaIslandSolution {
  public int maxAreaOfIsland(int[][] grid) {
    int N = grid.length;
    int M = grid[0].length;
    System.out.println(M +" "+ N);
    List<List<Integer>> visited = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      visited.add(new ArrayList<>(Collections.nCopies(M, 0)));
    }
    List<List<Integer>> direction =
        Arrays.asList(
            Arrays.asList(0, 1), Arrays.asList(0, -1), Arrays.asList(-1, 0), Arrays.asList(1, 0));
    int ans = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (grid[i][j] == 0) {
          visited.get(i).set(j, 1);
        } else if (visited.get(i).get(j) == 0 && grid[i][j] == 1) {
          pathfinder(grid, direction, N, M, i, j, visited);
            System.out.println("value of  X and Y are ::" + i +" ::" +j);

            ans++;
        }
      }
    }

    return ans;
  }

  public void pathfinder(
      int[][] grid,
      List<List<Integer>> direction,
      int N,
      int M,
      int src_x,
      int src_y,
      List<List<Integer>> visited) {

    visited.get(src_x).set(src_y, 1);
    for (int i = 0; i < direction.size(); i++) {
      int new_x = src_x + direction.get(i).get(0);
      int new_y = src_y + direction.get(i).get(1);
      if (new_y >= 0
          && new_x >= 0
          && new_x < N
          && new_y < M
          && visited.get(new_x).get(new_y) == 0) {
        if (grid[new_x][new_y] == 1) {
          pathfinder(grid, direction, N, M, new_x, new_y, visited);
        } else {
          visited.get(new_x).set(new_y, 1);
        }
      }
    }
  }
  }
  public class MaxAreaIsland {
    public static void main(String args[]) {
      MaxAreaIslandSolution maxAreaIslandSolution = new MaxAreaIslandSolution();
      System.out.println(
          maxAreaIslandSolution.maxAreaOfIsland(
              new int[][] {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
              }));
    }
  }

