package Tree;

class ValidateBinarySearchTreeSolution {
//      public boolean isValidBST(TreeNode root) {
//          return isValidBSTDFS(root,Long.MIN_VALUE,Long.MAX_VALUE);
//      }
//
//      public boolean isValidBSTDFS(TreeNode root ,long left,long right){
//
//          if(root==null ){
//              return true;
//          }
//          if(root.val<=left || root.val>=right){
//              return false;
//          }
//          return isValidBSTDFS(root.left,left,root.val) &&
//   isValidBSTDFS(root.right,root.val,right);
//      }
  public boolean isValidBST(TreeNode root) {
     return validationBST(root,Long.MAX_VALUE,Long.MIN_VALUE);
  }

  public boolean validationBST(TreeNode root, long max_value, long min_value){
      if(root==null) return true;
      if((root.right ==null || (root.right.val<max_value && root.right.val>root.val)) &&
              (root.left==null || (root.left.val>min_value && root.left.val<root.val))){
          boolean left =validationBST(root.left,root.val,min_value);
          boolean right =validationBST(root.right,max_value,root.val);
          return left && right;
      }else{
          return false;
      }
  }
}

public class ValidateBinarySearchTree {
  public static void main(String args[]) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(1);
    root.right.right = new TreeNode(8);
    ValidateBinarySearchTreeSolution validateBinarySearchTreeSolution =
        new ValidateBinarySearchTreeSolution();
    System.out.println(validateBinarySearchTreeSolution.isValidBST(root));
  }
}
