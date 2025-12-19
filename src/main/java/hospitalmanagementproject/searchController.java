package hospitalmanagementproject;

import Management.HospitalManagementSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;

public class searchController {

    @FXML
    public TextField txtPatientID;
    @FXML
    public Label lblPatientResult;

    @FXML
    public TextField txtDoctorID;
    @FXML
    public Label lblDoctorResult;

    @FXML
    public Label lblClock;

    private sceneChanger sceneChanger = new sceneChanger();

    public void initialize() {
        if (lblClock != null) {
            ClockManager.startClock(lblClock);
        }
    }

    public void searchPatient(ActionEvent event) {
        try {
            if (txtPatientID.getText().isEmpty()) {
                showAlert("Error", "Please enter a Patient ID.");
                return;
            }

            int id = Integer.parseInt(txtPatientID.getText());
            HospitalManagementSystem hms = HelloApplication.getHms();

            models.Patient p = hms.findPatient(id);

            if (p != null) {
                String info = "ID: " + p.getId() + "\n" +
                        "Name: " + p.getName() + "\n" +
                        "Age: " + p.getAge() + "\n" +
                        "Gender: " + p.getGender();
                lblPatientResult.setText(info);
            } else {
                lblPatientResult.setText("Patient Not Found!");
                showAlert("Not Found", "No patient found with ID: " + id);
            }

        } catch (NumberFormatException e) {
            showAlert("Error", "ID must be a number!");
        } catch (Exception e) {
            lblPatientResult.setText("Error occurred.");
        }
    }

    public void searchDoctor(ActionEvent event) {
        try {
            if (txtDoctorID.getText().isEmpty()) {
                showAlert("Error", "Please enter a Doctor ID.");
                return;
            }

            int id = Integer.parseInt(txtDoctorID.getText());
            HospitalManagementSystem hms = HelloApplication.getHms();

            models.Doctor d = hms.findDoctor(id);

            if (d != null) {
                String info = "ID: " + d.getId() + "\n" +
                        "Name: " + d.getName() + "\n" +
                        "Dept: " + d.getDepartment() + "\n" +
                        "Shift: " + d.getWorkStart() + " - " + d.getWorkEnd();
                lblDoctorResult.setText(info);
            } else {
                lblDoctorResult.setText("Doctor Not Found!");
                showAlert("Not Found", "No doctor found with ID: " + id);
            }

        } catch (NumberFormatException e) {
            showAlert("Error", "ID must be a number!");
        } catch (Exception e) {
            lblDoctorResult.setText("Error occurred.");
        }
    }

    public void cancelBtn(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "hello-view.fxml");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}