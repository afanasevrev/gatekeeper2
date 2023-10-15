package alrosa.staa.gatekeeper.containers;

import alrosa.staa.gatekeeper.GateKeeper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OrganizationContainer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent fxmlOrganizationContainer = FXMLLoader.load(GateKeeper.class.getResource("bureau/organizationcontainer.fxml"));
            Scene scene = new Scene(fxmlOrganizationContainer, 210, 165);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
