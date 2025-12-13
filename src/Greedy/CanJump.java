package Greedy;

//https://leetcode.com/problems/jump-game/
// ⏱ Time: O(n)
// 💾 Space: O(1)
class CanJumpSolution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(n==1) return true;
        int max_jump=nums[0];
        for(int i=1;i<n;i++){
            if(i>max_jump) return false;
            if(max_jump>=n-1){
                return true;
            }
            max_jump=Math.max(max_jump,nums[i]+i);
        }
        return false;
    }
}

public class CanJump {
    public static void main(String args[]){
CanJumpSolution canJumpSolution= new CanJumpSolution();
    System.out.println(canJumpSolution.canJump(new int[]{2,3,1,1,4}));
    }
}
