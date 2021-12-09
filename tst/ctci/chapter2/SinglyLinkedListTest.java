package ctci.chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void add_fromEmptyList() {
        SinglyLinkedList testList = new SinglyLinkedList();
        testList.add(1);

        assertEquals(1, testList.getHead().data);
    }

    @Test
    void add_fromPopulatedList() {
        SinglyLinkedList testList = new SinglyLinkedList();
        testList.add(1);
        testList.add(2);

        assertEquals(2, testList.getHead().data);
    }

    @Test
    void get_fromEmptyList() {
        SinglyLinkedList testList = new SinglyLinkedList();

        Exception thrown = assertThrows(RuntimeException.class, () -> {
            testList.get(0);
        });

        assertEquals(thrown.getMessage(), "Index is out of bounds!");
    }

    @Test
    void get_indexOutOfBounds() {
        SinglyLinkedList testList = new SinglyLinkedList();
        testList.add(1);
        testList.add(2);

        Exception thrown = assertThrows(RuntimeException.class, () -> {
            testList.get(5);
        });

        assertEquals(thrown.getMessage(), "Index is out of bounds!");
    }

    @Test
    void get_firstItem() {
        SinglyLinkedList testList = new SinglyLinkedList();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);

        assertEquals(5, testList.get(0));
    }

    @Test
    void get_lastItem() {
        SinglyLinkedList testList = new SinglyLinkedList();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);

        assertEquals(1, testList.get(4));
    }

    @Test
    void get_middleItem() {
        SinglyLinkedList testList = new SinglyLinkedList();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);

        assertEquals(3, testList.get(2));
    }

    @Test
    void testEquals_emptyList() {
        SinglyLinkedList testListOne = new SinglyLinkedList();
        SinglyLinkedList testListTwo = new SinglyLinkedList();

        assertEquals(testListOne, testListTwo);
    }

    @Test
    void testEquals_populatedList_isEqual() {
        SinglyLinkedList testListOne = new SinglyLinkedList();
        testListOne.add(1);
        testListOne.add(2);
        SinglyLinkedList testListTwo = new SinglyLinkedList();
        testListTwo.add(1);
        testListTwo.add(2);

        assertEquals(testListOne, testListTwo);
    }

    @Test
    void testEquals_populatedList_isNotEqual() {
        SinglyLinkedList testListOne = new SinglyLinkedList();
        testListOne.add(1);
        testListOne.add(2);
        SinglyLinkedList testListTwo = new SinglyLinkedList();
        testListTwo.add(3);
        testListTwo.add(4);

        assertNotEquals(testListOne, testListTwo);
    }

    @Test
    void testEquals_emptyAndPopulated_isNotEqual() {
        SinglyLinkedList testListOne = new SinglyLinkedList();
        testListOne.add(1);
        testListOne.add(2);
        SinglyLinkedList testListTwo = new SinglyLinkedList();

        assertNotEquals(testListOne, testListTwo);
        assertNotEquals(testListTwo, testListOne);
    }

    @Test
    void getHead_emptyList() {
        SinglyLinkedList testList = new SinglyLinkedList();

        assertNull(testList.getHead());
    }

    @Test
    void getHead_populatedList() {
        SinglyLinkedList testList = new SinglyLinkedList();
        testList.add(1);
        testList.add(2);

        assertEquals(2, testList.getHead().data);
    }
}