package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AllPathSumSolution {

  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return targetSum == root.val;
    }

    boolean left = hasPathSum(root.left, targetSum - root.val);
    boolean right = hasPathSum(root.right, targetSum - root.val);
    return left || right;
  }

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> ans = new ArrayList<>();
    pathsumFinder(root, new ArrayList<>(), ans, targetSum);
    return ans;
  }

  public void pathsumFinder(
      TreeNode root, List<Integer> temp, List<List<Integer>> ans, int targetSum) {
    if (root == null) return;
    temp.add(root.val);
    if (targetSum == root.val && (root.left == null && root.right == null)) {
      ans.add(new ArrayList<>(temp));
    } else {
      pathsumFinder(root.left, temp, ans, targetSum - root.val);
      pathsumFinder(root.right, temp, ans, targetSum - root.val);
    }
    temp.remove(temp.size() - 1);
  }

  // worst way fo writing as i check in all node and the again check the node
  public int pathSumII(TreeNode root, int targetSum) {
    List<List<Integer>> ans = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();

    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        pathsumFinderII(node, new ArrayList<>(), ans, targetSum);
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
    }
    return ans.size();
  }

  public void pathsumFinderII(
      TreeNode root, List<Integer> temp, List<List<Integer>> ans, int targetSum) {
    if (root == null) return;
    temp.add(root.val);
    if (targetSum == root.val) {
      ans.add(new ArrayList<>(temp));
    }
    pathsumFinderII(root.left, temp, ans, targetSum - root.val);
    pathsumFinderII(root.right, temp, ans, targetSum - root.val);
    temp.remove(temp.size() - 1);
  }

  // best way by sung DFS there are 2 issue i find and fix and add in commet
  /*
     // is i use the array it memero issue so i iuse the count
    //  List<List<Integer>> ans = new ArrayList<>();
    int count=0;
              public int pathSum(TreeNode root, int targetSum) {
                if(root==null) return 0;
   // there is  a bug as long will kill the code athere is a ample have 1000000000000
   pathsumFinderII(root, (long)targetSum);
   pathSum(root.left,targetSum);
   pathSum(root.right,targetSum);

       return count;
  }

  public void pathsumFinderII(
      TreeNode root, long targetSum) {
    if (root == null) return ;

    if (targetSum == root.val) {
     count++;
    }
      pathsumFinderII(root.left, targetSum - root.val);
      pathsumFinderII(root.right,  targetSum - root.val);


  }
     */

  public int sumNumbers(TreeNode root) {
    return helpersumNumbers(root, 0);
  }

  public int helpersumNumbers(TreeNode root, int sum) {
    if (root == null) return 0;

    sum = sum * 10 + root.val;
    if (root.left == null && root.right == null) {
      return sum;
    }
    return helpersumNumbers(root.left, sum) + helpersumNumbers(root.right, sum);
  }
}

public class AllPathSum {}
