package models;

public class Patient {
    private int id;
    private String name;
    private int age;
    private String gender;
    private data_structures.linkedlist.VisitLinkedList visitHistory;

    public Patient(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.visitHistory = new data_structures.linkedlist.VisitLinkedList();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public data_structures.linkedlist.VisitLinkedList getVisitHistory() {
        return visitHistory;
    }

    public void addVisit(Object visit) {
        visitHistory.add(visit);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
