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

public class BoxesController  extends Application {
    //Грузим окно для главной системы
    //private FXMLLoader fxmlMainSystem = new FXMLLoader(GateKeeper.class.getResource("boxes/mainsystem.fxml"));;
    public AnchorPane paneMainSystem;

    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader fxmlMainSystem = new FXMLLoader(GateKeeper.class.getResource("boxes/mainsystem.fxml"));
            paneMainSystem = fxmlMainSystem.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Привязываем paneMainSystem к окну так, чтобы он растягивался вместе с окном
        AnchorPane.setBottomAnchor(paneMainSystem, 0.0);
        AnchorPane.setLeftAnchor(paneMainSystem, 0.0);
        AnchorPane.setRightAnchor(paneMainSystem, 0.0);
        AnchorPane.setTopAnchor(paneMainSystem, 0.0);
    }
}
