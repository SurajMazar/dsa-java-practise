package Easy.LinkedList;

public class LinkedListCreation {
    /**
     * NODE CLASS DATATYPE
     */
    static class Node {
        int value;
        Node previous;
        Node next;
    }

    public Node head;
    public Node tail;

    /**
     * INITIALIZATION
     */
    LinkedListCreation() {
        head = null;
        tail = null;
    }

    // Time O(1) | space O(1)
    public void setHead(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        insertBefore(head, node);
    }

    // Time O(1) | space O(1)
    public void setTail(Node node) {
        if (tail == null) {
            setHead(node);
        }
        insertAfter(tail, node);
    }
    // Time O(1) | space O(1)
    public void insertBefore(Node node, Node nodeToInsert) {
        if (nodeToInsert == head && nodeToInsert == tail) {
            return;
        }
        remove(nodeToInsert);
        nodeToInsert.next = node;
        nodeToInsert.previous = node.previous;
        if (node.previous == null) {
            head = nodeToInsert;
        } else {
            node.previous.next = nodeToInsert;
        }
        node.previous = nodeToInsert;
    }
    // Time O(1) | space O(1)
    public void insertAfter(Node node, Node nodeToInsert) {
        if (nodeToInsert == head && nodeToInsert == tail) {
            return;
        }
        remove(nodeToInsert);
        nodeToInsert.previous = node;
        nodeToInsert.next = node.next;
        if (node.next == null) {
            tail = nodeToInsert;
        } else {
            node.next.previous = nodeToInsert;
        }
        node.next = nodeToInsert;
    }

    // Time O(P) | space O(1)
    public void insertAtPosition(int position, Node nodeToInsert) {
        Node node = head;
        if (position == 1) {
            insertBefore(head, nodeToInsert);
            return;
        }
        int currentPosition = 1;
        while (node != null && currentPosition != position) {
            node = node.next;
            currentPosition++;
        }
        if (node != null) {
            insertBefore(node, nodeToInsert);
        } else {
            setTail(nodeToInsert);
        }
    }

    // Time O(n) | space O(1)
    public void removeNodeWithValue(int value) {
        Node node = head;
        while (node != null) {
            // USING TEMPORARY VARIABLE SO THAT WE DON'T LOSE THE TRACK OF THE NODE INSIDE WHILE LOOP
            Node removing = node;
            node = node.next;
            if (removing.value == value) {
                remove(removing);
            }
        }
    }

    // Time O(1) | space O(1)
    public void remove(Node node) {

        // IF HEAD - REMOVING THE HEAD AND POINTING THE HEAD AS THE NEXT NODE
        if (node == head) {
            head = head.next;
        }
        // IF TAIL - REMOVING THE TAIL AND POINTING THE TAIL AS THE PREVIOUS NODE
        if (node == tail) {
            tail = tail.previous;
        }

        removeNodeBindings(node);
    }

    // Time O(n) | space O(1)
    public boolean containNodeWithValue(int value) {
        Node node = head;
        while (node != null && node.value != value) {
            node = node.next;
        }
        return node != null;
    }


    public void removeNodeBindings(Node node) {
        // IF THERE IS THE NEXT NODE AFTER THE NODE TO BE REMOVED -> RE ASSIGNING BINDINGS
        // EXAMPLE -  3 -> 4 -> 5 AND 4 IS BEING REMOVED - 3 -> NEXT IS 5 AND 5 -> PREV IS 3
        if (node.next != null) {
            node.next.previous = node.previous;
        }

        if (node.previous != null) {
            node.previous.next = node.next;
        }

        node.previous = null;
        node.next = null;
    }


}




