package Tree;

/*
 * This file contains basic tree utilities including:
 * 1. isBalanced()       - Checks if a binary tree is height-balanced.
 * 2. heightFinder()     - Helper method to calculate height and detect imbalance.
 * 3. isSymmetric()      - Checks if a binary tree is symmetric (mirror of itself).
 * 4. isSameTree()       - Checks if two binary trees are structurally identical and have the same values.
 *
 * All methods use recursion and are optimized for O(n) time complexity.
 */


class TreeBasiceCheckSolution{
    public boolean isBalanced(TreeNode root) {
        return heightfinder(root)!= -1;
    }

    public int heightfinder(TreeNode root){
        if(root==null){
            return 0;
        }

        int left=heightfinder(root.left);
        // this check if the left side is inbalacnce
        if(left==-1) return -1;
        int right=heightfinder(root.right);
        // this check if the right side is inbalacnce

        if (right==-1) return -1;

        if(Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSameTree(root.left,root.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if((p!=null && q==null) || (p==null && q!=null)){
            return false;
        }
        if(p.val==q.val){
            return isSameTree(p.left,q.right) && isSameTree(p.right,q.left);
        }
        return false;
    }
}
public class TreeBasiceCheck {
    public static void main(String[] args){

    }
}
