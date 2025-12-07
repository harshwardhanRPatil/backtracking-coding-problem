package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

class ReorderRoutesSolution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> forwordGraph =new ArrayList<>();
        List<List<Integer>> backwordGraph =new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            forwordGraph.add(new ArrayList<>());
            backwordGraph.add(new ArrayList<>());
        }
        for(int i =0;i<connections.length;i++){
            int a=connections[i][0];
            int b=connections[i][1];
            forwordGraph.get(a).add(b);
            backwordGraph.get(b).add(a);
        }
        List<Integer> visited=new ArrayList<>(Collections.nCopies(n,0));

        int counter=0;
        pathChanger(forwordGraph,backwordGraph,counter,0,visited);
        return counter;
    }
    public void pathChanger(List<List<Integer>>forwordGraph ,List<List<Integer>> backwordGraph, int counter,int node,List<Integer> visited){
        visited.set(node,1);
        for(Integer i:forwordGraph.get(node)){
            if(visited.get(i)==0){
            counter++;
            pathChanger(forwordGraph,backwordGraph,counter,i,visited);
            }
        }
        for(Integer j:backwordGraph.get(node)){
            if(visited.get(j)==0){
                pathChanger(forwordGraph,backwordGraph,counter,j,visited);
            }
        }


    }
}
public class ReorderRoutes {
    public static void main(String args[]){
        ReorderRoutesSolution reorderRoutesSolution=new ReorderRoutesSolution();
    System.out.println(reorderRoutesSolution.minReorder(6,new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));
    }
}
