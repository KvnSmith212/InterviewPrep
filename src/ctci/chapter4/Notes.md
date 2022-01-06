# CTCI Chapter 4 - Trees and Graphs

Some important things to remember about trees/graphs...
1. Searching is more tricky than other structures.
2. Worst case and average case may vary wildly, and both should be considered.
3. Fluency in implementation from scratch is essential.

### Trees

A tree is a data structure of nodes where...
1. a root node exists.
2. the root node has zero or more children.
3. each child has zero or more children, and so on.

Some additional properties...
* Trees can not contain cycles.
* Nodes may or may not be ordered.
* Nodes may or may not have links back to the parent.
* A leaf node is a node with no children.

### Binary Trees

In a binary tree, a node has up to two children. 

### Binary Search Tree

A binary tree where every node must fit a specific ordering w/ respect to ordering. Note that definition w/ respect
to equality can differ, for example it may be left < n <= right, or it may be that left <= n < right.

### Balanced Trees

Balanced trees are attempts to ensure O(log(n)) insert and retrieval, by keeping the tree 'relatively' balanced. Note
that it will not be perfectly so in most cases. Examples of balanced trees are red black trees and AVL trees.

### Complete Trees

Every level of the tree is filled, from left to right. The last level may not be filled completely, so long as the
left to right rule is maintained.

### Full Trees

Every node has zero or two children.

### Perfect Trees

All interior nodes have two children, and all leaf nodes are at the same level.

### Traversals

* In Order: left, current, right
* Pre Order: current, left, right
* Post Order: left, right, current

### Binary Heaps

Binary heaps are a complete binary tree where each node is smaller (or larger) than its children. As such, the root is
the min (or max) element in the tree.

*insert* 

Insert starts at the bottom, then bubbles up the element until the correct spot in O(log(n)) time.

*extract*

Remove the top element, and relocate the last element in its place. Then bubble down that element, swapping the smaller
(or larger) element as you do so. O(log(n)) time.

### Tries

A trie is a variant of an n-ary tree in which characters are stored in each node, and each path down the tree represents
a word. * nodes, or null nodes, indicate a complete word.

* Could have anywhere from 1 through ALPHABET_SIZE + 1 children.
* Commonly used to store the english language for quick prefix lookup.
* Lookup is O(k) time, where k is the length of the string.
* Also used for lists of invalid words.

### Graphs

* Commonly represented through adjacency lists, stored in something like an array of lists.
* Also represented through adjacency matrices, NxN boolean matrix where a true value at matrix[i][j] represents an edge.
  * Can use the same algorithms as adjacency list, potentially less efficiently. 

### Graph Search

* DFS starts at a node and explores a branch completely before moving on.
* BFS starts at a node and explores its neighbors completely before moving on.
* BFS preferred for finding path b/w nodes.
* In a graph, must be sure to check for visited nodes in order to avoid cycles.
* Use a queue when implementing BFS.
* Use a stack or recursion when iterating DFS.