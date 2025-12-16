package hospitalmanagementproject;

import Management.HospitalManagementSystem;
import javafx.event.ActionEvent;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

import java.io.IOException;


public class addPatientController {
    public TextField txtPatientID;
    public TextField txtPatientName;
    public Slider sliderAge;
    private sceneChanger sceneChanger = new sceneChanger();
    public void goToHello(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "hello-view.fxml");
    }

    public void saveBtn(){
        HospitalManagementSystem hospitalManagementSystem = new HospitalManagementSystem();

        hospitalManagementSystem.createPatient(Integer.parseInt(txtPatientID.getText()),txtPatientName.getText(),20,"male");
        //Sahne degisicek ve parametreler ayarlanicak
    }
}
