package ctci.chatper3.questions;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackMinTest {

    @Test
    void pop_fromEmptyStack() {
        StackMin list = new StackMin();
        assertThrows(NoSuchElementException.class, list::pop);
    }

    @Test
    void pop_fromPopulatedStack() {
        StackMin list = new StackMin();
        list.stack.addFirst(1);
        list.minimums.addFirst(1);
        list.stack.addFirst(2);
        list.minimums.addFirst(1);

        int result = list.pop();
        assertEquals(2, result);
        result = list.pop();
        assertEquals(1, result);
    }

    @Test
    void peek_fromEmptyStack() {
        StackMin list = new StackMin();
        assertThrows(NoSuchElementException.class, list::peek);
    }

    @Test
    void peek_fromPopulatedStack() {
        StackMin list = new StackMin();
        list.stack.addFirst(1);
        list.minimums.addFirst(1);
        list.stack.addFirst(2);
        list.minimums.addFirst(1);

        int result = list.peek();
        assertEquals(2, result);
        result = list.peek();
        assertEquals(2, result);
    }

    @Test
    void push() {
        StackMin list = new StackMin();
        list.push(1);
        list.push(2);

        assertEquals(2, list.stack.size());
        assertEquals(1, list.stack.get(1));
        assertEquals(2, list.stack.get(0));
    }

    @Test
    void isEmpty_isTrue() {
        StackMin list = new StackMin();
        assertTrue(list.isEmpty());
    }

    @Test
    void isEmpty_isFalse() {
        StackMin list = new StackMin();
        list.push(1);
        list.push(2);

        assertFalse(list.isEmpty());
    }
    
    @Test
    void min_fromEmptyStack() {
        StackMin list = new StackMin();
        assertThrows(NoSuchElementException.class, list::min);
    }

    @Test
    void min_fromPopulatedStack() {
        StackMin list = new StackMin();
        list.stack.addFirst(1);
        list.minimums.addFirst(1);
        list.stack.addFirst(2);
        list.minimums.addFirst(1);

        int result = list.min();
        assertEquals(1, result);

        list.stack.removeFirst();
        list.minimums.removeFirst();

        result = list.min();
        assertEquals(1, result);
    }
}