package hospitalmanagementproject;

import Management.HospitalManagementSystem;
import models.ERPatient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;
import java.util.ArrayList;

public class erOperationsController {

    private static String lastStatusMessage = "";

    @FXML
    public TableView<ERPatient> tableER;

    @FXML
    public TableColumn<ERPatient, Integer> colID;
    @FXML
    public TableColumn<ERPatient, Integer> colSeverity;
    @FXML
    public TableColumn<ERPatient, String> colTime;

    @FXML
    public Label lblNextPatient;

    @FXML
    public TextField txtPatientID;
    @FXML
    public Slider sliderSeverity;
    @FXML
    public Label lblSeverityValue;

    @FXML
    public Label lblClock;

    private sceneChanger sceneChanger = new sceneChanger();

    public void initialize() {
        if (lblClock != null) {
            ClockManager.startClock(lblClock);
        }

        if (lblNextPatient != null && !lastStatusMessage.isEmpty()) {
            lblNextPatient.setText(lastStatusMessage);
        }

        sliderSeverity.setMin(1);
        sliderSeverity.setMax(10);
        sliderSeverity.setValue(1);
        sliderSeverity.setBlockIncrement(1);
        sliderSeverity.setMajorTickUnit(1);
        sliderSeverity.setMinorTickCount(0);
        sliderSeverity.setSnapToTicks(true);

        if (lblSeverityValue != null) {
            lblSeverityValue.setText("1");
            sliderSeverity.valueProperty().addListener((observable, oldValue, newValue) -> {
                lblSeverityValue.setText(String.valueOf(newValue.intValue()));
            });
        }

        if (colID != null) {
            colID.setCellValueFactory(data ->
                    new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getPatientId()));
        }
        if (colSeverity != null) {
            colSeverity.setCellValueFactory(data ->
                    new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getSeverity()));
        }
        if (colTime != null) {
            colTime.setCellValueFactory(data ->
                    new javafx.beans.property.SimpleStringProperty(data.getValue().getArrivalTime()));
        }

        refreshQueueTable();
    }

    public void refreshQueueTable() {
        try {
            if (tableER == null) return;

            HospitalManagementSystem hms = HelloApplication.getHms();
            ArrayList<ERPatient> list = hms.getErQueue().getSnapshot();

            if (list != null) {
                ObservableList<ERPatient> obsList = FXCollections.observableArrayList(list);
                tableER.setItems(obsList);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addBtn(ActionEvent event) {
        try {
            if (txtPatientID.getText().isEmpty()) {
                showAlert("Error", "Please enter a Patient ID.");
                return;
            }

            int patientID = Integer.parseInt(txtPatientID.getText());
            int severity = (int) sliderSeverity.getValue();

            HospitalManagementSystem hms = HelloApplication.getHms();

            models.Patient patient = hms.findPatient(patientID);

            if (patient == null) {
                showAlert("Error", "Patient ID not found! Please register the patient first.");
                return;
            }

            hms.addERPatient(patientID, severity);

            showAlert("Success", "Patient added to ER Queue with severity: " + severity);

            refreshQueueTable();

            txtPatientID.clear();
            sliderSeverity.setValue(1);

        } catch (NumberFormatException e) {
            showAlert("Error", "Patient ID must be a number!");
        } catch (Exception e) {
            showAlert("Error", "An unexpected error occurred: " + e.getMessage());
        }
    }

    public void treatBtn(ActionEvent event) {
        try {
            HospitalManagementSystem hms = HelloApplication.getHms();
            ERPatient treated = hms.treatNextERPatient();

            if (treated != null) {
                models.Patient pInfo = hms.findPatient(treated.getPatientId());
                String pName = (pInfo != null) ? pInfo.getName() : "Unknown";

                String message = "Treating Patient: " + pName + " (ID: " + treated.getPatientId() + ") - Severity: " + treated.getSeverity();

                lastStatusMessage = message;

                if (lblNextPatient != null) {
                    lblNextPatient.setText(message);
                } else {
                    showAlert("Treatment Started", message);
                }

                refreshQueueTable();
            } else {
                String emptyMsg = "Queue is empty!";
                lastStatusMessage = emptyMsg;
                if (lblNextPatient != null) lblNextPatient.setText(emptyMsg);
                showAlert("Info", "No patients in queue.");
            }

        } catch (Exception e) {
            showAlert("Error", "Treatment error: " + e.getMessage());
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