package Tree;

class bstAVL {
    Node root;

    public bstAVL() {
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
        return rotateNode(root);
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

    public Node rotateNode(Node root) {
        // right heavy
        if (height(root.right) - height(root.left) > 1) {
            if (height(root.right.right) - height(root.right.left) > 0) {
                return leftrotate(root);
            }
            if (height(root.right.right) - height(root.right.left) < 0) {
                root.right = rightrotate(root.right);
                return leftrotate(root);
            }
        }
        // left heavy
        if (height(root.right) - height(root.left) < -1) {
            if (height(root.left.right) - height(root.left.left) > 0) {
                root.left = leftrotate(root.left);
                return rightrotate(root);
            }
            if (height(root.left.right) - height(root.left.left) < 0) {
                return rightrotate(root);
            }
        }
        return root;
    }

    public Node leftrotate(Node root) {
        Node temp = root.right;
        Node rightTemp = temp.left;

        temp.left = root;
        root.right = rightTemp;

        root.height = Math.max(height(root.left), height(root.right))+1;
        temp.height = Math.max(height(temp.left), height(temp.right))+1;

        return temp;
    }

    public Node rightrotate(Node root) {
        Node temp = root.left;
        Node rightTemp = temp.right;

        temp.right = root;
        root.left = rightTemp;
        root.height = Math.max(height(root.left), height(root.right))+1;
        temp.height = Math.max(height(temp.left), height(temp.right))+1;

        return temp;
    }
}

/*
AVL Tree is a self-balancing Binary Search Tree where the height difference
(balance factor) between left and right subtrees of any node is at most 1.
After insertion or deletion, the tree is rebalanced using rotations
(LL, RR, LR, RL) to maintain O(log n) search, insert, and delete time.

balanceFactor = height(left) - height(right)
AVL Tree Node: maintains height to ensure balance factor ∈ {-1, 0, 1}
 */

class AVLTreeBalance {}

public class AVLTree {
  public static void main(String[] args) {
    AVLTreeBalance avlTreeBalance = new AVLTreeBalance();
    bstAVL tree = new bstAVL();
    int[] values = {10, 30,20};
    for (int val : values) {
      tree.root = tree.insert(tree.root, val);
    }
    System.out.print("Inorder Traversal after deletion: ");
    tree.inorder(tree.root);
    System.out.println();
  }
}
