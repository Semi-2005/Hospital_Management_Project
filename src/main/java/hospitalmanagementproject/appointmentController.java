package hospitalmanagementproject;

import Management.HospitalManagementSystem;
import data_structures.hashtable.DoctorHashTable;
import javafx.scene.control.*;
import models.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.ArrayList;

public class appointmentController {

    @FXML
    public TextField txtPatientID;
    @FXML
    public TextField txtDoctorID;


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
    public ComboBox<String> cmbTime;

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
        cmbTime.getItems().addAll(
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
            if (txtPatientID.getText().isEmpty() || txtDoctorID.getText().isEmpty() || cmbTime.getValue()==null) {
                showAlert("Error", "Please fill in all fields.");
                return;
            }

            int patientID = Integer.parseInt(txtPatientID.getText());
            int doctorID = Integer.parseInt(txtDoctorID.getText());
            String time = cmbTime.getValue();

            HospitalManagementSystem hms = HelloApplication.getHms();
            int isCreated = hms.createAppointment(doctorID, patientID, time);
            if (isCreated==11) {
                showAlert("Success", "Appointment created successfully.");
                loadAppointments();

                txtPatientID.clear();
                txtDoctorID.clear();
                cmbTime.getSelectionModel().clearSelection();
            } else if(isCreated==0){
                showAlert("Error", "Could not create appointment:Doctor does not exist.");
            }else if(isCreated==1){
                showAlert("Error", "Could not create appointment:Doctor is not working during this time period.");
            }else if(isCreated==2){
                showAlert("Error", "Could not create appointment:Doctor have appointment this hour.");
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