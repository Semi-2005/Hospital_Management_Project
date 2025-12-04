package data_structures.stack;

public class MyStack {
    private StackNode top;
    private int size;

    public MyStack() {
        this.top = null;
        this.size = 0;
    }

    // Push item onto stack
    public void push(Object data) {
        StackNode newNode = new StackNode(data);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    // Pop item from stack
    public Object pop() {
        if (top == null) {
            return null;
        }
        Object value = top.getData();
        top = top.getNext();
        size--;
        return value;
    }

    // Peek without removing
    public Object peek() {
        if (top == null) {
            return null;
        }
        return top.getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
