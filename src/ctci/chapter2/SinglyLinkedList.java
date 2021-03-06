package ctci.chapter2;

/**
 * Quick and dirty singly linked list implementation for use in questions.
 */
public class SinglyLinkedList {

    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    /**
     * Adds the data to a new node at front of the list.
     * @param data
     */
    public void add(Integer data) {
        head = new Node(data, head);
    }

    /**
     * Retrieves the data value at the given index.
     * @param index
     * @return data.
     */
    public Integer get(int index) {
        return getNode(index).data;
    }

    /**
     * Retrieves the node at the given index.
     * @param index
     * @return node.
     */
    public Node getNode(int index) {
        if (index < 0) {
            throw new RuntimeException("Index can not be less than 0.");
        }

        int i = 0;
        Node curr = head;

        if (curr == null) {
            throw new RuntimeException("Index is out of bounds!");
        }

        while (i != index) {
            if (curr == null) {
                throw new RuntimeException("Index is out of bounds!");
            }
            i++;
            curr = curr.next;
        }

        return curr;
    }

    /**
     * Quick and dirty equals solution so that I can unit test, absolutely not optimal here.
     * @param o
     * @return true if equals, else false.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof SinglyLinkedList)) {
            return false;
        }

        SinglyLinkedList other = (SinglyLinkedList) o;
        int i = 0;
        Node curr = head;

        if (curr == null) {
            return other.getHead() == null;
        }

        while (curr != null) {
            // I just want to reiterate that this is meant to be quick and dirty and is not a solution to a problem...
            try {
                if (!curr.data.equals(other.get(i))) {
                    return false;
                }
            } catch (RuntimeException e) {
                return false;
            }
            curr = curr.next;
            i++;
        }

        return true;
    }

    public Node getHead() {
        return head;
    }

    /**
     * Inner node class for the linked list implementation to use.
     */
    public class Node {
        public Integer data;
        public Node next;

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
