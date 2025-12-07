package Graph;

import Dynamic_Programming.HouseRobberIV;

import java.security.cert.TrustAnchor;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class FindEventualSafeStatesSolution {
  public List<Integer> eventualSafeNodes(int[][] graph) {
    List<Integer> visited = new ArrayList<>(Collections.nCopies(graph.length, 0));
    List<Integer> parent = new ArrayList<>(Collections.nCopies(graph.length, 0));
    List<Integer> holder = new ArrayList<>();
    List<Integer> edge = IntStream.range(0, graph.length).boxed().collect(Collectors.toList());
    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    for (int i = 0; i < graph.length; i++) {
      arr.add(new ArrayList<>());
    }
    for (int i = 0; i < graph.length; i++) {
      for (int num : graph[i]) {
        arr.get(i).add(num);
      }
    }
    boolean ans = false;
    for (int i = 0; i < arr.size(); i++) {
      if (!holder.contains(i)) {
        isFinder(i, visited, arr, parent, holder);
      }
    }

      List<Integer> unionList = edge.stream().filter(e->!holder.contains(e)).collect(Collectors.toList());

    return unionList;
  }

  public boolean isFinder(
      int node,
      List<Integer> visited,
      ArrayList<ArrayList<Integer>> graph,
      List<Integer> current,
      List<Integer> ans) {
    visited.set(node, 1);
    current.set(node, 1);
    ans.add(node);
    for (int i : graph.get(node)) {
      if (visited.get(i) == 0) {
        if (isFinder(i, visited, graph, current, ans)) {
          return true;
        }
      } else if (current.get(i) == 1) {
        return true;
      }
    }
    current.set(node, 0);
    ans.remove(ans.size() - 1);
    return false;
  }
}

public class FindEventualSafeStates {
  public static void main(String args[]) {
    FindEventualSafeStatesSolution findEventualSafeStatesSolution =
        new FindEventualSafeStatesSolution();
    System.out.println(
        findEventualSafeStatesSolution.eventualSafeNodes(
            new int[][] {{1, 2}, {2, 3}, {5}, {0}, {3, 5}, {}, {}}));
  }
}
