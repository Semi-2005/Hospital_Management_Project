package hospitalmanagementproject;

import Management.HospitalManagementSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import java.io.IOException;

public class addPatientController {

    @FXML
    public TextField txtPatientID;
    @FXML
    public TextField txtPatientName;
    @FXML
    public Slider sliderAge;
    @FXML
    public Label lblAgeValue;
    @FXML
    public ComboBox<String> cmbGender;

    private sceneChanger sceneChanger = new sceneChanger();
    public Label lblClock;
    public void initialize() {
        sliderAge.valueProperty().addListener((observable, oldValue, newValue) -> {
            lblAgeValue.setText(Integer.toString(newValue.intValue()));
        });

        cmbGender.getItems().addAll("Male", "Female");
        if (lblClock != null) {
            ClockManager.startClock(lblClock);
        }
    }

    public void goToHello(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "hello-view.fxml");
    }

    public void saveBtn(ActionEvent event) {
        try {
            if (txtPatientID.getText().isEmpty() || txtPatientName.getText().isEmpty()) {
                showAlert("Error", "Please fill in all fields.");
                return;
            }

            if (cmbGender.getValue() == null) {
                showAlert("Error", "Please select a gender.");
                return;
            }

            int id = Integer.parseInt(txtPatientID.getText());
            String name = txtPatientName.getText();
            int age = (int) sliderAge.getValue();
            String gender = cmbGender.getValue();

            HospitalManagementSystem hms = HelloApplication.getHms();
            hms.createPatient(id, name, age, gender);

            showAlert("Success", "Patient added successfully: " + name);

            sceneChanger.changeScene(event, "hello-view.fxml");

        } catch (NumberFormatException e) {
            showAlert("Error", "Patient ID must be a number!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            showAlert("Error", "An unexpected error occurred: " + e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}