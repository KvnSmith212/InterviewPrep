package ctci.chatper3.questions;

import java.util.LinkedList;

/**
 * 3.2
 *
 * StackMin: How would you design a stack with an additional ethod min(). Min should return the minimum element, and
 * push/pop/min should all operate in O(1) time.
 *
 * Solution is to keep a separate stack for state tracking at each stage. The minimums stack will keep track of what
 * the minimum is in conjunction with items being added or removed from the primary stack.
 */
public class StackMin {
    protected LinkedList<Integer> stack = new LinkedList<>();
    protected LinkedList<Integer> minimums = new LinkedList<>();

    /**
     * Removes from the top of the stack and returns the value.
     * @return the value removed.
     */
    public Integer pop() {
        minimums.removeFirst();
        return stack.removeFirst();
    }

    /**
     * Returns from the top of the stack, but does not remove.
     * @return top of stack.
     */
    public Integer peek() {
        minimums.getFirst();
        return stack.getFirst();
    }

    /**
     * Adds to the top of the stack.
     * @param input
     */
    public void push(Integer input) {
        Integer currMin = minimums.peek();
        if (currMin == null || input < currMin) {
            minimums.addFirst(input);
        } else {
            minimums.addFirst(currMin);
        }
        stack.addFirst(input);
    }

    /**
     * @return true if empty, else false.
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * @return the minimum value in the stack.
     */
    public Integer min() {
        return minimums.getFirst();
    }
}
