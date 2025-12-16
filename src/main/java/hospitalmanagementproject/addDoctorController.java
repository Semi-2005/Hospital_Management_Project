package hospitalmanagementproject;

import Management.HospitalManagementSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.io.IOException;

public class addDoctorController {

    @FXML
    public TextField txtDoctorID;

    @FXML
    public TextField txtDoctorName;

    @FXML
    public ComboBox<String> cmbDepartment;

    private sceneChanger sceneChanger = new sceneChanger();

    public void initialize() {
        cmbDepartment.getItems().addAll(
                "Cardiology",
                "Neurology",
                "Orthopedics",
                "Pediatrics",
                "General Surgery",
                "Dermatology"
        );
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

            HospitalManagementSystem hms = new HospitalManagementSystem();
            hms.addDoctor(id, name, department,"00:00","12:00");

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