package Tree;

class DepthProblemSolution {
  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null) return minDepth(root.right) + 1;

    if (root.right == null) return minDepth(root.left) + 1;
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  }
}

public class DepthProblem {
  public static void main(String[] args) {
    BST tree = new BST();
    int[] values = {4, 2, 7, 1, 3};
    for (int val : values) {
      tree.root = tree.insert(tree.root, val);
    }
    DepthProblemSolution depthProblemSolution = new DepthProblemSolution();
    depthProblemSolution.maxDepth(tree.root);
  }
}
