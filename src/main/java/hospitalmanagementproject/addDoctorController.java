package hospitalmanagementproject;

import Management.HospitalManagementSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;

public class addDoctorController {

    @FXML
    public TextField txtDoctorID;

    @FXML
    public TextField txtDoctorName;

    @FXML
    public ComboBox<String> cmbDepartment;
    public ComboBox<String> cmbWorkStart;
    public ComboBox<String> cmbWorkEnd;

    private sceneChanger sceneChanger = new sceneChanger();
    public Label lblClock;

    public void initialize() {
        cmbDepartment.getItems().addAll(
                "Cardiology",
                "Neurology",
                "Orthopedics",
                "Pediatrics",
                "General Surgery",
                "Dermatology"
        );
        cmbWorkStart.getItems().addAll(
                "00:00","00:30",
                "01:00","01:30",
                "02:00","02:30",
                "03:00","03:30",
                "04:00","04:30",
                "05:00","05:30",
                "06:00","06:30",
                "07:00","07:30",
                "08:00","08:30",
                "09:00","09:30",
                "10:00","10:30",
                "11:00","11:30",
                "12:00","12:30",
                "13:00","13:30",
                "14:00","14:30",
                "15:00","15:30",
                "16:00","16:30",
                "17:00","17:30",
                "18:00","18:30",
                "19:00","19:30",
                "20:00","20:30",
                "21:00","21:30",
                "22:00","22:30",
                "23:00","23:30"
        );
        cmbWorkEnd.getItems().addAll(
                "00:00","00:30",
                "01:00","01:30",
                "02:00","02:30",
                "03:00","03:30",
                "04:00","04:30",
                "05:00","05:30",
                "06:00","06:30",
                "07:00","07:30",
                "08:00","08:30",
                "09:00","09:30",
                "10:00","10:30",
                "11:00","11:30",
                "12:00","12:30",
                "13:00","13:30",
                "14:00","14:30",
                "15:00","15:30",
                "16:00","16:30",
                "17:00","17:30",
                "18:00","18:30",
                "19:00","19:30",
                "20:00","20:30",
                "21:00","21:30",
                "22:00","22:30",
                "23:00","23:30"
        );
        if (lblClock != null) {
            ClockManager.startClock(lblClock);
        }
    }

    public void cancelBtn(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "hello-view.fxml");
    }

    public void saveBtn(ActionEvent event) {
        try {
            if (txtDoctorID.getText().isEmpty() || txtDoctorName.getText().isEmpty()) {
                showAlert("Error", "Please fill in all fields.");
                return;
            }

            if (cmbDepartment.getValue() == null) {
                showAlert("Error", "Please select a department.");
                return;
            }

            int id = Integer.parseInt(txtDoctorID.getText());
            String name = txtDoctorName.getText();
            String department = cmbDepartment.getValue();
            String workStart = cmbWorkStart.getValue();
            String workEnd = cmbWorkEnd.getValue();

            HospitalManagementSystem hms = HelloApplication.getHms();
            hms.registerDoctor(id, name, department, workStart, workEnd);

            showAlert("Success", "Doctor added successfully: " + name);

            sceneChanger.changeScene(event, "hello-view.fxml");

        } catch (NumberFormatException e) {
            showAlert("Error", "Doctor ID must be a number!");
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