package Graph;


import java.util.*;

// https://leetcode.com/problems/flood-fill/
class FloodFillSolution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int N=image.length;
        int M=image[0].length;
        List<List<Integer>> direction =
                Arrays.asList(
                        Arrays.asList(-1, 0),
                        Arrays.asList(0, -1),
                        Arrays.asList(0, 1),
                        Arrays.asList(1, 0));
        pathfinder(direction,N,M,sr,sc,image,color);
        return image;
    }

    public void pathfinder(
            List<List<Integer>> direction,
            int N,
            int M,
            int src_x,
            int src_y,
            int[][] graph,int color) {
        List<List<Integer>> visited = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            visited.add(new ArrayList<>(Collections.nCopies(M, 0)));
        }

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src_x, src_y));
        visited.get(src_x).set(src_y, 1);

        int current_colore=graph[src_x][src_y];
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            while (qSize > 0) {

                Pair pair = new Pair(queue.peek().getFirst(), queue.peek().getSecond());
                queue.remove();
                int x = pair.getFirst();
                int y = pair.getSecond();
                int value=graph[x][y];
                graph[x][y]=color;


                for (int i = 0; i < direction.size(); i++) {
                    int new_x = x + direction.get(i).get(0);
                    int new_y = y + direction.get(i).get(1);
                    if (new_y >= 0
                            && new_x >= 0
                            && new_x < N
                            && new_y < M
                            && visited.get(new_x).get(new_y) == 0 ) {
                        visited.get(new_x).set(new_y, 1);
            if (graph[new_x][new_y] == current_colore) {
              queue.add(new Pair(new_x, new_y));
                        }
                    }
                }

                qSize -= 1;
            }

        }
    }
}
public class FloodFill {
    public static void main(String args[]){
        FloodFillSolution floodFillSolution=new FloodFillSolution();
    System.out.println(Arrays.deepToString(floodFillSolution.floodFill(new int[][]{{0,0,0}, {0,0,0}}, 1, 0, 2)));
    }
}
