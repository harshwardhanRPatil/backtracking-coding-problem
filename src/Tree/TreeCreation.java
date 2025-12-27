package Tree;

/*
Inorder (Left → Root → Right):
Use when you want sorted order output from a BST or to process nodes in ascending order.

Preorder (Root → Left → Right):
Use when you want to copy/serialize a tree or process the root before children.

Postorder (Left → Right → Root):
Use when you want to delete nodes, free resources, or process children before parent.

*/

class Node {
  int value;
  int height;
  Node left;
  Node right;

  public Node(int value) {
    this.value = value;
    this.left = this.right = null;
  }

  public int getValue() {
    return this.value;
  }
}

class BST {
  Node root;

  public BST() {
    root = null;
  }

  public Node insert(Node root, int value) {
    if (root == null) {
      return new Node(value);
    }
    if (root.value > value) {
      root.left = insert(root.left, value);
    }
    if (root.value < value) {
      root.right = insert(root.right, value);
    }
    root.height = Math.max(height(root.left), height(root.right)) + 1;
    return root;
  }

  public int height(Node root) {
    if (root == null) {
      return -1;
    }
    return root.height;
  }

  public void preorder(Node root) {
    if (root == null) return;
    System.out.print(root.value + "->");
    preorder(root.left);
    preorder(root.right);
  }

  public void inorder(Node root) {
    if (root == null) return;
    System.out.print(root.value + "->"); // root first
    preorder(root.left);
    preorder(root.right);
  }

  public void postorder(Node root) {
    if (root != null) {
      postorder(root.left);
      postorder(root.right);
      System.out.print(root.value + "->");
    }
  }

  public Node deleteNode(Node root, int value) {
    if (root == null) return null;

    if (root.value == value) {
      if (root.left == null && root.right == null) {
        return null;
      }
      if (value < root.value) {
        root.left = deleteNode(root.left, value);
      } else if (value > root.value) {
        root.right = deleteNode(root.right, value);
      } else {
        if (root.left == null) {
          return root.right;
        } else if (root.right == null) {
          return root.left;
        } else {
          Node successor = findMax(root.right);
          root.value = successor.value;
          root.right = deleteNode(root.right, successor.value);
        }
      }
    }
    return root;
  }

  // root -: is use for point only as  variable
  public Node findMax(Node root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }
}

public class TreeCreation {
  public static void main(String args[]) {
    BST tree = new BST();
    int[] values = {23, 15, 14, 13, 20, 26, 24, 23, 25, 27};
    for (int val : values) {
      tree.root = tree.insert(tree.root, val);
    }

    System.out.print("Inorder Traversal: ");
    tree.inorder(tree.root);
    System.out.println();

    System.out.print("preorder Traversal: ");
    tree.preorder(tree.root);
    System.out.println();

    System.out.print("postorder Traversal: ");
    tree.postorder(tree.root);
    System.out.println();

    tree.deleteNode(tree.root, 23);
    System.out.print("Inorder Traversal after deletion: ");
    tree.inorder(tree.root);
    System.out.println();

    System.out.print("preorder Traversal after deletion: ");
    tree.preorder(tree.root);
    System.out.println();

    System.out.print("postorder Traversal after deletion: ");
    tree.postorder(tree.root);
    System.out.println();
  }
}
