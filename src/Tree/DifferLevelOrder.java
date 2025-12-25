package Tree;

import java.util.*;

class DifferLevelOrderSolution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    // declar the linklist for the LIst<List>
    List<List<Integer>> ans = new LinkedList<>();
    // for better peposmence
    Queue<TreeNode> suffer = new ArrayDeque<>();
    if (root == null) return ans;
    suffer.add(root);

    List<Integer> temp_ans = new ArrayList<>();
    Queue<TreeNode> tempStore = new ArrayDeque<>();

    while (!suffer.isEmpty()) {
      TreeNode temp = suffer.poll();
      temp_ans.add(temp.val);
      if (temp.left != null) {
        tempStore.add(temp.left);
      }
      if (temp.right != null) {
        tempStore.add(temp.right);
      }
      if (suffer.isEmpty()) {
        ans.add(new ArrayList<>(temp_ans));
        suffer = tempStore;
        temp_ans.clear();
        tempStore = new ArrayDeque<>();
      }
    }
    return ans;
  }

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) return ans;

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      int right_ans = 0;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        right_ans = node.val;

        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }

      ans.add(right_ans); // no clearing needed
    }
    return ans;
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new LinkedList<>();
    Stack<TreeNode> queue = new Stack<>();
      if (root == null) return ans;
    queue.add(root);
    boolean right = true;

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> level = new ArrayList<>();
        Stack<TreeNode> temp = new Stack<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.pop();
        level.add(node.val);
        if (right) {
          if (node.left != null) temp.add(node.left);
          if (node.right != null) temp.add(node.right);
        } else {
          if (node.right != null) temp.add(node.right);
          if (node.left != null) temp.add(node.left);
        }
      }
      right = !right;
      ans.add(level);
      queue=temp;
    }

    return ans;
  }
}

public class DifferLevelOrder {
  public static void main(String[] args) {
    BST tree = new BST();
    int[] values = {23, 15, 14, 13, 20, 26, 24, 23, 25, 27};
    for (int val : values) {
      tree.root = tree.insert(tree.root, val);
    }
  }
}
