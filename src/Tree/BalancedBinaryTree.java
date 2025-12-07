package Tree;

import java.util.AbstractMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class BalancedBinaryTreeSolution {
    public boolean isBalanced(TreeNode root) {
        Map.Entry<Boolean, Integer> ans =height(root);
        return ans.getKey();

    }
    public Map.Entry<Boolean, Integer> height(TreeNode root){
        if(root==null){
            return new AbstractMap.SimpleEntry<>(true, 0);
        }
        Map.Entry<Boolean,Integer>left=height(root.left);
        Map.Entry<Boolean,Integer>right=height(root.right);
        boolean isBalanced = left.getKey() && right.getKey() && Math.abs(left.getValue() - right.getValue()) <= 1;
        int height = 1 + Math.max(left.getValue(), right.getValue());

        return new AbstractMap.SimpleEntry<>(isBalanced,1+Math.max(left.getValue(),right.getValue()));
    }
}
public class BalancedBinaryTree {
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BalancedBinaryTreeSolution solution = new BalancedBinaryTreeSolution();
        boolean result = solution.isBalanced(root);

        System.out.println("Is the tree balanced? " + result);
    }
}
