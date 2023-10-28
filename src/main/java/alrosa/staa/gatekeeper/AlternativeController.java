package alrosa.staa.gatekeeper;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AlternativeController implements Initializable {
    @FXML
    private AnchorPane anchorPaneForButtons = new AnchorPane();
    @FXML
    private SplitPane splitPaneVertical = new SplitPane();
    @FXML
    private SplitPane splitPaneHorizontal = new SplitPane();
    @FXML
    private Button apply = new Button();
    @FXML
    private Button cancel = new Button();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AnchorPane.setLeftAnchor(splitPaneVertical, 0.0);
        AnchorPane.setBottomAnchor(splitPaneVertical, 0.0);
        AnchorPane.setRightAnchor(splitPaneVertical, 0.0);
        AnchorPane.setTopAnchor(splitPaneVertical, 0.0);

        AnchorPane.setLeftAnchor(splitPaneHorizontal, 0.0);
        AnchorPane.setBottomAnchor(splitPaneHorizontal, 0.0);
        AnchorPane.setRightAnchor(splitPaneHorizontal, 0.0);
        AnchorPane.setTopAnchor(splitPaneHorizontal, 0.0);

        AnchorPane.setBottomAnchor(apply, 10.0);
        AnchorPane.setBottomAnchor(cancel, 10.0);

        AnchorPane.setLeftAnchor(anchorPaneForButtons, 0.0);
        AnchorPane.setBottomAnchor(anchorPaneForButtons, 0.0);
        AnchorPane.setRightAnchor(anchorPaneForButtons, 0.0);
        AnchorPane.setTopAnchor(anchorPaneForButtons, 0.0);
    }
}
