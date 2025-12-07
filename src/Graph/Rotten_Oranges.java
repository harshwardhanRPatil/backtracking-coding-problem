package Graph;

//https://leetcode.com/problems/rotting-oranges/submissions/1605726385/
// Time = O(N∗M)
// Space = O(N∗M)
import java.util.*;

class Rotten_OrangesSolution {
    public int orangesRotting(int[][] grid) {
        int N=grid.length;
        int M=grid[0].length;
    if (N == 1 && M == 1 && grid[0][0] == 0) {
      return 0;
    }
    if (N == 1 && M == 1 && grid[0][0] == 1) {
      return -1;
    }
        int ans=0;
        List<List<Integer>> direction =
                Arrays.asList(
                        Arrays.asList(-1, 0),
                        Arrays.asList(0, -1),
                        Arrays.asList(0, 1),
                        Arrays.asList(1, 0));

        Queue<Pair> queue=new ArrayDeque<>();
        for(int i=0;i<N;i++){
      for (int j = 0; j < M; j++) {
        if (grid[i][j] == 2) {
          queue.add(new Pair(i ,j));
        }
            }
        }

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            int temp=0;
            while (qSize > 0) {
                Pair pair = new Pair(queue.peek().getFirst(), queue.peek().getSecond());
                queue.remove();
                int x = pair.getFirst();
                int y = pair.getSecond();

                for (int i = 0; i < direction.size(); i++) {
                    int new_x = x + direction.get(i).get(0);
                    int new_y = y + direction.get(i).get(1);
                    if (new_y >= 0
                            && new_x >= 0
                            && new_x < N
                            && new_y < M
                             && grid[new_x][new_y]==1) {
                        temp=1;
                        grid[new_x][new_y]=2;
                        queue.add(new Pair(new_x, new_y));
                    }
                }
                qSize -= 1;
            }
            ans+=temp;
        }
        for(int i=0;i<N;i++){
            for (int j = 0; j < M; j++) {
                if(grid[i][j]==1){
                    return -1;
                }
            }}
        return ans;
    }
    public int rotten_solve(int[][] grid,List<List<Integer>> direction,List<List<Integer>> visited,Queue<Pair> queue,int N,int M,int ans){
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            int temp=0;
            while (qSize > 0) {
                Pair pair = new Pair(queue.peek().getFirst(), queue.peek().getSecond());
                queue.remove();
                int x = pair.getFirst();
                int y = pair.getSecond();

                for (int i = 0; i < direction.size(); i++) {
                    int new_x = x + direction.get(i).get(0);
                    int new_y = y + direction.get(i).get(1);
                    if (new_y >= 0
                            && new_x >= 0
                            && new_x < N
                            && new_y < M
                            && visited.get(new_x).get(new_y) == 0 && grid[new_x][new_y]==1) {
                        visited.get(new_x).set(new_y, 1);
                        temp=1;
                        queue.add(new Pair(new_x, new_y));
                    }
                }
                qSize -= 1;
            }
            ans =temp;
        }
        return ans;
    }
}
public class Rotten_Oranges {
    public static void main(String args[]){
        Rotten_OrangesSolution rottenOrangesSolution = new Rotten_OrangesSolution();
    System.out.println(rottenOrangesSolution.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    System.out.println(rottenOrangesSolution.orangesRotting(new int[][]{{0,0,0,0}}));

    }
}
