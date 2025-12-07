package Graph;

import java.security.PublicKey;
import java.util.*;

class Pair {
  int first, second;

  Pair(int first, int second) {
    this.first = first;
    this.second = second;
  }

  public int getFirst() {
    return first;
  }

  public int getSecond() {
    return second;
  }

  @Override
  public String toString() {
    return "(" + first + ", " + second + ")";
  }
}

class StepsByKnightSolution {

      public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        int src_x = N - KnightPos[1];
        int src_y = KnightPos[0] - 1;
        int target_x = N - TargetPos[1];
        int target_y = TargetPos[0] - 1;

        List<List<Integer>> direction =
            Arrays.asList(
                Arrays.asList(-1, -2),
                Arrays.asList(-1, 2),
                Arrays.asList(1, -2),
                Arrays.asList(1, 2),
                Arrays.asList(-2, -1),
                Arrays.asList(-2, 1),
                Arrays.asList(2, 1),Arrays.asList(2, -1));
    System.out.println();
        return pathfinder(direction, N, src_x, src_y, target_x, target_y, 0);
      }

      public int pathfinder(
          List<List<Integer>> direction,
          int N,
          int src_x,
          int src_y,
          int target_x,
          int tatget_y,
          int step) {
        List<List<Integer>> visited = new ArrayList<>();
        for (int i = 0; i < N; i++) {
          visited.add(new ArrayList<>(Collections.nCopies(N, 0)));
        }

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src_x, src_y));
    System.out.println(visited.toString());
        visited.get(src_x).set(src_y, 1);

        while (!queue.isEmpty()) {
          int qSize = queue.size();
          while (qSize > 0) {
            Pair pair = new Pair(queue.peek().getFirst(), queue.peek().getSecond());
            queue.remove();
            int x = pair.getFirst();
            int y = pair.getSecond();
            if (x == target_x && y == tatget_y) {
              return step;
            }
            for (int i = 0; i < direction.size(); i++) {
              int new_x = x + direction.get(i).get(0);
              int new_y = y + direction.get(i).get(1);
              if (new_y >= 0
                  && new_x >= 0
                  && new_x < N
                  && new_y < N
                  && visited.get(new_x).get(new_y) == 0) {
                visited.get(new_x).set(new_y, 1);
                queue.add(new Pair(new_x, new_y));
              }
            }
            qSize -= 1;
          }
          step += 1;
        }
        return -2;
      }
    }

public class StepsByKnight {
  public static void main(String args[]) {

    StepsByKnightSolution solution = new StepsByKnightSolution();
    System.out.println(solution.minStepToReachTarget(new int[] {3,3}, new int[] {2, 1}, 3));
  }
}
