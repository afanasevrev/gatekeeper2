package alrosa.staa.gatekeeper.controllersforboxes;

import alrosa.staa.gatekeeper.GateKeeper;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BoxesController extends Application  {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent fxml = FXMLLoader.load(GateKeeper.class.getResource("controllersforboxes/mainsystem.fxml"));
            Scene scene = new Scene(fxml, 460, 200);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
