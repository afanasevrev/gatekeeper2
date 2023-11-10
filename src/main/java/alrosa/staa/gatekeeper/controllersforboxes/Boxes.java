package alrosa.staa.gatekeeper.controllersforboxes;

import alrosa.staa.gatekeeper.GateKeeper;
import alrosa.staa.gatekeeper.objects.Direction;
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

public class Boxes  {
    public Parent loader;
    public void init(Direction direction) {
        try {
            switch (direction) {
                case MAINSYSTEM:
                    loader = new FXMLLoader().load(GateKeeper.class.getResource("controllersforboxes/mainsystem.fxml"));
                    break;
                case SERVER:
                    loader = new FXMLLoader().load(GateKeeper.class.getResource("controllersforboxes/server.fxml"));
                    break;
                default:
                    loader = new FXMLLoader().load(GateKeeper.class.getResource("controllersforboxes/default.fxml"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
