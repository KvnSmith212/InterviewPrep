package ctci.chapter2.questions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KtoLastTest {

    @Test
    public void kToLast_emptyList() {
        KtoLast inputList = new KtoLast();
        Exception thrown = assertThrows(RuntimeException.class, () -> {
            inputList.kToLast(10);
        });

        assertEquals(thrown.getMessage(), "List is empty!");
    }

    @Test
    public void kToLast_sizeLessThanK() {
        KtoLast inputList = new KtoLast();
        inputList.add(0);
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);

        Exception thrown = assertThrows(RuntimeException.class, () -> {
            inputList.kToLast(10);
        });

        assertEquals(thrown.getMessage(), "List is not K elements long!");
    }

    @Test
    public void kToLast_kIsZero() {
        KtoLast inputList = new KtoLast();
        inputList.add(0);
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);

        Integer result = inputList.kToLast(0);

        assertEquals(0, result);
    }

    @Test
    public void kToLast_kGreaterThanZero() {
        KtoLast inputList = new KtoLast();
        inputList.add(0);
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);

        Integer result = inputList.kToLast(2);

        assertEquals(2, result);
    }

    @Test
    public void kToLast_kLessThanZero() {
        KtoLast inputList = new KtoLast();

        Exception thrown = assertThrows(RuntimeException.class, () -> {
            inputList.kToLast(-10);
        });

        assertEquals(thrown.getMessage(), "Invalid input!");
    }

}