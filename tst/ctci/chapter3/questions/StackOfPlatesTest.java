package ctci.chapter3.questions;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class StackOfPlatesTest {

    @Test
    void push_singleStack() {
        StackOfPlates stackOfPlates = new StackOfPlates(3);
        stackOfPlates.push(3);
        stackOfPlates.push(2);

        assertEquals(1, stackOfPlates.setOfStacks.size());
        assertEquals(2, stackOfPlates.setOfStacks.get(0).pop());
        assertEquals(3, stackOfPlates.setOfStacks.get(0).pop());
    }

    @Test
    void push_multiStack() {
        StackOfPlates stackOfPlates = new StackOfPlates(3);
        stackOfPlates.push(3);
        stackOfPlates.push(2);
        stackOfPlates.push(1);
        stackOfPlates.push(0);
        stackOfPlates.push(-1);


        assertEquals(2, stackOfPlates.setOfStacks.size());
        assertEquals(1, stackOfPlates.setOfStacks.get(0).pop());
        assertEquals(2, stackOfPlates.setOfStacks.get(0).pop());
        assertEquals(3, stackOfPlates.setOfStacks.get(0).pop());
        assertEquals(-1, stackOfPlates.setOfStacks.get(1).pop());
        assertEquals(0, stackOfPlates.setOfStacks.get(1).pop());
    }

    @Test
    void pop_singleStack() {
        StackOfPlates stackOfPlates = new StackOfPlates(3);
        Stack<Integer> inner = new Stack();
        inner.push(3);
        inner.push(2);
        inner.push(1);
        stackOfPlates.setOfStacks.add(inner);

        assertEquals(1, stackOfPlates.pop());
        assertEquals(2, stackOfPlates.pop());
        assertEquals(3, stackOfPlates.pop());
        assertTrue(stackOfPlates.isEmpty());
    }

    @Test
    void pop_multiStack() {
        StackOfPlates stackOfPlates = new StackOfPlates(3);
        Stack<Integer> inner = new Stack();
        inner.push(3);
        inner.push(2);
        inner.push(1);
        Stack<Integer> innerTwo = new Stack();
        inner.push(0);
        inner.push(-1);
        stackOfPlates.setOfStacks.add(inner);
        stackOfPlates.setOfStacks.add(innerTwo);

        assertEquals(-1, stackOfPlates.pop());
        assertEquals(0, stackOfPlates.pop());
        assertEquals(1, stackOfPlates.pop());
        assertEquals(2, stackOfPlates.pop());
        assertEquals(3, stackOfPlates.pop());
        assertTrue(stackOfPlates.isEmpty());
    }

    @Test
    void pop_emptyStack() {
        StackOfPlates stackOfPlates = new StackOfPlates(3);
        assertThrows(IndexOutOfBoundsException.class, stackOfPlates::pop);
    }

    @Test
    void popAt_populatedStacks() {
        StackOfPlates stackOfPlates = new StackOfPlates(3);
        Stack<Integer> inner = new Stack();
        inner.push(3);
        inner.push(2);
        inner.push(1);
        Stack<Integer> innerTwo = new Stack();
        innerTwo.push(0);
        innerTwo.push(-1);
        stackOfPlates.setOfStacks.add(inner);
        stackOfPlates.setOfStacks.add(innerTwo);

        assertEquals(-1, stackOfPlates.popAt(1));
        assertEquals(0, stackOfPlates.popAt(1));
        assertEquals(1, stackOfPlates.popAt(0));
        assertEquals(2, stackOfPlates.popAt(0));
        assertEquals(3, stackOfPlates.popAt(0));
        assertFalse(stackOfPlates.isEmpty());
    }

    @Test
    void popAt_emptySet() {
        StackOfPlates stackOfPlates = new StackOfPlates(3);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            stackOfPlates.popAt(0);
        });
    }

    @Test
    void peek() {
        StackOfPlates stackOfPlates = new StackOfPlates(3);
        Stack<Integer> inner = new Stack();
        inner.push(3);
        inner.push(2);
        inner.push(1);
        Stack<Integer> innerTwo = new Stack();
        inner.push(0);
        inner.push(-1);
        stackOfPlates.setOfStacks.add(inner);
        stackOfPlates.setOfStacks.add(innerTwo);

        assertEquals(-1, stackOfPlates.peek());
    }
}