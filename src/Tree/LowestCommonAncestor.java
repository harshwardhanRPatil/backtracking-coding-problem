package Tree;


import java.util.ArrayList;
import java.util.List;

class LowestCommonAncestorSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // find the common root foe he both if we find data on the left and right on this node
        if (left != null && right != null) return root;
        // pass the data that is we find ex if left is null and data found on right we pass right only or vis versa
        return left != null ? left : right;
    }

    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        if(root.val>p.val && root.val>q.val) return lowestCommonAncestorBST(root.left,p,q);

        if(root.val<q.val && root.val<p.val) return lowestCommonAncestorBST(root.right,p,q);

        return root;
    }
}
public class LowestCommonAncestor {
    public static void main(String[] args){

    }
}
