package alrosa.staa.gatekeeper.containers;

import alrosa.staa.gatekeeper.GateKeeper;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainContainer extends Application {
    @FXML
    private Button buttonCreate = new Button();
    @FXML
    private Button buttonCancel = new Button();


    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent fxmlMainContainer = FXMLLoader.load(GateKeeper.class.getResource("maincontainer.fxml"));
            Scene scene = new Scene(fxmlMainContainer, 210, 165);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
