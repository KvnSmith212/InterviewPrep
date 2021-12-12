package ctci.chatper3.questions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeInOneTest {

    @Test
    void pop_fromEmptyStack() {
        ThreeInOne list = new ThreeInOne();
        Exception thrown = assertThrows(IndexOutOfBoundsException.class, list::pop);

        assertEquals(thrown.getMessage(), "Index -1 out of bounds for length 0");
    }

    @Test
    void pop_fromPopulatedStack() {
        ThreeInOne list = new ThreeInOne();
        list.stack.add(0, 1);
        list.stack.add(1, 2);

        int result = list.pop();
        assertEquals(2, result);
        result = list.pop();
        assertEquals(1, result);
    }

    @Test
    void peek_fromEmptyStack() {
        ThreeInOne list = new ThreeInOne();
        Exception thrown = assertThrows(IndexOutOfBoundsException.class, list::peek);

        assertEquals(thrown.getMessage(), "Index -1 out of bounds for length 0");
    }

    @Test
    void peek_fromPopulatedStack() {
        ThreeInOne list = new ThreeInOne();
        list.stack.add(0, 1);
        list.stack.add(1, 2);

        int result = list.peek();
        assertEquals(2, result);
        result = list.peek();
        assertEquals(2, result);
    }

    @Test
    void push() {
        ThreeInOne list = new ThreeInOne();
        list.push(1);
        list.push(2);

        assertEquals(2, list.stack.size());
        assertEquals(1, list.stack.get(0));
        assertEquals(2, list.stack.get(1));
    }

    @Test
    void isEmpty_isTrue() {
        ThreeInOne list = new ThreeInOne();
        assertTrue(list.isEmpty());
    }

    @Test
    void isEmpty_isFalse() {
        ThreeInOne list = new ThreeInOne();
        list.push(1);
        list.push(2);

        assertFalse(list.isEmpty());
    }
}