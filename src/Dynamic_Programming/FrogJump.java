package Dynamic_Programming;


import java.util.HashMap;
import java.util.Map;

class FrogJumpSolution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if(stones[1]>1){
            return false;
        }
//        need because we can only jump on a stone and not on index as now we put mapping og this
//        if store present then we use that index else we ifnore
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(stones[i],i);
        }
        return solve(stones,1,n,1,map);
    }
    private boolean solve(int[] stones, int index, int n, int k,Map<Integer,Integer> map){
        if(index==n-1){
            return true;
        }
        boolean x=false,y=false,z=false;
        if(k>1 && map.containsKey(stones[index]+k-1)){
            x = solve(stones,map.get(stones[index]+k-1),n,k-1,map);
        }
        if(map.containsKey(stones[index]+k)){
            y = solve(stones,map.get(stones[index]+k),n,k,map);
        }
        if(map.containsKey(stones[index]+k+1)){
            z = solve(stones,map.get(stones[index]+k+1),n,k+1,map);
        }
        return x||y||z;
    }
}
public class FrogJump {
    public static void main(String args[]){
        FrogJumpSolution frogJumpSolution=new FrogJumpSolution();
    System.out.println(frogJumpSolution.canCross(new int[]{0,1,3,5,6,8,12,17}));
    }
}
