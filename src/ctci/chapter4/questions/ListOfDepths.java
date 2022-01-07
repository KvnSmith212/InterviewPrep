package ctci.chapter4.questions;

import ctci.chapter4.BinaryTree;
import ctci.chapter4.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 4.3 List of Depths: Given a binary tree, design an algorithm which creates a linked list of all nodes at each depth.
 */
public class ListOfDepths {

    /**
     * Implementation will use BFS, keeping track of level and adding nodes to each level as traversal happens.
     *
     * @param binaryTree
     * @return map of level to it's corresponding nodes list.
     */
    public Map<Integer, List<BinaryTreeNode>> listOfDepths(BinaryTree binaryTree) {
        Map<Integer, List<BinaryTreeNode>> levelToNodes = new HashMap<>();
        Queue<BinaryTreeNode> bfsQueue = new LinkedList<>();

        BinaryTreeNode root = binaryTree.getRoot();

        if (root == null) {
            return levelToNodes;
        }

        int level = 0;
        levelToNodes.put(level, new ArrayList<>(Arrays.asList(root)));
        levelToNodes.put(level+1, new ArrayList<>());
        bfsQueue.add(root);

        while (!bfsQueue.isEmpty()) {
            BinaryTreeNode node = bfsQueue.poll();

            // We have reached a new level if the previous level doesn't contain the node from queue, since we are
            // populating the lists at the same time we populate into the queue.
            if (!levelToNodes.get(level).contains(node)) {
                level++;
                if (node.getLeft() != null || node.getRight() != null) {
                    levelToNodes.put(level + 1, new ArrayList<>());
                }
            }

            if (node.getLeft() != null) {
                bfsQueue.add(node.getLeft());
                levelToNodes.get(level+1).add(node.getLeft());
            }

            if (node.getRight() != null) {
                bfsQueue.add(node.getRight());
                levelToNodes.get(level+1).add(node.getRight());
            }
        }

        return levelToNodes;
    }

}
