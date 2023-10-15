package alrosa.staa.gatekeeper.containers;

import alrosa.staa.gatekeeper.GateKeeper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OrganizationsContainer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent fxmlOrganizationsContainer = FXMLLoader.load(GateKeeper.class.getResource("bureau/organizationscontainer.fxml"));
            Scene scene = new Scene(fxmlOrganizationsContainer, 210, 165);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
