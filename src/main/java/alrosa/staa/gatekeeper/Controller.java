package alrosa.staa.gatekeeper;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private AnchorPane anchorPane = new AnchorPane();
    //Добавялем вертикальный сплиттер
    private final SplitPane splitVertical = new SplitPane();
    //Добавляем главную ветку дерева
    private final TreeItem<String> mainSystem = new TreeItem<>("Главный");
    //Добавляем корень дерева
    private final TreeView<String> root = new TreeView<>(mainSystem);
    //Добавляем верхнее окно
    private final AnchorPane windowUp = new AnchorPane();
    //Добавляем нижнее окно
    private final AnchorPane windowDown = new AnchorPane();
    //Добавляем горизонтальный сплиттер
    private final SplitPane splitHorizontal = new SplitPane();
    //Добавляем окно для дерева
    private final AnchorPane windowTree = new AnchorPane();
    //Добавляем окно для объектов
    private final AnchorPane windowObjects = new AnchorPane();
    //Указываем путь к главному рисунку
    private final Image imageMain = new Image("main.png");
    private final ImageView imageViewMain = new ImageView(imageMain);
    //Добавялем круг, чтоб поместить туда наш рисунок
    private final Circle circleMain = new Circle();
    //Добавляем контекстное меню
    ContextMenu contextMenu = new ContextMenu();
    //Создание кнопки "Добавить"
    MenuItem menuAdd = new MenuItem("Добавить");
    //Создание кнопки "Удалить"
    MenuItem menuDelete = new MenuItem("Удалить");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
            //Привязываем сплиттер к окну так, чтобы он растягивался вместе с окном
            AnchorPane.setBottomAnchor(splitVertical, 0.0);
            AnchorPane.setLeftAnchor(splitVertical, 0.0);
            AnchorPane.setRightAnchor(splitVertical, 0.0);
            AnchorPane.setTopAnchor(splitVertical, 0.0);
            //Объявляем, что наш сплиттер вертикальный
            splitVertical.setOrientation(Orientation.VERTICAL);
            //Добавляем к сплиттеру левый и правый окна
            splitVertical.getItems().addAll(windowUp, windowDown);
            //Добавляем к окну вертикальный сплиттер
            anchorPane.getChildren().addAll(splitVertical);
            //Объявляем, что наш второй сплиттер горизонтальный
            splitHorizontal.setOrientation(Orientation.HORIZONTAL);
            //Привязываем горизонтальный сплиттер к окну так, чтобы он растягивался вместе с окном
            AnchorPane.setBottomAnchor(splitHorizontal, 0.0);
            AnchorPane.setLeftAnchor(splitHorizontal, 0.0);
            AnchorPane.setRightAnchor(splitHorizontal, 0.0);
            AnchorPane.setTopAnchor(splitHorizontal, 0.0);
            //К верхнему окну добавляем горизонтальный сплиттер
            windowUp.getChildren().addAll(splitHorizontal);
            //К горизонтальному спиттеру добавляем два окна, для дерева и объектов
            splitHorizontal.getItems().addAll(windowTree, windowObjects);
            //Добавляем в круг наш рисунок
            imageViewMain.setFitHeight(30);
            imageViewMain.setFitWidth(30);
            circleMain.setRadius(40);
            imageViewMain.setClip(circleMain);
            mainSystem.setGraphic(imageViewMain);
            //Растягиваем наше дерево в окне так, чтобы он растягивался вместе с окном
            AnchorPane.setBottomAnchor(root, 0.0);
            AnchorPane.setLeftAnchor(root, 0.0);
            AnchorPane.setRightAnchor(root, 0.0);
            AnchorPane.setTopAnchor(root, 0.0);
            //В окно для дерева добавляем наше дерево с надписью "Главный"
            windowTree.getChildren().addAll(root);
            //В контекстное меню добавляем кнопки
            contextMenu.getItems().addAll(menuAdd, menuDelete);
            root.setContextMenu(contextMenu);
    }
}