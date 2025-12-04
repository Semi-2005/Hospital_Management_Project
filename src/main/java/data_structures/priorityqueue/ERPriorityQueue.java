package data_structures.priorityqueue;

public class ERPriorityQueue {
    private Heap heap;

    public ERPriorityQueue(int capacity) {
        this.heap = new Heap(capacity);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    // Add new ER patient (object must have getSeverity())
    public void add(Object patient) {
        heap.insert(patient);
    }

    // Returns but does not remove the most critical patient
    public Object peek() {
        return heap.peek();
    }

    // Removes and returns the most critical patient
    public Object treatNext() {
        return heap.extractMax();
    }
}
