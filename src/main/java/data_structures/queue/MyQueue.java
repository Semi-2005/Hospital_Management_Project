package data_structures.queue;

public class MyQueue {
    private QueueNode front;
    private QueueNode rear;
    private int size;

    public MyQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Add patient to the end of the queue (FIFO)
    public void enqueue(Object data) {
        QueueNode newNode = new QueueNode(data);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }

    // Remove and return the first patient in queue
    public Object dequeue() {
        if (front == null) return null;

        Object result = front.getData();
        front = front.getNext();

        if (front == null) {
            rear = null;
        }
        size--;
        return result;
    }

    // See first patient without removing
    public Object peek() {
        if (front == null) return null;
        return front.getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
