package hospitalmanagementproject;

import Management.HospitalManagementSystem;
import data_structures.tree.GeneralTreeNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import java.io.IOException;

public class directoryController {

    @FXML
    public TreeView<String> treeDirectory;

    @FXML
    public Label lblClock;

    private sceneChanger sceneChanger = new sceneChanger();

    public void initialize() {
        if (lblClock != null) {
            ClockManager.startClock(lblClock);
        }
        loadDirectoryTree();
    }

    private void loadDirectoryTree() {
        try {
            HospitalManagementSystem hms = HelloApplication.getHms();
            GeneralTreeNode rootNode = hms.getDirectoryTree().getRoot();

            if (rootNode != null) {
                TreeItem<String> fxRoot = createTreeItem(rootNode);
                treeDirectory.setRoot(fxRoot);
                fxRoot.setExpanded(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private TreeItem<String> createTreeItem(GeneralTreeNode node) {

        TreeItem<String> item = new TreeItem<>(node.getData().toString());


        for (GeneralTreeNode child : node.getChildren()) {
            item.getChildren().add(createTreeItem(child));
        }


        item.setExpanded(true);
        return item;
    }

    public void goBack(ActionEvent event) throws IOException {
        sceneChanger.changeScene(event, "hello-view.fxml");
    }
}