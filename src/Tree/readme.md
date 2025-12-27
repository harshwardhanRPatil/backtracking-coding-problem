# 🌳 Tree Data Structure — Complete Revision Guide & Problem Patterns

This README is designed as a **one-stop revision guide** for Trees, covering **concepts, patterns, and interview question mapping**. You can use it before interviews or while practicing LeetCode.

---

## 📌 1. What is a Tree?

A **Tree** is a hierarchical data structure consisting of nodes connected by edges, forming a parent → child relationship.

### Key Properties

* One **root** node
* No cycles
* Each node has **exactly one parent** (except root)
* Nodes can have zero or more children
* Traversed using **DFS** or **BFS**

---

## 📌 2. Why Trees Are Important?

Trees appear everywhere in real systems and interviews:

* File systems
* JSON / XML
* Database indexes (B-Tree, B+ Tree)
* Compiler syntax trees (AST)
* Routing algorithms
* Organization hierarchies

In interviews, trees test:

* Recursion
* DFS / BFS
* Problem decomposition

---

## 📌 3. Types of Trees

### 🔹 Binary Tree

Each node has **at most 2 children**.

### 🔹 Binary Search Tree (BST)

* Left < Root < Right
* Inorder traversal gives sorted order

### 🔹 Complete Binary Tree

* All levels filled except last

### 🔹 Balanced Tree

* Height minimized
* Examples: **AVL, Red-Black Tree**

### 🔹 N-ary Tree

* Each node can have multiple children

### 🔹 Trie (Prefix Tree)

* Used for string storage & prefix matching

### 🔹 Segment Tree / Fenwick Tree

* Used for range queries

---

## 📌 4. Tree Terminology

| Term           | Meaning                        |
| -------------- | ------------------------------ |
| Root           | Topmost node                   |
| Leaf           | Node with no children          |
| Height         | Longest path from node to leaf |
| Depth          | Distance from root to node     |
| Subtree        | Tree inside a tree             |
| Parent / Child | Node relationships             |

---

## 📌 5. Tree Traversals

### 🔹 DFS (Depth First Search)

* Preorder: Root → Left → Right
* Inorder: Left → Root → Right
* Postorder: Left → Right → Root

### 🔹 BFS (Level Order)

* Level-by-level traversal using a queue

---

## 📌 6. How to Approach ANY Tree Problem (Framework)

### Step 1 — Identify the Pattern

Tree problems usually fall into these categories:

1️⃣ Recursion (most problems)
2️⃣ Traversal (Pre/In/Post)
3️⃣ Path-based problems
4️⃣ Subtree problems
5️⃣ DFS with return values
6️⃣ BFS / Level order
7️⃣ Tree DP

---

### Step 2 — Ask These Questions

* DFS or BFS?
* Return value depends on children?
* Need a global variable?
* Path-based or subtree-based?
* How to handle null nodes?

---

### Step 3 — Universal Templates

#### 🔥 DFS Template

```java
dfs(TreeNode root) {
    if (root == null) return ...;

    var left = dfs(root.left);
    var right = dfs(root.right);

    return combine(left, right);
}
```

#### 🔥 BFS Template

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

## 📌 7. AVL Tree (Self-Balancing BST)

### 🔹 What is an AVL Tree?

An **AVL Tree** is a self-balancing BST where:

```
|height(left) - height(right)| ≤ 1
```

### 🔹 Balance Factor

```
balanceFactor = height(left) - height(right)
```

Allowed values: **-1, 0, +1**

---

### 🔄 AVL Rotations

| Case | Pattern        | Rotation     |
| ---- | -------------- | ------------ |
| LL   | Left of Left   | Right Rotate |
| RR   | Right of Right | Left Rotate  |
| LR   | Right of Left  | Left + Right |
| RL   | Left of Right  | Right + Left |

---

## 📌 8. Tree Problem Patterns + Examples

### 🌿 A. Traversal Problems

**Pattern:** Print / Validate / Construct

Examples:

* Preorder / Inorder / Postorder
* Validate BST
* Construct tree from traversals

---

### 🌿 B. Path-Based Problems

**Pattern:** Path from root / any node

Examples:

* Path Sum I / II
* Maximum Path Sum
* Diameter of Binary Tree

---

### 🌿 C. Subtree Problems

**Pattern:** Compare two trees

Examples:

* Same Tree
* Symmetric Tree
* Subtree of Another Tree

---

### 🌿 D. DFS with Return Values

**Pattern:** Height / Boolean / Distance

Examples:

* Balanced Binary Tree
* Minimum Depth
* Count Good Nodes

---

### 🌿 E. BFS / Level Order Problems

**Pattern:** Level-wise processing

Examples:

* Level Order Traversal
* Zigzag Traversal
* Right Side View
* Average of Levels

---

### 🌿 F. LCA (Lowest Common Ancestor)

**Pattern:** Split paths

Examples:

* LCA of Binary Tree
* Distance Between Two Nodes

---

### 🌿 G. Tree DP Problems

**Pattern:** Combine left & right info

Examples:

* House Robber III
* Binary Tree Cameras
* Distribute Coins

---

## 📌 9. Common Interview Questions (Pattern-wise)

### ✅ Easy

* Maximum Depth
* Same Tree
* Symmetric Tree
* Invert Binary Tree

### ✅ Medium

* Path Sum I / II
* Right Side View
* LCA
* Validate BST

### ✅ Hard

* Maximum Path Sum
* Serialize & Deserialize
* Vertical Order Traversal
* Recover BST

---

## 📌 10. DFS vs BFS — When to Use What?

| Requirement    | Use |
| -------------- | --- |
| Level-wise     | BFS |
| Height / Depth | DFS |
| Shortest Path  | BFS |
| All Paths      | DFS |
| Subtree info   | DFS |

---

## 📌 11. Quick Formula Reference

### Height

```
height = 1 + max(left, right)
```

### Diameter

```
diameter = max(leftHeight + rightHeight, leftDiameter, rightDiameter)
```

### Balanced Tree

```
abs(leftHeight - rightHeight) ≤ 1
```

---

## 📌 12. Final Interview Tips

✔ Think recursively
✔ Solve left & right first
✔ Handle nulls carefully
✔ Use global variables when needed
✔ Draw tree if stuck

---

🎯 **Use this README as a daily revision checklist before interviews.**

If you want next:

* 📌 LeetCode problem mapping sheet
* 📌 Visual diagrams
* 📌 Tree-only interview cheat sheet PDF

Just tell me 👍
