package hospitalmanagementproject;

import Management.HospitalManagementSystem;
import javafx.event.ActionEvent;

import java.io.IOException;

public class erOperationsController {
    private sceneChanger sceneChanger = new sceneChanger();
    HospitalManagementSystem hospitalManagementSystem = new HospitalManagementSystem();
    public void goToHello(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "hello-view.fxml");
    }
    public void btnSave(){

        //hospitalManagementSystem.addERPatient();

    }
    public void btnTreatNextCriticalPatient(){
        //hospitalManagementSystem.treatNextERPatient();
    }
}
