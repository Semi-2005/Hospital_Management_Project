package data_structures.bst;

public class PatientBST {
    private BSTNode root;

    public PatientBST() {
        this.root = null;
    }

    // Insert patient using patient name as key
    public void insert(String nameKey, Object patient) {
        root = insertRecursive(root, nameKey, patient);
    }

    private BSTNode insertRecursive(BSTNode node, String key, Object value) {
        if (node == null) {
            return new BSTNode(key, value);
        }
        if (key.compareToIgnoreCase(node.getKey()) < 0) {
            node.setLeft(insertRecursive(node.getLeft(), key, value));
        } else if (key.compareToIgnoreCase(node.getKey()) > 0) {
            node.setRight(insertRecursive(node.getRight(), key, value));
        }
        return node;
    }

    // Search patient by name
    public Object search(String nameKey) {
        BSTNode node = searchRecursive(root, nameKey);
        return (node == null) ? null : node.getValue();
    }

    private BSTNode searchRecursive(BSTNode node, String key) {
        if (node == null || key.equalsIgnoreCase(node.getKey())) {
            return node;
        }
        if (key.compareToIgnoreCase(node.getKey()) < 0) {
            return searchRecursive(node.getLeft(), key);
        } else {
            return searchRecursive(node.getRight(), key);
        }
    }

    public boolean contains(String nameKey) {
        return search(nameKey) != null;
    }
}
