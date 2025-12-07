package Tree;


import java.util.Map;

//https://leetcode.com/problems/count-good-nodes-in-binary-tree/
class CountGoodNodesBinaryTreeSolution {
    public int goodNodes(TreeNode root) {
        return helperDFS(root,root.val);
    }
    public int helperDFS(TreeNode root,int max_value){
        if(root==null){
            return 0;
        }


        return (!(root.val>=max_value)?0:1)+helperDFS(root.left, Math.max(max_value,root.val))+helperDFS(root.right, Math.max(max_value,root.val));

    }
}
public class CountGoodNodesBinaryTree {
    public static void main(String args[]){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(1);


        CountGoodNodesBinaryTreeSolution countGoodNodesBinaryTreeSolution=new CountGoodNodesBinaryTreeSolution();
    System.out.println(countGoodNodesBinaryTreeSolution.goodNodes(root));
    }
}
