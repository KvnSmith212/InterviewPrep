package ctci.chapter2.questions;

import ctci.chapter2.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DeleteMiddleTest {

    @Test
    void deleteMiddle_nullInput() {
        DeleteMiddle inputList = new DeleteMiddle();

        Exception thrown = assertThrows(RuntimeException.class, () -> {
            inputList.deleteMiddle(null);
        });

        assertEquals(thrown.getMessage(), "Is is not possible to delete the given node!");
    }

    @Test
    void deleteMiddle_firstInList() {
        DeleteMiddle inputList = new DeleteMiddle();
        inputList.add(0);
        inputList.add(1);
        inputList.add(2);

        DeleteMiddle solutionList = new DeleteMiddle();
        solutionList.add(0);
        solutionList.add(1);

        SinglyLinkedList.Node firstNode = inputList.getNode(0);
        inputList.deleteMiddle(firstNode);

        assertEquals(solutionList, inputList);
    }

    @Test
    void deleteMiddle_lastInList() {
        DeleteMiddle inputList = new DeleteMiddle();
        inputList.add(0);
        inputList.add(1);
        inputList.add(2);

        SinglyLinkedList.Node lastNode = inputList.getNode(2);
        Exception thrown = assertThrows(RuntimeException.class, () -> {
            inputList.deleteMiddle(lastNode);
        });

        assertEquals(thrown.getMessage(), "Is is not possible to delete the given node!");
    }

    @Test
    void deleteMiddle_middleInList() {
        DeleteMiddle inputList = new DeleteMiddle();
        inputList.add(0);
        inputList.add(1);
        inputList.add(2);

        DeleteMiddle solutionList = new DeleteMiddle();
        solutionList.add(0);
        solutionList.add(2);

        SinglyLinkedList.Node middleNode = inputList.getNode(1);
        inputList.deleteMiddle(middleNode);

        assertEquals(solutionList, inputList);
    }
}