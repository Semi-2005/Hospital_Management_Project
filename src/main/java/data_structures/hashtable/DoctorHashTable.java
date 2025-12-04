package data_structures.hashtable;

import utils.IDUtil;
import utils.RandomGenerator;

public class DoctorHashTable {
    private HashNode[] buckets;
    private int capacity;
    private int size;

    public DoctorHashTable() {
        // Use RandomGenerator for reproducible capacity
        this.capacity = RandomGenerator.nextInt(15, 30);
        this.buckets = new HashNode[this.capacity];
        this.size = 0;
    }

    private int hash(String key) {
        int salted = IDUtil.saltedHash(key);
        return Math.abs(salted) % capacity;
    }

    public void put(String key, Object doctor) {
        int index = hash(key);
        HashNode head = buckets[index];

        // Update if exists
        while (head != null) {
            if (head.getKey().equalsIgnoreCase(key)) {
                head.setValue(doctor);
                return;
            }
            head = head.getNext();
        }

        // Insert new node
        HashNode newNode = new HashNode(key, doctor);
        newNode.setNext(buckets[index]);
        buckets[index] = newNode;
        size++;
    }

    public Object get(String key) {
        int index = hash(key);
        HashNode head = buckets[index];

        while (head != null) {
            if (head.getKey().equalsIgnoreCase(key)) {
                return head.getValue();
            }
            head = head.getNext();
        }
        return null;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public Object remove(String key) {
        int index = hash(key);
        HashNode head = buckets[index];
        HashNode prev = null;

        while (head != null) {
            if (head.getKey().equalsIgnoreCase(key)) {
                if (prev == null) {
                    buckets[index] = head.getNext();
                } else {
                    prev.setNext(head.getNext());
                }
                size--;
                return head.getValue();
            }
            prev = head;
            head = head.getNext();
        }
        return null;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }
}
