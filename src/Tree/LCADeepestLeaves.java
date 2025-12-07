package Tree;


import java.util.*;

class LCADeepestLeavesSolution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();

        Queue<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i =0;i<size;i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null)q.add(node.left);
                if(node.right != null)q.add(node.right);
            }
            levelOrder.add(list);
        }
    System.out.println(levelOrder.get(levelOrder.size()-1).toString());
        Set<Integer> lastLevel = new HashSet<>(levelOrder.get(levelOrder.size()-1));
        return lca(root,lastLevel);
    }
    private TreeNode lca(TreeNode root, Set<Integer> lastLevel){
        if(root == null || lastLevel.contains(root.val)){
            return root;
        }
        TreeNode left = lca(root.left,lastLevel);
        TreeNode right = lca(root.right,lastLevel);

        if(left == null)return right;
        if(right == null)return left;

        return root;
    }
}
public class LCADeepestLeaves {
    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        LCADeepestLeavesSolution lcaDeepestLeavesSolution=new LCADeepestLeavesSolution();
    System.out.println(lcaDeepestLeavesSolution.lcaDeepestLeaves(root).val);
    }
}
