package hospitalmanagementproject;

import javafx.event.ActionEvent;

import java.io.IOException;

public class appointmentController {
    private sceneChanger sceneChanger = new sceneChanger();
    public void goToHello(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "hello-view.fxml");
    }
}
