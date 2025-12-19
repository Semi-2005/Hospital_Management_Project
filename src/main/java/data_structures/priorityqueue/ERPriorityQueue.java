package data_structures.priorityqueue;

import models.ERPatient;

import java.util.ArrayList;

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

    public ArrayList<ERPatient> getSnapshot() {

        ArrayList<Object> rawList = heap.getHeapElements();
        ArrayList<ERPatient> patientList = new ArrayList<>();


        for (Object o : rawList) {
            if (o instanceof ERPatient) {
                patientList.add((ERPatient) o);
            }
        }
        return patientList;
    }
}
