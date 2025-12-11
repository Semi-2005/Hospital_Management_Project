package hospitalmanagementproject;

import javafx.event.ActionEvent;
import java.io.IOException;

public class HelloController {
    private sceneChanger sceneChanger = new sceneChanger();

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

}
