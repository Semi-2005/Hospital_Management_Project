package hospitalmanagementproject;

import Management.HospitalManagementSystem;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static HospitalManagementSystem hms = new HospitalManagementSystem();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hospital Management System");
        stage.setScene(scene);
        stage.show();
    }
    public static HospitalManagementSystem getHms(){
        return hms;
    }
}
