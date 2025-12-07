
---

# 🌳 **Tree Data Structure — Complete Guide**

## 📌 **1. What is a Tree?**

A **Tree** is a hierarchical data structure consisting of nodes connected by edges.
It represents relationships in a **parent → child** structure.

### Key Properties:

* One root node (topmost)
* No cycles
* Every node except root has exactly one parent
* Nodes may have zero or more children
* Traversed using DFS or BFS

---

## 📌 **2. Why Trees Are Important?**

Trees appear everywhere in real-world systems and coding interviews:

* Filesystem structure
* JSON/XML structures
* Database indexes (B-Trees)
* Routing tables
* Organization charts
* Compiler parsing (AST)

In interviews, they are used to test **recursion, DFS, BFS, and problem decomposition**.

---

## 📌 **3. Types of Trees**

### 🔹 **Binary Tree**

Each node has **at most 2 children** (left & right).
Used for most interview questions.

### 🔹 **Binary Search Tree (BST)**

Special binary tree where:

```
Left < Root < Right
```

Used for fast search.

### 🔹 **Complete Binary Tree**

All levels are filled except the last.

### 🔹 **Balanced Tree**

Height is minimized (like AVL, Red-Black).

### 🔹 **N-ary Tree**

Nodes can have **any number of children**.

### 🔹 **Trie (Prefix Tree)**

Used to store strings efficiently.

### 🔹 **Segment Tree / Fenwick Tree**

Used for range queries.

---

# 📌 **4. Basic Tree Terminology**

| Term           | Meaning                       |
| -------------- | ----------------------------- |
| Root           | Topmost node                  |
| Leaf           | Node with no children         |
| Height         | Longest path from node → leaf |
| Depth          | Distance from root → node     |
| Subtree        | A smaller tree inside a tree  |
| Parent / Child | Relationship between nodes    |

---

# 📌 **5. Tree Traversals**

### 🔹 DFS (Depth First Search)

1. Preorder (Root, Left, Right)
2. Inorder (Left, Root, Right)
3. Postorder (Left, Right, Root)

### 🔹 BFS (Level Order)

Visit level by level using a queue.

---

# 📌 **6. 🧠 How to Approach ANY Tree Problem (Framework)**

Use this systematic approach:

---

## **Step 1 — Identify the Pattern**

Tree problems usually fall into one of these categories:

### 🌿 **1. Recursion (most problems)**

Use DFS with a recursive helper function.

### 🌿 **2. Tree Traversal (Pre/In/Post)**

Used for printing or reconstructing trees.

### 🌿 **3. Path Problems**

Longest path, sum path, root-to-leaf checks.

### 🌿 **4. Subtree Problems**

Check if one tree is inside another.

### 🌿 **5. DFS with Return Values**

Distance, height, boolean conditions.

### 🌿 **6. BFS Level Order**

Zigzag levels, averages, connect siblings.

---

## **Step 2 — Ask These Questions**

☑ Do I need DFS or BFS?
☑ Does the return value depend on children?
☑ Do I need a global variable?
☑ Is it a path-based or subtree-based problem?
☑ Do I need to consider null nodes?

---

## **Step 3 — Write a Small Recursive Template**

### 🔥 **Universal DFS Template**

```java
dfs(TreeNode root) {
    if (root == null) return ...;

    // left subtree result
    var left = dfs(root.left);

    // right subtree result
    var right = dfs(root.right);

    // combine and return
}
```

### 🔥 **Universal BFS Template**

```java
Queue<TreeNode> q = new LinkedList<>();
q.add(root);

while (!q.isEmpty()) {
    int size = q.size();
    for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        if (node.left != null) q.add(node.left);
        if (node.right != null) q.add(node.right);
    }
}
```

---

# 📌 **7. Common Tree Problem Patterns**

Below are the **most important categories** with examples.

---

## 🌲 **A. Path-Based Problems**

* Path sum
* Diameter of tree
* Maximum path sum
* Root-to-leaf paths
* Count good nodes

These use DFS and return something like height or sum.

---

## 🌲 **B. Traversal Problems**

* Preorder, inorder, postorder
* Validate BST
* Reconstruct tree from orders

---

## 🌲 **C. Lowest Common Ancestor (LCA)**

Used when finding:

* distance between nodes
* common parent
* paths

---

## 🌲 **D. Subtree Problems**

* Same tree
* Symmetric tree
* Subtree of another tree

---

## 🌲 **E. Level Order (BFS) Problems**

* Zigzag level traversal
* Right side view
* Average of levels
* Connect siblings in same level

---

## 🌲 **F. Tree DP Problems**

* House robber 3
* Distribute coins
* Cameras in binary tree

These require combining left and right subtree information.

---

# 📌 **8. Important Tree Problems (Google/Amazon Top Questions)**

### ✅ Easy

* Maximum depth of binary tree
* Balanced binary tree
* Symmetric tree
* Same tree

### ✅ Medium

* Path sum I, II
* Binary tree right side view
* LCA of binary tree
* Validate BST
* Construct BT from preorder+inorder

### ✅ Hard

* Binary tree maximum path sum
* Serialize & Deserialize binary tree
* Count complete tree nodes
* Vertical order traversal
* Recover BST

---

# 📌 **9. When to Use DFS vs BFS?**

| Use Case                         | Choose |
| -------------------------------- | ------ |
| Need levels                      | BFS    |
| Need depth/height                | DFS    |
| Return value depends on children | DFS    |
| Find shortest path               | BFS    |
| Find all paths                   | DFS    |

---

# 📌 **10. Tips & Tricks**

### ✔ Use recursion unless BFS is required

### ✔ Think in **subproblems** — solve left & right

### ✔ Carefully handle **null nodes**

### ✔ Many problems require a **global variable**

### ✔ Draw the tree if confused

---

# 📌 **11. Mini Reference: Tree Problem Formula**

### **Height of tree**

```
height = 1 + max(height(left), height(right))
```

### **Diameter**

```
diameter = max(
  leftHeight + rightHeight,
  leftDiameter,
  rightDiameter
)
```

### **Is Balanced**

```
height difference <= 1 for all nodes
```

---

# 🎉 **This document is perfect for a README.md!**

If you'd like, I can also generate:

📌 Visual diagrams
📌 Example code snippets
📌 Practice problem list (with LeetCode links)
📌 A full "Tree Cheatsheet" PDF

Just tell me **"add diagrams"** or **"make cheat sheet"**.
