package ctci.chatper3.questions;

import java.util.ArrayList;

/**
 * 3.1 Three in One: Describe how you could use a single array to implement 3 stacks.
 *
 * One stack: First thought is, how would I implement a single stack with an array? The answer here would be to just keep an index for
 * top of the stack, incrementing the index when the stack is pushed onto and decrementing the index when the stack is
 * popped. This seems pretty simple.
 *
 * Three stacks: To go from one to three is simple, you could just break up the array into three sections based on the
 * expected sizes of the stacks.
 *
 * Shifting: To make the most out of the use of memory available within a single array, you could build off of the previous
 * ideas where the three stacks are placed next to each other within the array. To make room for one stack, the other
 * stacks may need to be shifted forward. On the other hand, when items are popped, shifted backwards. If you were in a
 * scenario where memory was truly constrained to a single small block of contiguous memory, and you didn't care about the
 * time complexity of shifting the array back and forth as the stacks grow and shrink in size, this could work to make
 * the most out of your situation. In most other situations, you would probably just want to use three separate linked
 * lists for your implementation.
 *
 * Implementation: The question wasn't really asking for an implementation, but I thought it might be fun to at least
 * do a single stack implementation backed by an array, without all the extra requirements created by a three in one
 * stack as presented by the question. For the implementation below, I'll back the stack with Java's ArrayList
 * structure so that Java handles resizing the array if required, which takes away most of the complexity of the
 * problem.
 */
public class ThreeInOne {
    // protected so integration tests can access.
    protected ArrayList<Integer> stack = new ArrayList<>();

    /**
     * Removes from the top of the stack and returns the value.
     * @return the value removed.
     */
    public Integer pop() {
        return stack.remove(stack.size()-1);
    }

    /**
     * Returns from the top of the stack, but does not remove.
     * @return top of stack.
     */
    public Integer peek() {
        return stack.get(stack.size()-1);
    }

    /**
     * Adds to the top of the stack.
     * @param input
     */
    public void push(Integer input) {
        // ArrayList add will append to the end of the list, in O(1) fashion. I believe it does this by just passing in
        // the size as the index, then increasing the size (since we are adding an item.) This is basically what we
        // would be doing here if we weren't using the arrayList add method regardless.
        stack.add(input);
    }

    /**
     * @return true if empty, else false.
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
