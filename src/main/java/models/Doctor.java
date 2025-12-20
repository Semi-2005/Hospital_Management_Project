package models;

public class Doctor {

    private int id;
    private String name;
    private String department;
    private String workStart;   // HH:MM format
    private String workEnd;     // HH:MM format

    public Doctor(int id, String name, String department, String workStart, String workEnd) {
        this.id = id;
        this.name = name;
        this.department = department;

        if (!utils.TimeUtil.isValidFormat(workStart) || !utils.TimeUtil.isValidFormat(workEnd)) {
            throw new IllegalArgumentException("Invalid time format for working hours.");
        }
        this.workStart = workStart;
        this.workEnd = workEnd;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getWorkStart() {
        return workStart;
    }

    public void setWorkStart(String workStart) {
        if (!utils.TimeUtil.isValidFormat(workStart)) {
            throw new IllegalArgumentException("Invalid time format.");
        }
        this.workStart = workStart;
    }

    public String getWorkEnd() {
        return workEnd;
    }

    public void setWorkEnd(String workEnd) {
        if (!utils.TimeUtil.isValidFormat(workEnd)) {
            throw new IllegalArgumentException("Invalid time format.");
        }
        this.workEnd = workEnd;
    }

    @Override
    public String toString() {
        return "  Name:" + name +
                "  ID:" + id +
                 "  Department:" + department +
                "  Working Hours:" + workStart + "-" + workEnd ;
    }
}
