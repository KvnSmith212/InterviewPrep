package ctci.chapter2.questions;

import ctci.chapter2.SinglyLinkedList;

/**
 * 2.3
 *
 * Implement an algorithm to delete a given node of a singly linked list. Only access to that node is given,
 * you do not have access to head.
 */
public class DeleteMiddle extends SinglyLinkedList {

    /**
     * Delete the middle node by copying over the contents from the next node before removing next. Note that
     * implementation of deletion from a given node, without access to previous, is impossible in a singly linked list
     * if the given node is the last in the list.
     * @param node
     */
    public void deleteMiddle(Node node) {
        if (node == null || node.next == null) {
            throw new RuntimeException("Is is not possible to delete the given node!");
        }

        node.data = node.next.data;
        node.next = node.next.next;
    }
}
