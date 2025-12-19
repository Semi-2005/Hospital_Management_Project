package hospitalmanagementproject;

import Management.HospitalManagementSystem;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.io.IOException;
import java.util.ArrayList;

public class reportsController {

    @FXML
    public TableView tableReports;

    @FXML
    public Label lblClock;

    private sceneChanger sceneChanger = new sceneChanger();

    public void initialize() {
        if (lblClock != null) {
            ClockManager.startClock(lblClock);
        }
    }

    public void listAllPatients(ActionEvent event) {
        tableReports.getColumns().clear();
        tableReports.getItems().clear();

        TableColumn<models.Patient, Integer> colID = new TableColumn<>("Patient ID");
        colID.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getId()));

        TableColumn<models.Patient, String> colName = new TableColumn<>("Name");
        colName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));

        TableColumn<models.Patient, Integer> colAge = new TableColumn<>("Age");
        colAge.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getAge()));

        TableColumn<models.Patient, String> colGender = new TableColumn<>("Gender");
        colGender.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getGender()));

        tableReports.getColumns().addAll(colID, colName, colAge, colGender);

        try {
            HospitalManagementSystem hms = HelloApplication.getHms();
            ArrayList<models.Patient> list = hms.getAllPatients();
            if (list != null) {
                tableReports.setItems(FXCollections.observableArrayList(list));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listAllDoctors(ActionEvent event) {
        tableReports.getColumns().clear();
        tableReports.getItems().clear();

        TableColumn<models.Doctor, Integer> colID = new TableColumn<>("Doctor ID");
        colID.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getId()));

        TableColumn<models.Doctor, String> colName = new TableColumn<>("Name");
        colName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));

        TableColumn<models.Doctor, String> colDept = new TableColumn<>("Department");
        colDept.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDepartment()));

        tableReports.getColumns().addAll(colID, colName, colDept);

        try {
            HospitalManagementSystem hms = HelloApplication.getHms();
            ArrayList<models.Doctor> list = hms.getAllDoctors();
            if (list != null) {
                tableReports.setItems(FXCollections.observableArrayList(list));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showERQueue(ActionEvent event) {
        tableReports.getColumns().clear();
        tableReports.getItems().clear();

        TableColumn<models.ERPatient, Integer> colID = new TableColumn<>("Patient ID");
        colID.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getPatientId()));

        TableColumn<models.ERPatient, Integer> colSev = new TableColumn<>("Severity");
        colSev.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getSeverity()));

        TableColumn<models.ERPatient, String> colTime = new TableColumn<>("Arrival Time");
        colTime.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getArrivalTime()));

        tableReports.getColumns().addAll(colID, colSev, colTime);

        try {
            HospitalManagementSystem hms = HelloApplication.getHms();
            ArrayList<models.ERPatient> list = hms.getErQueue().getSnapshot();
            if (list != null) {
                tableReports.setItems(FXCollections.observableArrayList(list));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dailyVisitSummary(ActionEvent event) {
        tableReports.getColumns().clear();
        tableReports.getItems().clear();

        TableColumn<models.Appointment, Integer> colDoc = new TableColumn<>("Doctor ID");
        colDoc.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getDoctorId()));

        TableColumn<models.Appointment, Integer> colPat = new TableColumn<>("Patient ID");
        colPat.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getPatientId()));

        TableColumn<models.Appointment, String> colTime = new TableColumn<>("Time");
        colTime.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTime()));

        tableReports.getColumns().addAll(colDoc, colPat, colTime);

        try {
            HospitalManagementSystem hms = HelloApplication.getHms();
            ArrayList<models.Appointment> list = hms.listAllAppointments();
            if (list != null) {
                tableReports.setItems(FXCollections.observableArrayList(list));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancelBtn(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "hello-view.fxml");
    }
}