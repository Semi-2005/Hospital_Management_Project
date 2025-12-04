package data_structures.queue;

public class QueueNode {
    private Object data;
    private QueueNode next;

    public QueueNode(Object data) {
        this.data = data;
        this.next = null;
    }

    public Object getData() {
        return data;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }
}
