package Graph;

//https://leetcode.com/problems/count-unguarded-cells-in-the-grid/?envType=daily-question&envId=2025-11-02

import java.util.*;

class CountUnguardedSolution {
    int rows, cols;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        rows = m;
        cols = n;
        int[][] vis = new int[m][n];

        for (int[] g : guards) {
            int x = g[0];
            int y = g[1];
            vis[x][y] = 1;
        }

        for (int[] w : walls) {
            int x = w[0];
            int y = w[1];
            vis[x][y] = 2;
        }

        for (int[] guard : guards) {
            int r = guard[0], c = guard[1];
            dfs(r, c + 1, 'r', vis);
            dfs(r, c - 1, 'l', vis);
            dfs(r + 1, c, 'd', vis);
            dfs(r - 1, c, 'u', vis);
        }


        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0){
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int i, int j, char dir, int[][] vis) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || vis[i][j] == 1 || vis[i][j]==2) {
            return;
        }
        vis[i][j] = 3;

        if (dir == 'r') {
            dfs(i, j + 1, dir, vis);
        } else if (dir == 'l') {
            dfs(i, j - 1, dir, vis);
        } else if (dir == 'u') {
            dfs(i - 1, j, dir, vis);
        } else if (dir == 'd') {
            dfs(i + 1, j, dir, vis);
        }
    }
}

public class CountUnguarded {
  public static void main(String args[]) {

    CountUnguardedSolution countUnguardedSolution = new CountUnguardedSolution();
    System.out.println(countUnguardedSolution.countUnguarded(4,6,new int[][]{{0,0},{1,1},{2,3}}, new int[][]{{0,1},{2,2},{1,4}}));
    }

}
