package hospitalmanagementproject;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.IOException;

public class reportsController {
    private sceneChanger sceneChanger = new sceneChanger();
    public Label lblClock;
    public void initialize() {
        if (lblClock != null) {
            ClockManager.startClock(lblClock);
        }
    }
    public void goToHello(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "hello-view.fxml");
    }
}
