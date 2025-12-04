package data_structures.linkedlist;

public class VisitLinkedList {
    private ListNode head;
    private int size;

    public VisitLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Add a new visit record to the end of the list
    public void add(Object visitData) {
        ListNode newNode = new ListNode(visitData);

        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    // Get visit record by index
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    // Returns number of visits
    public int size() {
        return size;
    }

    // Check if list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Print all visit records (useful for debugging)
    public void printAll() {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}
