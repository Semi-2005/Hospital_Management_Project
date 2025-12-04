package data_structures.hashtable;

public class HashNode {
    private String key;
    private Object value;
    private HashNode next;

    public HashNode(String key, Object value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public HashNode getNext() {
        return next;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setNext(HashNode next) {
        this.next = next;
    }
}
