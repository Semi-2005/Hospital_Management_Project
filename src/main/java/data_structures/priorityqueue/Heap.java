package data_structures.priorityqueue;

import java.util.ArrayList;

public class Heap {
    private Object[] heap;
    private int size;
    private int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.heap = new Object[capacity];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // Assumes priorities are integers stored inside a Patient-like object
    private int getPriority(Object obj) {
        try {
            return (int) obj.getClass().getMethod("getSeverity").invoke(obj);
        } catch (Exception e) {
            throw new RuntimeException("Object does not have getSeverity(): " + obj);
        }
    }

    private void swap(int i, int j) {
        Object temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(Object element) {
        if (size >= capacity) {
            throw new IllegalStateException("Heap is full");
        }
        heap[size] = element;
        heapifyUp(size);
        size++;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (getPriority(heap[index]) > getPriority(heap[parent])) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    public Object extractMax() {
        if (size == 0) return null;

        Object max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    private void heapifyDown(int index) {
        while (index < size) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int largest = index;

            if (left < size && getPriority(heap[left]) > getPriority(heap[largest])) {
                largest = left;
            }
            if (right < size && getPriority(heap[right]) > getPriority(heap[largest])) {
                largest = right;
            }
            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    public Object peek() {
        if (size == 0) return null;
        return heap[0];
    }
    public ArrayList<Object> getHeapElements() {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(heap[i]);
        }
        return list;
    }
}
