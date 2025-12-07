package Tree;

// https://leetcode.com/problems/invert-binary-tree/
class InvertBinaryTreeSolution {
    public TreeNode invertTree(TreeNode root) {
return invertTreeDFS(root);
    }
    public TreeNode invertTreeDFS(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTreeDFS(root.left);
invertTreeDFS(root.right);
        return root;
    }
}
public class InvertBinaryTree {
    public static void main(String args[]){
        TreeNode root=new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(8);
        root.right.left = new TreeNode(6);

        InvertBinaryTreeSolution invertBinaryTreeSolution=new InvertBinaryTreeSolution();
    System.out.println(invertBinaryTreeSolution.invertTree(root).toString());
    }
}
