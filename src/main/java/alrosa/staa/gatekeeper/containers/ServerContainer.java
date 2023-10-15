package alrosa.staa.gatekeeper.containers;

import alrosa.staa.gatekeeper.GateKeeper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerContainer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent fxmlServerContainer = FXMLLoader.load(GateKeeper.class.getResource("server/servercontainer.fxml"));
            Scene scene = new Scene(fxmlServerContainer, 210, 165);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
