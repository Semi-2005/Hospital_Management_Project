package data_structures.tree;

public class GeneralTreeNode {
    private Object data;
    private java.util.ArrayList<GeneralTreeNode> children;

    public GeneralTreeNode(Object data) {
        this.data = data;
        this.children = new java.util.ArrayList<>();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void addChild(GeneralTreeNode child) {
        this.children.add(child);
    }

    public java.util.ArrayList<GeneralTreeNode> getChildren() {
        return children;
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }
}
