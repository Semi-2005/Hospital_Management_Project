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
        // 1. Saati başlat
        if (lblClock != null) {
            ClockManager.startClock(lblClock);
        }

        // 2. Slider değerini göster (Eğer lblSeverityValue eklediysen)
        if (lblSeverityValue != null) {
            // Başlangıç değeri
            lblSeverityValue.setText(String.valueOf((int) sliderSeverity.getValue()));

            // Değiştikçe güncelle
            sliderSeverity.valueProperty().addListener((observable, oldValue, newValue) -> {
                lblSeverityValue.setText(String.valueOf(newValue.intValue()));
            });
        }
    }
    // Ana menüye dönmek istersen (Geri butonu varsa)
    public void goBack(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "hello-view.fxml");
    }

    public void addBtn(ActionEvent event) {
        try {
            // 1. Kontrol: ID boş mu?
            if (txtPatientID.getText().isEmpty()) {
                showAlert("Error", "Please enter a Patient ID.");
                return;
            }

            // 2. Verileri al
            int patientID = Integer.parseInt(txtPatientID.getText());
            int severity = (int) sliderSeverity.getValue(); // Slider double verir, int'e çeviriyoruz

            // 3. Sisteme kaydet
            // Singleton yapısına geçtiğimizde burayı düzelteceğiz, şimdilik böyle:
            HospitalManagementSystem hms = new HospitalManagementSystem();
            hms.addERPatient(patientID, severity);

            // 4. Başarılı mesajı
            showAlert("Success", "Patient added to ER Queue with severity: " + severity);

            // İstersen formu temizle
            txtPatientID.clear();
            sliderSeverity.setValue(0); // Slider'ı başa al

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
