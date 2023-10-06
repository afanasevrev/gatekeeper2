package alrosa.staa.gatekeeper.containers;

import alrosa.staa.gatekeeper.GateKeeper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PercoContainer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent fxmlPercoContainer = FXMLLoader.load(GateKeeper.class.getResource("percocontainer.fxml"));
            Scene scene = new Scene(fxmlPercoContainer, 210, 165);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
