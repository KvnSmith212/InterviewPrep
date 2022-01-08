package ctci.chapter8.questions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TripleStepTest {

    @Test
    void tripleStepRecursive_negative() {
        assertEquals(0, TripleStep.tripleStepRecursive(-1));
    }

    @Test
    void tripleStepRecursive_zero() {
        assertEquals(1, TripleStep.tripleStepRecursive(0));
    }

    @Test
    void tripleStepRecursive_one() {
        assertEquals(1, TripleStep.tripleStepRecursive(1));
    }

    @Test
    void tripleStepRecursive_two() {
        assertEquals(2, TripleStep.tripleStepRecursive(2));
    }

    @Test
    void tripleStepRecursive_three() {
        assertEquals(4, TripleStep.tripleStepRecursive(3));
    }

    @Test
    void tripleStepRecursive_ten() {
        assertEquals(274, TripleStep.tripleStepRecursive(10));
    }

    @Test
    void tripleStepIterative_negative() {
        assertEquals(0, TripleStep.tripleStepIterative(-1));
    }

    @Test
    void tripleStepIterative_zero() {
        assertEquals(1, TripleStep.tripleStepIterative(0));
    }

    @Test
    void tripleStepIterative_one() {
        assertEquals(1, TripleStep.tripleStepIterative(1));
    }

    @Test
    void tripleStepIterative_two() {
        assertEquals(2, TripleStep.tripleStepIterative(2));
    }

    @Test
    void tripleStepIterative_three() {
        assertEquals(4, TripleStep.tripleStepIterative(3));
    }

    @Test
    void tripleStepIterative_ten() {
        assertEquals(274, TripleStep.tripleStepIterative(10));
    }
}