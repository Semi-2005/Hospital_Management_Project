package models;

public class Appointment {

    private int doctorId;
    private int patientId;
    private String time; // HH:MM format

    public Appointment(int doctorId, int patientId, String time) {
        if (!utils.TimeUtil.isValidFormat(time)) {
            throw new IllegalArgumentException("Invalid time format: " + time);
        }
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.time = time;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String newTime) {
        if (!utils.TimeUtil.isValidFormat(newTime)) {
            throw new IllegalArgumentException("Invalid time format: " + newTime);
        }
        this.time = newTime;
    }

    @Override
    public String toString() {
        return "Appointment [Doctor ID: " + doctorId +
               ", Patient ID: " + patientId +
               ", Time: " + time + "]";
    }
}
