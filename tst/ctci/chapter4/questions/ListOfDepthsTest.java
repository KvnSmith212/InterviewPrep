package ctci.chapter4.questions;

import ctci.chapter4.BinaryTree;
import ctci.chapter4.BinaryTreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ListOfDepthsTest {

    @Test
    void listOfDepths_emptyTree() {
        BinaryTree theTree = new BinaryTree(null);

        assertTrue(new ListOfDepths().listOfDepths(theTree).isEmpty());
    }

    @Test
    void listOfDepths_singleLevelTree() {
        BinaryTree theTree = new BinaryTree(new BinaryTreeNode(4));

        Map<Integer, List<BinaryTreeNode>> result = new ListOfDepths().listOfDepths(theTree);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(new BinaryTreeNode(4)), result.get(0));
    }

    @Test
    void listOfDepths_multiLevelTree() {
        BinaryTreeNode expected_one = new BinaryTreeNode(1);
        BinaryTreeNode expected_two = new BinaryTreeNode(2);
        BinaryTreeNode expected_three = new BinaryTreeNode(3);
        BinaryTreeNode expected_four = new BinaryTreeNode(4);
        BinaryTreeNode expected_five = new BinaryTreeNode(5);
        BinaryTreeNode expected_six = new BinaryTreeNode(6);

        expected_four.setLeft(expected_two);
        expected_four.setRight(expected_six);
        expected_two.setLeft(expected_one);
        expected_two.setRight(expected_three);
        expected_six.setLeft(expected_five);

        BinaryTree theTree = new BinaryTree(expected_four);

        Map<Integer, List<BinaryTreeNode>> result = new ListOfDepths().listOfDepths(theTree);
        assertEquals(3, result.size());
        assertEquals(Arrays.asList(new BinaryTreeNode(4)), result.get(0));
        assertEquals(Arrays.asList(
                new BinaryTreeNode(2),
                new BinaryTreeNode(6)),
                result.get(1));
        assertEquals(Arrays.asList(
                new BinaryTreeNode(1),
                new BinaryTreeNode(3),
                new BinaryTreeNode(5)),
                result.get(2));
    }
}