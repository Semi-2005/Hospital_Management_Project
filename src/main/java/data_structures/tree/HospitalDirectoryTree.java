package data_structures.tree;

public class HospitalDirectoryTree {
    private GeneralTreeNode root;

    public HospitalDirectoryTree(Object rootData) {
        this.root = new GeneralTreeNode(rootData);
    }

    public GeneralTreeNode getRoot() {
        return root;
    }

    // Add a department under the hospital root
    public GeneralTreeNode addDepartment(String departmentName) {
        GeneralTreeNode dept = new GeneralTreeNode(departmentName);
        root.addChild(dept);
        return dept;
    }

    // Add a doctor under a department
    public GeneralTreeNode addDoctor(GeneralTreeNode departmentNode, Object doctorData) {
        if (departmentNode == null) return null;
        GeneralTreeNode doctorNode = new GeneralTreeNode(doctorData);
        departmentNode.addChild(doctorNode);
        return doctorNode;
    }

    // DFS search by name
    public GeneralTreeNode search(Object target) {
        return searchRecursive(root, target);
    }

    private GeneralTreeNode searchRecursive(GeneralTreeNode node, Object target) {
        if (node == null) return null;

        if (node.getData().equals(target)) {
            return node;
        }

        for (GeneralTreeNode child : node.getChildren()) {
            GeneralTreeNode result = searchRecursive(child, target);
            if (result != null) return result;
        }
        return null;
    }

    // Print tree (simple hierarchical display)
    public void printTree() {
        printRecursive(root, 0);
    }

    private void printRecursive(GeneralTreeNode node, int level) {
        if (node == null) return;
        System.out.println("  ".repeat(level) + "- " + node.getData());
        for (GeneralTreeNode child : node.getChildren()) {
            printRecursive(child, level + 1);
        }
    }
}
