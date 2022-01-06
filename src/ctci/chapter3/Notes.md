# CTCI Chapter 3 - Stacks and Queues

### Stacks
Uses last in first out ordering (LIFO), and generally implemented with a linked list. 
* pop removes from top of stack
* push places on top of stack
* peek returns top of stack
* isEmpty returns if the stack is empty.

Stacks offer constant time for adds and removes. They are often used for recursive algorithms, pushing data as you 
recurse and popping as you backtrack. Also often handy for implementing recursive algorithms iteratively.

### Queues
Uses first in first out ordering (FIFO), also can be implemented with a linked list.
* add places to end of the queue.
* remove removes from the front of the queue.
* peek returns from the front of the queue.

Queues are often used in breadth first search or caching problems.