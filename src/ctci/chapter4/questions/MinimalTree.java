package ctci.chapter4.questions;

import ctci.chapter4.BinaryTree;
import ctci.chapter4.BinaryTreeNode;

import java.util.Arrays;

/**
 * 4.2 Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm to
 * create a binary search tree with minimal height.
 */
public class MinimalTree extends BinaryTree {

    public MinimalTree() {
        super(null);
    }

    /**
     * Produces a binary search tree with minimal height when given a sorted array. Algorithm for this is to cut straight
     * to the middle of the array, create the root node, and then operate on each side of the array recursively in order
     * to build up the rest of the tree.
     *
     * @param sortedInput
     */
    public void buildMinimalTree(int[] sortedInput) {
        root = buildMinimalTreeRecursive(sortedInput);;
    }

    private BinaryTreeNode buildMinimalTreeRecursive(int[] sortedInput) {

        if (sortedInput.length < 1) {
            return null;
        }

        BinaryTreeNode node = new BinaryTreeNode(sortedInput[sortedInput.length/2]);
        int[] left = Arrays.copyOfRange(sortedInput, 0, sortedInput.length/2);
        int[] right = Arrays.copyOfRange(sortedInput, sortedInput.length/2 + 1, sortedInput.length);

        node.setLeft(buildMinimalTreeRecursive(left));
        node.setRight(buildMinimalTreeRecursive(right));

        return node;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

}
