package Tree;

//https://leetcode.com/problems/merge-two-binary-trees/
class MergeTwoBinaryTreesSolution {
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

return mergeTreesDFS(root1,root2);
  }

  public TreeNode mergeTreesDFS(TreeNode root1, TreeNode root2){

    if(root1==null && root2==null){
      return null;
    }
    int value1=root1!=null?root1.val:0;
    int value2=root2!=null?root2.val:0;
    TreeNode root=new TreeNode(value2+value1);

    root.left=mergeTrees(root1!=null?root1.left:null,root2!=null?root2.left:null);
    root.right=mergeTrees(root1!=null?root1.right:null,root2!=null?root2.right:null);
    return root;
  }
//  alter native approve and save time
public TreeNode AltermergeTreesDFS(TreeNode root1, TreeNode root2){

  if(root1==null && root2==null){
    return null;
  }
  if(root1==null) return root2;
  if(root2==null) return root1;
  TreeNode root=new TreeNode(root1.val+root2.val);

  root.left=mergeTrees(root1.left,root2.left);
  root.right=mergeTrees(root1.right,root2.right);
  return root;
}
}
public class MergeTwoBinaryTrees {
  public static void main(String args[]) {
    TreeNode root=new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(1);
    root.right.right = new TreeNode(8);


    TreeNode root2=new TreeNode(4);
    root2.left = new TreeNode(21);
    root2.right = new TreeNode(2);
    root2.left.right   = new TreeNode(3);
    root2.right.right = new TreeNode(7);

    MergeTwoBinaryTreesSolution mergeTwoBinaryTreesSolution=new MergeTwoBinaryTreesSolution();

    System.out.println(mergeTwoBinaryTreesSolution.mergeTrees(root,root2));
  }
}
