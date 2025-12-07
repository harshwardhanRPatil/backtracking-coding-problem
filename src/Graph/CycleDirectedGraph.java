package Graph;

import java.util.*;

class CycleDirectedGraphSolution {
  // Function to detect cycle in a directed graph.
  public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
    List<Integer> visited = new ArrayList<>(Collections.nCopies(adj.size(), 0));
    List<Integer> parent = new ArrayList<>(Collections.nCopies(adj.size(), 0));
    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    for (int i = 0; i < adj.size(); i++) {
      arr.add(new ArrayList<>());
    }
    for (int i = 0; i < adj.size(); i++) {
      if (!adj.get(i).isEmpty()) { // Ensure graph[1] is not empty
        arr.get(i).add(adj.get(i).get(0));
      }
    }
    boolean ans = false;

    for (int i = 0; i < adj.size(); i++) {
      ans = isFinder(i, visited, arr, parent,ans);
      if (ans) {
        break;
      }
    }


    return ans;
  }

  public static boolean isFinder(
      int node, List<Integer> visited, ArrayList<ArrayList<Integer>> graph, List<Integer> current,boolean ans) {
    visited.set(node, 1);
    current.set(node, 1);
    for (int i : graph.get(node)) {
//      System.out.println(i);
      if (visited.get(i) == 0) {
        ans =ans || isFinder(i, visited, graph, current,ans);
      } else if (visited.get(i) != 0 && current.get(i) == 1) {
        return true;
      }
    }
    current.set(node, 0);

    return ans;
  }
}

public class CycleDirectedGraph {
  public static void main(String args[]) {
    CycleDirectedGraphSolution cycleDirectedGraphSolution = new CycleDirectedGraphSolution();
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    //        graph.add(new ArrayList<>(Arrays.asList(1, 2)));
    //        graph.add(new ArrayList<>(Arrays.asList(2, 3)));
    //        graph.add(new ArrayList<>(Arrays.asList(1, 3)));
    //        graph.add(new ArrayList<>(Arrays.asList(2, 4)));
    //        graph.add(new ArrayList<>(Arrays.asList(1, 3)));
    //        graph.add(new ArrayList<>(Arrays.asList(3,2)));
    graph.add(new ArrayList<>(Arrays.asList(2)));
    graph.add(new ArrayList<>());
    graph.add(new ArrayList<>(Arrays.asList(0)));
    //        graph.add(new ArrayList<>(Arrays.asList(3)));
    System.out.println(cycleDirectedGraphSolution.isCyclic(graph));
  }
}
