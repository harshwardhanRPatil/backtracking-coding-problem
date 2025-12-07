package Tree;


class ValidateBinarySearchTreeSolution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTDFS(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBSTDFS(TreeNode root ,long left,long right){

        if(root==null ){
            return true;
        }

        if(root.val<=left || root.val>=right){
            return false;
        }
        return isValidBSTDFS(root.left,left,root.val) && isValidBSTDFS(root.right,root.val,right);
    }
}
public class ValidateBinarySearchTree {
    public static void main(String args[]){
        TreeNode root=new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(8);
        ValidateBinarySearchTreeSolution validateBinarySearchTreeSolution=new ValidateBinarySearchTreeSolution();
    System.out.println(validateBinarySearchTreeSolution.isValidBST(root));
    }
}
