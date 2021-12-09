package ctci.chapter2.questions;

import ctci.chapter2.SinglyLinkedList;

/**
 * 2.2
 *
 * Find the kth to last element of a singly linked list.
 */
public class KtoLast extends SinglyLinkedList {

    /**
     * Uses the runner technique, keeping the runner k elements ahead.
     * @param k
     * @return the kth to last element.
     */
    public Integer kToLast(int k) {
        Node runner = getHead();

        if (k < 0) {
            throw new RuntimeException("Invalid input!");
        }

        if (runner == null) {
            throw new RuntimeException("List is empty!");
        }

        Node walker = runner;
        int i = 0;
        while(runner.next != null) {
            runner = runner.next;
            if (i < k) {
                i++;
            } else {
                walker = walker.next;
            }
        }

        if (i < k) {
            throw new RuntimeException("List is not K elements long!");
        }

        return walker.data;
    }
}
