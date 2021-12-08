# CTCI Chatper 2 - Linked Lists

Linked lists are a data structure representing a sequence of nodes. Singly linked lists have each node pointing to the
next node, while double linked lists have each node point forward and backwards.

Unlike arrays, linked lists do not provide constant time lookup as the list must be traversed entirely. One major 
benefit is that items can be added to the front of the list in constant time, and the list grows as large as it needs
to.

### The Runner Technique
The runner (or second pointer) technique is common in linked list problems. It involves iterating through the list with
two different pointers, one ahead of the other by some amount.

### Recursive Problems
Recursive solutions are common to linked list problems and should be considered often, while keeping in mind that there
is always an iterative solution to match a recursive one and recursive solutions take at least O(n) space.