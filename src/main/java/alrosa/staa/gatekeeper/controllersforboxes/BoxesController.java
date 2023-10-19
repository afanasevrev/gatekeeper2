package alrosa.staa.gatekeeper.controllersforboxes;

import alrosa.staa.gatekeeper.GateKeeper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BoxesController  {
    //Грузим окно для главной системы
    private FXMLLoader fxmlMainSystem = new FXMLLoader(GateKeeper.class.getResource("boxes/mainsystem.fxml"));;
    public AnchorPane paneMainSystem;
    @FXML
    private Button apply = new Button();
    @FXML
    private Button cancel = new Button();
    public BoxesController() {
        try {
            paneMainSystem = fxmlMainSystem.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Привязываем paneMainSystem к окну так, чтобы он растягивался вместе с окном
        AnchorPane.setBottomAnchor(paneMainSystem, 0.0);
        AnchorPane.setLeftAnchor(paneMainSystem, 0.0);
        AnchorPane.setRightAnchor(paneMainSystem, 0.0);
        AnchorPane.setTopAnchor(paneMainSystem, 0.0);

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
