

# 🔍 Binary Search Guide

## 1. Standard Binary Search (on a sorted array)

* **When to use**: Array is sorted (or can be sorted).
* **Goal**: Find element, lower bound, or upper bound.
* **Example**: Find first occurrence of `x` in sorted array.

```java
int low = 0, high = n-1;
while (low <= high) {
    int mid = low + (high - low) / 2;
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) low = mid + 1;
    else high = mid - 1;
}
```

---

## 2. Binary Search on Answer (BS on solution space)

* **When to use**:

  * Problem asks **“minimize the maximum”** or **“maximize the minimum”**.
  * Answer lies in a **range**, not directly in the array.
  * Feasibility check is **monotonic** → if it works for `x`, it works for all bigger (or smaller) values.
* **Goal**: Find smallest/largest feasible value.
* **Common Problems**:

  * 🐄 Aggressive Cows → maximize minimum distance
  * 📦 Split Array Largest Sum → minimize maximum subarray sum
  * 🌸 Min Days to Make Bouquets → minimize maximum days

```java
int low = minPossible, high = maxPossible, ans = -1;
while (low <= high) {
    int mid = low + (high - low) / 2;
    if (feasible(mid)) {
        ans = mid;      // store answer
        high = mid - 1; // or low = mid + 1 depending on min/max
    } else {
        low = mid + 1;  // or high = mid - 1
    }
}
return ans;
```

---

## 3. Binary Search with Precision (Real numbers)

* **When to use**: Answer is not integer (e.g., square root, ratios, probabilities).
* **Goal**: Approximate to required precision.
* **Example**: Find square root up to 6 decimal places.

```java
double low = 0, high = x;
for (int i = 0; i < 100; i++) { // precision loop
    double mid = (low + high) / 2;
    if (mid * mid <= x) low = mid;
    else high = mid;
}
```

---

## ✅ Quick Checklist (Does this problem need BS?)

* Is the **search space sorted or monotonic**?
* Are we asked for **min of max** or **max of min**?
* Is the answer a **number in a range**, not an index?
* Can we write a **feasibility function** (`can(mid)`)?

👉 If yes → use **Binary Search on Answer**.

---

