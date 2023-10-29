package alrosa.staa.gatekeeper;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AlternativeController implements Initializable {
    //Окно для кнопок
    @FXML
    private AnchorPane anchorPaneForButtons = new AnchorPane();
    //Окно для дерева
    @FXML
    private AnchorPane anchorPaneForItems = new AnchorPane();
    //Окно для объектов
    @FXML
    private AnchorPane anchorPaneForObjects = new AnchorPane();
    //Окно для журнала событий
    @FXML
    private AnchorPane anchorPaneForLogs = new AnchorPane();
    //Вертикальный сплиттер
    @FXML
    private SplitPane splitPaneVertical = new SplitPane();
    //Горизонтальный сплиттер
    @FXML
    private SplitPane splitPaneHorizontal = new SplitPane();
    //Кнопка создать
    @FXML
    private Button apply = new Button();
    //Кнопка отменить
    @FXML
    private Button cancel = new Button();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Прикрепляем вертикальный сплиттер к окну так, чтобы он растягивался вместе с ним
        AnchorPane.setLeftAnchor(splitPaneVertical, 0.0);
        AnchorPane.setBottomAnchor(splitPaneVertical, 0.0);
        AnchorPane.setRightAnchor(splitPaneVertical, 0.0);
        AnchorPane.setTopAnchor(splitPaneVertical, 0.0);
        //Прикрепляем горизонтальный сплиттер к окну так, чтобы оп растягивался вместе с ним
        AnchorPane.setLeftAnchor(splitPaneHorizontal, 0.0);
        AnchorPane.setBottomAnchor(splitPaneHorizontal, 0.0);
        AnchorPane.setRightAnchor(splitPaneHorizontal, 0.0);
        AnchorPane.setTopAnchor(splitPaneHorizontal, 0.0);
        //Прикрепляем кнопки к правому и нижнему краю окна
        AnchorPane.setRightAnchor(apply, 180.0);
        AnchorPane.setRightAnchor(cancel, 80.0);
        AnchorPane.setBottomAnchor(apply, 10.0);
        AnchorPane.setBottomAnchor(cancel, 10.0);
        //Прикрепляем окно для кнопок к краям
        AnchorPane.setLeftAnchor(anchorPaneForButtons, 0.0);
        AnchorPane.setBottomAnchor(anchorPaneForButtons, 0.0);
        AnchorPane.setRightAnchor(anchorPaneForButtons, 0.0);
        AnchorPane.setTopAnchor(anchorPaneForButtons, 0.0);

    }
}
