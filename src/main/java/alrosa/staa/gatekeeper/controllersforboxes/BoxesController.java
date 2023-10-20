package alrosa.staa.gatekeeper.controllersforboxes;

import alrosa.staa.gatekeeper.GateKeeper;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BoxesController implements Initializable {

    @FXML
    private Button apply = new Button();
    @FXML
    private Button cancel = new Button();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AnchorPane.setBottomAnchor(apply, 0.0);
        AnchorPane.setLeftAnchor(apply, 0.0);
        AnchorPane.setRightAnchor(apply, 0.0);
        AnchorPane.setTopAnchor(apply, 0.0);
        AnchorPane.setBottomAnchor(cancel, 0.0);
        AnchorPane.setLeftAnchor(cancel, 0.0);
        AnchorPane.setRightAnchor(cancel, 0.0);
        AnchorPane.setTopAnchor(cancel, 0.0);
    }
}
