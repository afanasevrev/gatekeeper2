package alrosa.staa.gatekeeper;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private AnchorPane anchorPane = new AnchorPane();
    //Добавялем вертикальный сплиттер
    private SplitPane splitVertical = new SplitPane();
    //Добавляем корень дерева
    private TreeView<String> root = new TreeView<String>();
    //Добавляем главное дерево
    private TreeItem<String> mainSystem = new TreeItem<String>("Главный");
    //Добавляем верхнее окно
    private AnchorPane windowUp = new AnchorPane();
    //Добавляем нижнее окно
    private AnchorPane windowDown = new AnchorPane();
    //Добавляем горизонтальный сплиттер
    private SplitPane splitHorizontal = new SplitPane();
    //Добавляем окно для дерева
    private AnchorPane windowTree = new AnchorPane();
    //Добавляем окно для объектов
    private AnchorPane windowObjects = new AnchorPane();
    //Указываем путь к главной иконке
    private Image imageMain = new Image("main.png");
    private ImageView imageViewMain = new ImageView();

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
            //
    }
}