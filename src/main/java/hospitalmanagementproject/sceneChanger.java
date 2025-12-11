package hospitalmanagementproject;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
public class sceneChanger {

    public void changeScene(ActionEvent event, String fxmlFile) throws IOException {
        // 1. Yeni FXML dosyasını yükle
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        // 2. Tıklanan butondan (event) sahne penceresini (Stage) al
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // 3. Yeni sahneyi oluştur ve pencereye ata
        Scene scene = new Scene(root);
        stage.setScene(scene);

        // --- YENİ EKLENEN KISIMLAR ---

        // A. Pencereyi yeni içeriğin boyutuna göre otomatik ayarla (Sıkışmayı veya boşluğu önler)
        stage.sizeToScene();

        // B. Pencereyi ekranın tam ortasına taşı
        stage.centerOnScreen();

        // -----------------------------

        stage.show();
    }
}
