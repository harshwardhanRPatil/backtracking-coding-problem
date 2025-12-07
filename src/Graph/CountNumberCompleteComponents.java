package Graph;

import java.util.*;

// https://leetcode.com/problems/count-the-number-of-complete-components/?envType=daily-question&envId=2025-03-22

//NOte -> cycle logic will not work we need to add the extra steps for counting the edge as it will we node -1==edge the we add to result
class CountNumberCompleteComponentsSolution {
  public int countCompleteComponents(int n, int[][] edges) {
    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      arr.add(new ArrayList<>());
    }
    for (int i = 0; i < edges.length; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      arr.get(u).add(v);
      arr.get(v).add(u);
    }
    int ans = 0;
    Set<Integer> visited = new HashSet<>();
    List<Integer> holder = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (!visited.contains(i)) {
        List<Integer> temp = isFinder(i, visited, arr, -1, new ArrayList<>());
        boolean flag=true;
        for (int j : temp) {
          if (temp.size() - 1 != arr.get(j).size()) {
            flag=false;
            break;
          }
        }
        if(flag){
            ans++;
        }
      }
    }
    return ans;
  }

  public static List<Integer> isFinder(
      int node,
      Set<Integer> visited,
      ArrayList<ArrayList<Integer>> graph,
      int parent,
      List<Integer> holder) {

      if(visited.contains(node)){
          return holder;
      }
    visited.add(node);
    holder.add(node);

    for (int i : graph.get(node)) {
        isFinder(i, visited, graph, node, holder);
    }
    return holder;
  }
}

public class CountNumberCompleteComponents {
  public static void main(String args[]) {
    CountNumberCompleteComponentsSolution countNumberCompleteComponentsSolution =
        new CountNumberCompleteComponentsSolution();
    System.out.println(
        countNumberCompleteComponentsSolution.countCompleteComponents(
            6, new int[][] {{0, 1}, {0, 2}, {1, 2}, {3, 4}}));
    System.out.println(
        countNumberCompleteComponentsSolution.countCompleteComponents(
            6, new int[][] {{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}}));
  }
}
