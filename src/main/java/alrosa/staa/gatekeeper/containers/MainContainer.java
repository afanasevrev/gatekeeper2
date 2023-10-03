package alrosa.staa.gatekeeper.containers;

import alrosa.staa.gatekeeper.GateKeeper;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class MainContainer extends Application {
    @FXML
    private Button buttonCreate = new Button();
    @FXML
    private Button buttonCancel = new Button();
    @FXML
    private ToggleButton toggleButtonServer = new ToggleButton();
    @FXML
    private ToggleButton toggleButtonComputer = new ToggleButton();
    @FXML
    private ToggleButton toggleButtonBureau = new ToggleButton();

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
    @FXML
    public void isPressedButtonCansel(ActionEvent event) {
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void isPressedButtonCreate(ActionEvent event) {
        if (toggleButtonServer.isSelected()) System.out.println("Pressed toggleButtonServer");
    }
}
