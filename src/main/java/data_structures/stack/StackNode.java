package data_structures.stack;

public class StackNode {
    private Object data;
    private StackNode next;

    public StackNode(Object data) {
        this.data = data;
        this.next = null;
    }

    public Object getData() {
        return data;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}
