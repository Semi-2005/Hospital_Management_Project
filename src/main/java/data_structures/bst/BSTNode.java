package data_structures.bst;

public class BSTNode {
    private String key;
    private Object value;
    private BSTNode left;
    private BSTNode right;

    public BSTNode(String key, Object value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
}
