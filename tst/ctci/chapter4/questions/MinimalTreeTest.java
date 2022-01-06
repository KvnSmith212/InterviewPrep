package ctci.chapter4.questions;

import ctci.chapter4.BinaryTree;
import ctci.chapter4.BinaryTreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimalTreeTest {

    @Test
    public void buildTree_emptyArray() {
        MinimalTree minimalTree = new MinimalTree();
        minimalTree.buildMinimalTree(new int[]{});

        BinaryTree expected = new BinaryTree(null);
        assertEquals(minimalTree, expected);
    }

    @Test
    public void buildTree_singleItemArray() {
        MinimalTree minimalTree = new MinimalTree();
        minimalTree.buildMinimalTree(new int[]{4});

        BinaryTree expected = new BinaryTree(new BinaryTreeNode(4));
        assertEquals(minimalTree, expected);
    }

    @Test
    public void buildTree_evenLength() {
        MinimalTree minimalTree = new MinimalTree();
        minimalTree.buildMinimalTree(new int[]{1, 2, 3, 4, 5, 6});

        /*
            Expected Tree               4
                                      2   6
                                     1 3 5
         */
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

        assertEquals(minimalTree, new BinaryTree(expected_four));
    }

    @Test
    public void buildTree_oddLength() {
        MinimalTree minimalTree = new MinimalTree();
        minimalTree.buildMinimalTree(new int[]{1, 2, 3, 4, 5});

        /*
            Expected Tree               3
                                      2   5
                                     1   4
         */
        BinaryTreeNode expected_one = new BinaryTreeNode(1);
        BinaryTreeNode expected_two = new BinaryTreeNode(2);
        BinaryTreeNode expected_three = new BinaryTreeNode(3);
        BinaryTreeNode expected_four = new BinaryTreeNode(4);
        BinaryTreeNode expected_five = new BinaryTreeNode(5);

        expected_three.setLeft(expected_two);
        expected_three.setRight(expected_five);
        expected_two.setLeft(expected_one);
        expected_five.setLeft(expected_four);

        assertEquals(minimalTree, new BinaryTree(expected_three));    }

}