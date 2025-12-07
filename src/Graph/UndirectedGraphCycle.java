package Graph;

import java.beans.Visibility;
import java.util.*;

class UndirectedGraphCycleSolution {
  // Function to detect cycle in an undirected graph.
  public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
    //    System.out.println(adj.toString());
    List<Integer> visited = new ArrayList<>(Collections.nCopies(adj.size(), 0));
    boolean ans = false;
    for (int i = 0; i < adj.size(); i++) {
      ans = isFinder(i, visited, adj, -1);
      Collections.fill(visited, 0);
      if (ans) {
        break;
      }
    }
      List<Integer> parent=new ArrayList<>(Collections.nCopies(adj.size(),-1));
    System.out.println(isFinderBFS(0,visited,adj,parent));
    return ans;
  }

  public static boolean isFinder(
      int node, List<Integer> visited, ArrayList<ArrayList<Integer>> graph, int parent) {
    visited.set(node, 1);

    for (int i : graph.get(node)) {
      if (visited.get(i) == 0) {
        isFinder(i, visited, graph, node);
      } else if (visited.get(i) != 0 && i != parent) {
        return true;
      }
    }
    return false;
  }

  public static boolean isFinderBFS(
      int node,
      List<Integer> visibility,
      ArrayList<ArrayList<Integer>> graph,
      List<Integer> paretnt) {
    Queue<Integer> queue = new ArrayDeque<>();

    queue.add(node);
    visibility.set(node, 1);
    while (queue.size() > 0) {
      int f = queue.peek();
      queue.remove();
      for (int note : graph.get(f)) {
        if (visibility.get(note) == 0) {
          queue.add(note);
          paretnt.set(note, f);
          visibility.set(note, 1);
        } else if (visibility.get(note) == 1 && paretnt.get(note) != f) {
          return true;
        }
      }
    }
    return false;
  }
}

public class UndirectedGraphCycle {
  public static void main(String args[]) {
    UndirectedGraphCycleSolution undirectedGraphCycleSolution = new UndirectedGraphCycleSolution();
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    graph.add(new ArrayList<>(Arrays.asList(1, 2)));
    graph.add(new ArrayList<>(Arrays.asList(2, 3)));
    graph.add(new ArrayList<>(Arrays.asList(1, 3)));
    graph.add(new ArrayList<>(Arrays.asList(2, 4)));
    graph.add(new ArrayList<>(Arrays.asList(1, 3)));
    System.out.println(undirectedGraphCycleSolution.isCycle(graph));
  }
}
