package hospitalmanagementproject;

import Management.HospitalManagementSystem;
import models.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;

public class appointmentController {

    @FXML
    public TextField txtPatientID;
    @FXML
    public TextField txtDoctorID;
    @FXML
    public TextField txtTime;

    @FXML
    public TableView<Appointment> tableAppointments;

    @FXML
    public TableColumn<Appointment, String > colPatientName;
    @FXML
    public TableColumn<Appointment, String> colDoctorName;
    @FXML
    public TableColumn<Appointment, String> colTime;

    @FXML
    public Label lblClock;

    private sceneChanger sceneChanger = new sceneChanger();

    public void initialize() {
        if (lblClock != null) {
            ClockManager.startClock(lblClock);
        }
        HospitalManagementSystem hms = HelloApplication.getHms();
        colPatientName.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(hms.findPatient(data.getValue().getPatientId()).getName()));
        colDoctorName.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(hms.findDoctor(data.getValue().getDoctorId()).getName()));
        colTime.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTime()));

        loadAppointments();
    }

    public void loadAppointments() {
        try {
            HospitalManagementSystem hms = HelloApplication.getHms();
            ArrayList<Appointment> appointments = hms.listAllAppointments();

            if (appointments != null) {
                ObservableList<Appointment> list = FXCollections.observableArrayList(appointments);
                tableAppointments.setItems(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancelBtn(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "hello-view.fxml");
    }

    public void saveBtn(ActionEvent event) {
        try {
            if (txtPatientID.getText().isEmpty() || txtDoctorID.getText().isEmpty() || txtTime.getText().isEmpty()) {
                showAlert("Error", "Please fill in all fields.");
                return;
            }

            int patientID = Integer.parseInt(txtPatientID.getText());
            int doctorID = Integer.parseInt(txtDoctorID.getText());
            String time = txtTime.getText();

            HospitalManagementSystem hms = HelloApplication.getHms();
            boolean isCreated = hms.createAppointment(doctorID, patientID, time);

            if (isCreated) {
                showAlert("Success", "Appointment created successfully.");
                loadAppointments();

                txtPatientID.clear();
                txtDoctorID.clear();
                txtTime.clear();
            } else {
                showAlert("Error", "Could not create appointment. (Doctor might not exist)");
            }

        } catch (NumberFormatException e) {
            showAlert("Error", "ID fields must be numbers!");
        } catch (IllegalArgumentException e) {
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