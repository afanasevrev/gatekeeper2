package alrosa.staa.gatekeeper.containers;

import alrosa.staa.gatekeeper.GateKeeper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CardReaderContainer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent fxmlCardReaderContainer = FXMLLoader.load(GateKeeper.class.getResource("cardreadercontainer.fxml"));
            Scene scene = new Scene(fxmlCardReaderContainer, 210, 165);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
