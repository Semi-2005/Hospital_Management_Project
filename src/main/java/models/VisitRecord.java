package models;

public class VisitRecord {
    private int patientId;
    private int doctorId;
    private String description;
    private String time; // HH:MM format

    public VisitRecord(int patientId, int doctorId, String description, String time) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.description = description;
        this.time = time;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "VisitRecord{" +
                "patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", description='" + description + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
