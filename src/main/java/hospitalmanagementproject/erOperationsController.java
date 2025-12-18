package hospitalmanagementproject;

import Management.HospitalManagementSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import java.io.IOException;

public class erOperationsController {
    private sceneChanger sceneChanger = new sceneChanger();
    public Label lblClock;
    public TextField txtPatientID;
    public Slider sliderSeverity;
    public Label lblSeverityValue;
    public void initialize() {
        if (lblClock != null) {
            ClockManager.startClock(lblClock);
        }
        if (lblSeverityValue != null) {
            lblSeverityValue.setText(String.valueOf((int) sliderSeverity.getValue()));

            sliderSeverity.valueProperty().addListener((observable, oldValue, newValue) -> {
                lblSeverityValue.setText(String.valueOf(newValue.intValue()));
            });
        }
    }
    public void goBack(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "hello-view.fxml");
    }

    public void addBtn(ActionEvent event) {
        try {
            if (txtPatientID.getText().isEmpty()) {
                showAlert("Error", "Please enter a Patient ID.");
                return;
            }

            int patientID = Integer.parseInt(txtPatientID.getText());
            int severity = (int) sliderSeverity.getValue(); // Slider double verir, int'e çeviriyoruz

            HospitalManagementSystem hms = new HospitalManagementSystem();
            hms.addERPatient(patientID, severity);

            showAlert("Success", "Patient added to ER Queue with severity: " + severity);

            txtPatientID.clear();
            sliderSeverity.setValue(0);

        } catch (NumberFormatException e) {
            showAlert("Error", "Patient ID must be a number!");
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
