package service;

public class DoctorService{
    private data_structures.hashtable.DoctorHashTable doctorTable;
    private undo.UndoManager undoManager;
    private java.util.HashMap<Integer, data_structures.queue.MyQueue> doctorQueues;
    private java.util.HashMap<Integer, java.util.ArrayList<models.Appointment>> doctorAppointments;

    public DoctorService(undo.UndoManager undoManager) {
        this.undoManager = undoManager;
        this.doctorTable = new data_structures.hashtable.DoctorHashTable();
        this.doctorQueues = new java.util.HashMap<>();
        this.doctorAppointments = new java.util.HashMap<>();
    }

    public models.Doctor addDoctor(int id, String name, String department, String start, String end) {
        models.Doctor doctor = new models.Doctor(id, name, department, start, end);
        doctorTable.put(String.valueOf(id), doctor);

        doctorQueues.put(id, new data_structures.queue.MyQueue());
        doctorAppointments.put(id, new java.util.ArrayList<>());

        undoManager.record(undo.ActionType.ADD_DOCTOR, doctor);
        return doctor;
    }

    public models.Doctor removeDoctor(int id) {
        models.Doctor removed = (models.Doctor) doctorTable.remove(String.valueOf(id));
        if (removed != null) {
            undoManager.record(undo.ActionType.REMOVE_DOCTOR, removed);
        }
        return removed;
    }

    public models.Doctor getDoctor(int id) {
        return (models.Doctor) doctorTable.get(String.valueOf(id));
    }

    public void enqueuePatientToDoctor(int doctorId, int patientId) {
        data_structures.queue.MyQueue q = doctorQueues.get(doctorId);
        if (q != null) {
            q.enqueue(patientId);
        }
    }

    public Object dequeueFromDoctor(int doctorId) {
        data_structures.queue.MyQueue q = doctorQueues.get(doctorId);
        if (q != null) {
            return q.dequeue();
        }
        return null;
    }

    public boolean createAppointment(int doctorId, int patientId, String time) {
        models.Doctor doctor = (models.Doctor) doctorTable.get(String.valueOf(doctorId));
        if (doctor == null) return false;

        if (!utils.TimeUtil.isWithin(time, doctor.getWorkStart(), doctor.getWorkEnd())) {
            return false;
        }

        java.util.ArrayList<models.Appointment> list = doctorAppointments.get(doctorId);

        for (models.Appointment a : list) {
            if (utils.TimeUtil.compare(a.getTime(), time) == 0) {
                return false;
            }
        }

        models.Appointment newApp = new models.Appointment(doctorId, patientId, time);
        list.add(newApp);
        return true;
    }

    public java.util.ArrayList<models.Appointment> getAppointmentsForDoctor(int doctorId) {
        return doctorAppointments.get(doctorId);
    }
}
