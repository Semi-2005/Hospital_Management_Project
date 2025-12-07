package models;

public class ERPatient {
    private int patientId;
    private int severity;      // priority value for ER triage
    private String arrivalTime;

    public ERPatient(int patientId, int severity, String arrivalTime) {
        this.patientId = patientId;
        this.severity = severity;
        this.arrivalTime = arrivalTime;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "ERPatient { " +
                "patientId=" + patientId +
                ", severity=" + severity +
                ", arrivalTime='" + arrivalTime + '\'' +
                " }";
    }
}
