package hospitalmanagementproject;

import javafx.event.ActionEvent;

import java.io.IOException;

public class searchController {
    private sceneChanger sceneChanger = new sceneChanger();
    public void goToHello(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "hello-view.fxml");
    }
}
