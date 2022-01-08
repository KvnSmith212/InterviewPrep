# CTCI Chapter 8 - Recursion and Dynamic Programming

* Tend to follow similar problems.
* Usually built off of sub problems.

### How to Approach
* Bottom Up: Start by solving simple case, then build the solution off of the simple case.
* Top Down: Think about how the problem can be divided for case n into sub problems.
* Half and Half: Divide a data set in half and work on each half individually.

### Recursive VS Iterative
* Recursive is space inefficient, adding new layers to the stack for each call.
* All recursive algorithms have iterative solutions.

### Dynamic Programming and Memoization
* Taking a recursive problem, finding the overlapping sub problems, and caching the results.
* May also be done iteratively.

### Eg. Fibonacci Numbers
* F(n) = F(n-1) + F(n-2)
* Runtime O(2^n), can more easily be viewed if function calls drawn out as a tree.
* Cache the calls in order to reach O(n) runtime, one call per n.
* Can also be done bottom up. Compute base cases, then build on those to n for O(n) time.