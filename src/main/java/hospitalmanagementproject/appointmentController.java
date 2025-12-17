package hospitalmanagementproject;

import Management.HospitalManagementSystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;

public class appointmentController {

    @FXML
    public TextField txtPatientID;

    @FXML
    public TextField txtDoctorID;

    @FXML
    public TextField txtTime;

    private sceneChanger sceneChanger = new sceneChanger();
    public Label lblClock;
    public void initialize() {
        if (lblClock != null) {
            ClockManager.startClock(lblClock);
        }
    }

    public void cancelBtn(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "hello-view.fxml");
    }

    public void saveBtn(ActionEvent event) {
        try {
            // 1. Alanlar boş mu kontrol et
            if (txtPatientID.getText().isEmpty() || txtDoctorID.getText().isEmpty() || txtTime.getText().isEmpty()) {
                showAlert("Error", "Please fill in all fields.");
                return;
            }

            // 2. Verileri al
            int patientID = Integer.parseInt(txtPatientID.getText());
            int doctorID = Integer.parseInt(txtDoctorID.getText());
            String time = txtTime.getText();

            // 3. Sisteme kaydet
            // Eğer Singleton yaptıysan: HospitalManagementSystem.getInstance();
            // Yapmadıysan eski usul: new HospitalManagementSystem();
            HospitalManagementSystem hms = new HospitalManagementSystem();

            // Modelindeki sıraya göre parametreleri gönder (Önce Doktor ID, Sonra Hasta ID demiştik)
            hms.createAppointment(doctorID, patientID, time);

            showAlert("Success", "Appointment created successfully.");

            // Formu temizle
            txtPatientID.clear();
            txtDoctorID.clear();
            txtTime.clear();

        } catch (NumberFormatException e) {
            showAlert("Error", "ID fields must be numbers!");
        } catch (IllegalArgumentException e) {
            // Saat formatı hatalıysa buraya düşer
            showAlert("Error", e.getMessage());
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