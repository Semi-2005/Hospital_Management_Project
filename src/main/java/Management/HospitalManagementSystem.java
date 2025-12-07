package Management;

public class HospitalManagementSystem {
    private service.PatientService patientService;
    private service.DoctorService doctorService;
    private data_structures.priorityqueue.ERPriorityQueue erQueue;
    private undo.UndoManager undoManager;
    private data_structures.tree.HospitalDirectoryTree directoryTree;

    public HospitalManagementSystem() {
        this.undoManager = new undo.UndoManager();
        this.patientService = new service.PatientService(undoManager);
        this.doctorService = new service.DoctorService(undoManager);
        this.erQueue = new data_structures.priorityqueue.ERPriorityQueue(200);
        this.directoryTree = new data_structures.tree.HospitalDirectoryTree("Main Hospital");
    }

    public service.PatientService getPatientService() {
        return patientService;
    }

    public service.DoctorService getDoctorService() {
        return doctorService;
    }

    public data_structures.priorityqueue.ERPriorityQueue getErQueue() {
        return erQueue;
    }

    public undo.UndoManager getUndoManager() {
        return undoManager;
    }

    public data_structures.tree.HospitalDirectoryTree getDirectoryTree() {
        return directoryTree;
    }

    public void undoLastAction() {
        undo.UndoAction action = undoManager.undo();
        if (action == null) {
            System.out.println("No undoable actions left.");
        } else {
            System.out.println("Undo: " + action.getActionType());
        }
    }
}
