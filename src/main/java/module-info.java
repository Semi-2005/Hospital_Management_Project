module com.example.hospitalmanagementprojectgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.base;


    opens hospitalmanagementproject to javafx.fxml;
    exports hospitalmanagementproject;
}