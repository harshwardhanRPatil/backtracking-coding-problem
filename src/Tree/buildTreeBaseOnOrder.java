package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class buildTreeBaseOnOrderSolution {
  int index = 0;
  List<Integer> ans = new ArrayList<>();
  int pointer = 0;
  Map<Integer, Integer> inorderIndex = new HashMap<>();
  TreeNode first = null;
  TreeNode second = null;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0) return null;

    for (int i = 0; i < inorder.length; i++) {
      inorderIndex.put(inorder[i], i);
    }
    return helper(preorder, inorder, 0, inorder.length - 1);
  }

  public TreeNode helper(int[] preorder, int[] inorder, int lowest, int highest) {
    if (lowest > highest) return null;
    TreeNode root = new TreeNode(preorder[index]);
    int mid = inorderIndex.get(preorder[index]);
    index++;
    root.left = helper(preorder, inorder, lowest, mid - 1);
    root.right = helper(preorder, inorder, mid + 1, highest);
    return root;
  }

  public TreeNode bstFromPreorder(int[] preorder) {
    TreeNode root = null;
    for (int i = 0; i < preorder.length; i++) {
      root = insert(root, preorder[i]);
    }
    return root;
  }

  public int finder(int[] inorder, int value) {
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == value) {
        return i;
      }
    }
    return 0;
  }

  public TreeNode buildTreeII(int[] inorder, int[] postorder) {
    if (postorder.length == 0) return null;

    for (int i = 0; i < inorder.length; i++) {
      inorderIndex.put(inorder[i], i);
    }
    index = postorder.length - 1;
    return helper(postorder, inorder, 0, inorder.length - 1);
  }

  public TreeNode helperII(int[] preorder, int[] inorder, int lowest, int highest) {
    if (lowest > highest) return null;
    TreeNode root = new TreeNode(preorder[index]);
    int mid = inorderIndex.get(preorder[index]);
    index--;
    root.right = helper(preorder, inorder, mid + 1, highest);
    root.left = helper(preorder, inorder, lowest, mid - 1);

    return root;
  }

  // NOte we can use the strringbuef for the better time complecisty
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    preorder(root);
    System.out.println(ans.toString());
    return ans.toString();
  }

  public void preorder(TreeNode root) {
    if (root != null) {
      ans.add(root.val);
      preorder(root.left);
      preorder(root.right);
    }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    TreeNode root = null;
    data = data.substring(1, data.length() - 1); // remove [ ]

    if (data.length() == 0) return null;

    String[] values = data.split(",");

    for (String val : values) {
      int num = Integer.parseInt(val.trim());
      root = insert(root, num);
    }
    return root;
  }

  public TreeNode insert(TreeNode root, int value) {
    if (root == null) {
      return new TreeNode(value);
    }
    if (root.val > value) {
      root.left = insert(root.left, value);
    }
    if (root.val < value) {
      root.right = insert(root.right, value);
    }
    return root;
  }

  // hard que beacuse we ar doin it on the binary tree and not on the bst
  public String serializeII(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    preorderII(root, sb);
    if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  private void preorderII(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append("null").append(",");
      return;
    }
    sb.append(root.val).append(",");
    preorderII(root.left, sb);
    preorderII(root.right, sb);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserializeII(String data) {
    TreeNode root = null;
    if (data == null || data.length() == 0) return null;
    String[] values = data.split(",");
    root = insertII(root, values);
    return root;
  }

  public TreeNode insertII(TreeNode root, String[] value) {
    if (pointer >= value.length || value[pointer].equals("null")) {
      pointer++;
      return null;
    }

    root = new TreeNode(Integer.parseInt(value[pointer]));
    root.left = insertII(root.left, value);
    root.right = insertII(root.right, value);

    return root;
  }

  public void recoverTree(TreeNode root) {
    fallfounder(root, new TreeNode(Integer.MIN_VALUE),new TreeNode(Integer.MAX_VALUE));
    int temp = first.val;
    first.val = second.val;
    second.val = temp;

  }

  public boolean fallfounder(TreeNode root, TreeNode min_value, TreeNode max_value) {
    if (root == null) return true;

    if (root.val < min_value.val) {
      first = min_value;
      second = root;
      return false;
    }

    if (root.val > max_value.val) {
      first = max_value;
      second = root;
      return false;
    }
    return fallfounder(root.left, min_value, root)
        || fallfounder(root.right, root, max_value);
  }
}

public class buildTreeBaseOnOrder {}
