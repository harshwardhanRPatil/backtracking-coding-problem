package Graph;

//https://leetcode.com/problems/largest-color-value-in-a-directed-graph/description/

import java.util.*;

class LargestColorValueDirectedGraphSolution {
    public int largestPathValue(String colors, int[][] edges) {
        int ans=0;
        int n=colors.length();
        List<List<Integer>> arr=new ArrayList<>();
        List<Integer> depended = new ArrayList<>(Collections.nCopies(n,0));
        List<List<Integer>> current =new ArrayList<>();

//        emply alph for all egde
        for (int i = 0; i < n; i++) {
            current.add(new ArrayList<>(Collections.nCopies(26, 0)));
        }
//        make a graph fo my easy travle
        for(int i=0;i<n;i++)
        {
            arr.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int v=edges[i][0];
            int u=edges[i][1];
            arr.get(u).add(v);
            depended.set(v,depended.get(v)+1);
        }
        int process=0;
//        que for no deepnd  or can say that  don't haave any other collore to ad
        Queue<Integer> queue=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(depended.get(i)==0){
                queue.add(i);
            }
        }
//        flow that we go thore
        while (queue.size()>0){
        int f=queue.peek();
            process++;
            queue.remove();
            current.get(f).set(colors.charAt(f) - 'a', current.get(f).get(colors.charAt(f) - 'a') + 1);
            ans=Math.max(ans,current.get(f).get(colors.charAt(f) - 'a'));
            for(int i:arr.get(f)){
                if (depended.get(i)!=0){
                    depended.set(i,depended.get(i)-1);

                }
                if(depended.get(i)==0){
                    queue.add(i);
                }
                for(int j=0;j<26;j++){
                    current.get(i).set(j, Math.max(current.get(f).get(j), current.get(i).get(j)));
                }
            }
        }

        return process==n?ans:-1;
    }
}
public class LargestColorValueDirectedGraph {
    public static void main(String args[]){
        LargestColorValueDirectedGraphSolution largestColorValueDirectedGraphSolution=new LargestColorValueDirectedGraphSolution();
    System.out.println(largestColorValueDirectedGraphSolution.largestPathValue("abaca", new int[][]{{0,1},{0,2},{2,3},{3,4}}));
    }
}
