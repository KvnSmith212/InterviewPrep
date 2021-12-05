# CTCI Chatper 1 - Arrays and Strings

Focus is on arrays and strings, which are mostly interchangeable in terms of programming problems.

### Hash Tables

Hash tables map keys to values for highly efficient lookup.

**Implementation**

Common implementation is to maintain an array of linked lists and a hashcode function.

1. Compute hash to int or long, generally.
2. hash(key) % array_length to compute index in the array for which a key/value pair belongs.
3. Store key and value at this index.

To retrieve, simply follow the same procedure in input. Worse case O(n), but generally O(1). Alternatives to hashtable lookup might be to use a balanced binary search tree for O(logn) lookup, for potentially less space usage.

### Arraylists and Resiable Arrays

Arraylists offers an array-like data structure with dynamic resizing. Typically, when the array reaches some saturation point, the array will increase in size by some factor.

Arraylists offer amortized O(1) insertion with an O(1) lookup.

### Stringbuilder

When concatenating a list of strings, the running time of the code, assuming n strings of length x, works out to O(xn^2). Stringbuilders help to work around this limitation by managing a resizeable array of characters, only creating and returning a string when requested.