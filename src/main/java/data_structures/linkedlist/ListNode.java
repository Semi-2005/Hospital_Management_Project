package data_structures.linkedlist;

public class ListNode {
    private Object data;
    private ListNode next;

    public ListNode(Object data) {
        this.data = data;
        this.next = null;
    }

    public Object getData() {
        return data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
