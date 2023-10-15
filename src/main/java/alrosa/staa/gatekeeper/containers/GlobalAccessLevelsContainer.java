package alrosa.staa.gatekeeper.containers;

import alrosa.staa.gatekeeper.GateKeeper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GlobalAccessLevelsContainer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent fxmlGlobalAccessLevelsContainer = FXMLLoader.load(GateKeeper.class.getResource("bureau/globalaccesslevelscontainer.fxml"));
            Scene scene = new Scene(fxmlGlobalAccessLevelsContainer, 210, 165);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
