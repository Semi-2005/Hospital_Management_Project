package hospitalmanagementproject;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.io.IOException;

public class HelloController {

    private sceneChanger sceneChanger = new sceneChanger();

    public Label lblClock;
    public void initialize() {
        if (lblClock != null) {
            ClockManager.startClock(lblClock);
        }
    }
    public void goToAddDoctor(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "addDoctor-view.fxml");
    }
    public void goToAddPatient(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "addPatient-view.fxml");
    }
    public void goToAppointments(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "appointment-view.fxml");
    }
    public void goToEROperations(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "erOperations-view.fxml");
    }
    public void goToReports(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "reports-view.fxml");
    }
    public void goToDirectory(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "directory-view.fxml");
    }
    public void goToSearch(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "search-view.fxml");
    }
    public void undoBtn(ActionEvent event) {

        Management.HospitalManagementSystem hms = HelloApplication.getHms();
        String message = hms.undoLastAction();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Undo Operation");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
