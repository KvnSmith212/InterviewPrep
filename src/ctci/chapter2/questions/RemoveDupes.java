package ctci.chapter2.questions;

import ctci.chapter2.SinglyLinkedList;

import java.util.HashSet;

/**
 * 2.1
 *
 * Write code to remove duplicates from an unsorted linked list.
 *
 * FollowUp: How would you solve without a temporary buffer?
 */
public class RemoveDupes extends SinglyLinkedList {

    /**
     * Removes duplicates from the list by keeping a set of seen data, and making a single pass through the list.
     */
    public void removeDupes() {
        HashSet<Integer> touchedData = new HashSet<>();

        Node curr = getHead();
        if (curr == null) {
            return;
        }

        touchedData.add(curr.data);
        while(curr.next != null) {
            if(touchedData.contains(curr.next.data)) {
                curr.next = curr.next.next;
            } else {
                touchedData.add(curr.next.data);
                curr = curr.next;
            }
        }
    }

    /**
     * todo: How would you solve without a temporary buffer?
     * Removes duplicates from the list by keeping iterating through the list once per item in the list, removing
     * duplicates for the current item as they are seen.
     */
    public void removeDupesWithoutBuffer() {
        throw new RuntimeException("Not yet implemented!");
    }
}
