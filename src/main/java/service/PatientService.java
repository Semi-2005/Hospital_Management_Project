package service;

public class PatientService {
    private data_structures.hashtable.PatientHashTable patientTable;
    private undo.UndoManager undoManager;

    public PatientService(undo.UndoManager undoManager) {
        this.undoManager = undoManager;
        this.patientTable = new data_structures.hashtable.PatientHashTable();
    }

    public models.Patient addPatient(int id, String name, int age, String gender) {
        models.Patient newPatient = new models.Patient(id, name, age, gender);
        patientTable.put(String.valueOf(id), newPatient);
        undoManager.record(undo.ActionType.ADD_PATIENT, newPatient);
        return newPatient;
    }

    public models.Patient removePatient(int id) {
        models.Patient removed = (models.Patient) patientTable.remove(String.valueOf(id));
        if (removed != null) {
            undoManager.record(undo.ActionType.REMOVE_PATIENT, removed);
        }
        return removed;
    }

    public models.Patient getPatient(int id) {
        return (models.Patient) patientTable.get(String.valueOf(id));
    }

    public void addVisitRecord(int patientId, models.VisitRecord record) {
        models.Patient p = (models.Patient) patientTable.get(String.valueOf(patientId));
        if (p != null) {
            p.addVisit(record);
        }
    }

    public void printVisits(int patientId) {
        models.Patient p = (models.Patient) patientTable.get(String.valueOf(patientId));
        if (p != null) {
            p.getVisitHistory().printAll();
        }
    }
    public models.Patient[] getAllPatients() {
        return patientTable.getAll();
    }
}
