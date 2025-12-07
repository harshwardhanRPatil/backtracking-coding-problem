package Graph;

// https://leetcode.com/problems/longest-cycle-in-a-graph/description/
//Note -: my solution is also corect only issue is i have a use constant counter but i should have a temp and a final so i can do comparesssion

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class LongestCycleGraphSolution {
  int counter_value = -1;
  public int longestCycle(int[] edges) {
    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    for (int i = 0; i < edges.length; i++) {
      arr.add(new ArrayList<>());
    }
    for (int i = 0; i < edges.length; i++) {
      if(edges[i]!=-1){
        arr.get(i).add(edges[i]);

      }
    }

    List<Integer> visited = new ArrayList<>(Collections.nCopies(edges.length, 0));
    List<Integer> parent = new ArrayList<>(Collections.nCopies(edges.length, 0));

    System.out.println(arr.toString());
    for (int i = 0; i < arr.size(); i++) {
      if(visited.get(i)==0){
        isFinder(i, visited, arr, parent, 0);
      }
      //      System.out.println(parent.toString()+"::"+counter);
    }
    return counter_value;
  }

  public void isFinder(
          int node,
          List<Integer> visited,
          ArrayList<ArrayList<Integer>> graph,
          List<Integer> current,
          int counter) {
    counter++;
    visited.set(node, 1);
    current.set(node, counter);

    for (int i : graph.get(node)) {
      if (visited.get(i) == 0) {
        isFinder(i, visited, graph, current, counter);
      } else if (current.get(i) != 0) {
        counter_value = Math.max(counter_value,counter-current.get(i)+1);
      }
    }
    counter--;
    current.set(node, 0);
  }
}

public class LongestCycleGraph {
  public static void main(String args[]) {
    LongestCycleGraphSolution longestCycleGraphSolution = new LongestCycleGraphSolution();
    System.out.println(longestCycleGraphSolution.longestCycle(new int[] {2, -1, 3, 1}));
  }
}
