package ctci.chapter3.questions;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 3.3 Implement a data structure that would start a new stack every time some defined threshold is reached. The data
 * structure should hold each stack in memory.
 *
 * FOLLOW UP: Implement a function popAt(int index) which performs a pop operation on a specific sub stack.
 */
public class StackOfPlates {

    private int max;

    // Use an array list for O(1) lookup on stack index.
    protected ArrayList<Stack<Integer>> setOfStacks = new ArrayList<>();

    /**
     * Instantiates a stack of plates. Max size is the largest a stack can grow before a new stack must begin.
     * @param max
     */
    public StackOfPlates(int max) {
        this.max = max;
    }

    /**
     * Push the item onto the current stack.
     * @param item
     */
    public void push(int item) {
        getCurrentStack().push(item);
    }

    /**
     * Pop the item off of the current stack. If the current stack is empty after pop, remove it from the set.
     * @return the item on top of the stack.
     */
    public Integer pop() {
        if (getCurrentStack().isEmpty()) {
            setOfStacks.remove(setOfStacks.size()-1);
        }

        int result = setOfStacks.get(setOfStacks.size()-1).pop();
        if (setOfStacks.get(setOfStacks.size()-1).isEmpty()) {
            setOfStacks.remove(setOfStacks.size()-1);
        }

        return result;
    }

    /**
     * Pops from a specific stack from the set. If stack is empty, leave it to be cleaned up by regular pop() method.
     * @param stackIndex
     * @return the item on top of the specified stack.
     */
    public Integer popAt(int stackIndex) {
        return setOfStacks.get(stackIndex).pop();
    }

    /**
     * @return the top of the current stack.
     */
    public Integer peek() {
        if (getCurrentStack().isEmpty()) {
            setOfStacks.remove(setOfStacks.size()-1);
        }

        return setOfStacks.get(setOfStacks.size()-1).peek();
    }

    /**
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return setOfStacks.isEmpty();
    }

    // Returns the current stack, creating one if one is not available or max size is reached. When using this method,
    // care must be taken during pop functions not to pop from empty stack if there is a max size stack to pop from.
    private Stack<Integer> getCurrentStack() {
        if (setOfStacks.isEmpty() || setOfStacks.get(setOfStacks.size()-1).size() >= max) {
            setOfStacks.add(new Stack<>());
        }

        return setOfStacks.get(setOfStacks.size()-1);
    }
}
