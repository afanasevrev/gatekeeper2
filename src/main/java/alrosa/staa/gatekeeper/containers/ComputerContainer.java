package alrosa.staa.gatekeeper.containers;

import alrosa.staa.gatekeeper.GateKeeper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ComputerContainer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent fxmlComputerContainer = FXMLLoader.load(GateKeeper.class.getResource("computer/computercontainer.fxml"));
            Scene scene = new Scene(fxmlComputerContainer, 210, 165);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
