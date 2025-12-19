package hospitalmanagementproject;

import Management.HospitalManagementSystem;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.RandomGenerator;

import java.io.IOException;

public class HelloApplication extends Application {
    private static HospitalManagementSystem hms = new HospitalManagementSystem();
    @Override
    public void start(Stage stage) throws IOException {
        createInitialDoctor();
        createInitialPatient();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hospital Management System");
        stage.setScene(scene);
        stage.show();
    }


    //This method creates doctor objects initially
    public void createInitialDoctor(){
        String[] nameArray = {"Ahmet Yılmaz", "Mehmet Kaya", "Ayşe Demir", "Elif Çetin",
                "Murat Şahin", "Zeynep Arslan"};
        String[] departmentArray = {"Cardiology", "Neurology", "Orthopedics",
                "Pediatrics", "General Surgery", "Dermatology"};
        for (int i =0 ; i<6 ; i++){
            int ID = RandomGenerator.nextInt(100,999);
            String name = nameArray[i];
            String department = departmentArray[i];
            getHms().addDoctor(ID,name,department,"08:00","18:00");
        }
    }

    //This method creates patient objects initially
    public void createInitialPatient(){
        String[] nameArray ={"Ali Koç", "Burak Yıldız","Ufuk Akkuzu"};
        for( int i=0 ; i<3 ; i++ ){
            String name= nameArray[i];
            //Create Patient method autogenerate unique ID with use IDUtil class
            getHms().createPatient(name,(i+3)*9,"male");
        }
    }

    //Provides access to the same HospitalManagementSystem instance for all controller screensx
    public static HospitalManagementSystem getHms(){
        return hms;
    }
}
