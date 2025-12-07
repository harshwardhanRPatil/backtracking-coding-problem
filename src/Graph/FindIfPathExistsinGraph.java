package Graph;

import java.util.*;

class FindIfPathExistsinGraphSolution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> arr=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            arr.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            arr.get(u).add(v);
            arr.get(v).add(u);
        }
    List<Integer> visited = new ArrayList<>(Collections.nCopies(n,0));

//        dfs(visited,arr,source);
        bfs(visited,arr,source);
        return visited.get(destination)==1;
    }
    public void dfs(List<Integer> visited,List<List<Integer>> graph,int node ){
        visited.set(node,1);
        for (Integer i:graph.get(node)){
            if(visited.get(i)==0){
//                visited.set(i,1);
                dfs(visited,graph,i);
            }
        }
    }

   public  void bfs(List<Integer> visited,List<List<Integer>> graph,int node ){
        Queue<Integer> queue=new ArrayDeque<>();
        queue.add(node);
        visited.set(node,1);
        while (queue.size()!=0){
            for(int i:graph.get(queue.peek())){
                if (visited.get(i)==0){
                    visited.set(i,1);
                    queue.add(i);
                }
            }
            queue.remove();
        }
    }
}
public class FindIfPathExistsinGraph {

    public static void main(String args []){
        FindIfPathExistsinGraphSolution findIfPathExistsinGraphSolution=new FindIfPathExistsinGraphSolution();
    System.out.println(findIfPathExistsinGraphSolution.validPath(4,new int[][]{{0,1},{1,3},{3,2}} ,0,2));

    }
}
