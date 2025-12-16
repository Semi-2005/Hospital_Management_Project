package hospitalmanagementproject;


import Management.HospitalManagementSystem;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class addDoctorController {

    private sceneChanger sceneChanger = new sceneChanger();
    public void goToHello(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "hello-view.fxml");

    }
    public void btnSave(){
        HospitalManagementSystem hospitalManagementSystem = new HospitalManagementSystem();
        //hospitalManagementSystem.addDoctor()
        //secene degisecek
    }
}
