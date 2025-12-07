package models;

import data_structures.tree.HospitalDirectoryTree;

public class Hospital {
    private String name;
    private HospitalDirectoryTree directoryTree;

    public Hospital(String name) {
        this.name = name;
        this.directoryTree = new HospitalDirectoryTree(name);
    }

    public String getName() {
        return name;
    }

    public HospitalDirectoryTree getDirectoryTree() {
        return directoryTree;
    }

    public void addDepartment(String departmentName) {
        directoryTree.addDepartment(departmentName);
    }

    @Override
    public String toString() {
        return "Hospital: " + name;
    }
}
