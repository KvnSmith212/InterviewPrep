package ctci.chapter2.questions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDupesTest {

    @Test
    public void removeDupes_emptyList() {
        RemoveDupes inputList = new RemoveDupes();
        RemoveDupes solutionList = new RemoveDupes();

        inputList.removeDupes();
        assertEquals(solutionList, inputList);
    }

    @Test
    public void removeDupes_noDuplicates() {
        RemoveDupes inputList = new RemoveDupes();
        inputList.add(0);
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);

        RemoveDupes solutionList = new RemoveDupes();
        solutionList.add(0);
        solutionList.add(1);
        solutionList.add(2);
        solutionList.add(3);

        inputList.removeDupes();
        assertEquals(solutionList, inputList);
    }

    @Test
    public void removeDupes_duplicates() {
        RemoveDupes inputList = new RemoveDupes();
        inputList.add(0);
        inputList.add(1);
        inputList.add(1);
        inputList.add(1);

        RemoveDupes solutionList = new RemoveDupes();
        solutionList.add(0);
        solutionList.add(1);

        inputList.removeDupes();
        assertEquals(solutionList, inputList);
    }

}