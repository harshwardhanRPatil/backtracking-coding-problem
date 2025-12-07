package Graph;

//https://leetcode.com/problems/number-of-operations-to-make-network-connected/submissions/1608431036/
// space O(N)
//time O(N)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class NumberOfoperationsSolution {
    public int makeConnected(int n, int[][] connections) {

        if(connections.length<n-1) return -1;

        List<Integer> visited = new ArrayList<>(Collections.nCopies(n, 0));
        List<List<Integer>> arr=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            arr.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++)
        {
            int v=connections[i][0];
            int u=connections[i][1];
            arr.get(u).add(v);
            arr.get(v).add(u);
        }
        int ans=0;
        for (int i=0;i<n;i++){
            if(visited.get(i)==0){
                dfs(arr,visited,i);
                ans++;
            }
        }

            return  ans-1;
    }
    public void dfs(List<List<Integer>> arr ,List<Integer> visited,int src){
        visited.set(src,1);
        for(int i: arr.get(src)){
            if(visited.get(i)!=1){
                dfs(arr,visited,i);
            }
        }
    }
}
public class NumberOfoperations {}
