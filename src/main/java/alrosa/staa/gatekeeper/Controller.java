package alrosa.staa.gatekeeper;

import alrosa.staa.gatekeeper.objects.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private AnchorPane anchorPane = new AnchorPane();
    //Добавялем вертикальный сплиттер
    private final SplitPane splitVertical = new SplitPane();
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
    //Указываем путь к рисунку к объекту Сервер
    private Image imageServer = new Image("server.png");
    private ImageView imageViewServer = new ImageView(imageServer);
    //Добавляем контекстное меню
    private ContextMenu contextMenu = new ContextMenu();
    //Создание кнопки "Добавить"
    private MenuItem menuAdd = new MenuItem("Добавить");
    //Создание кнопки "Удалить"
    private MenuItem menuDelete = new MenuItem("Удалить");
    //Добавляем главную ветку дерева
    private final TreeItem<Global> mainSystem = new TreeItem<>(new MainSystem());
    //Добавляем корень дерева
    private final TreeView root = new TreeView(mainSystem);
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
            //К горизонтальному сплиттеру добавляем два окна, для дерева и объектов
            splitHorizontal.getItems().addAll(windowTree, windowObjects);
            //Добавляем рисунок в наш главный объект
            imageViewMain.setFitHeight(25);
            imageViewMain.setFitWidth(25);
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
            //В наше дерево добавляем контекстное меню
            root.setContextMenu(contextMenu);
            //Временно
            root.setOnMouseClicked(event -> {
                TreeItem<Global> selectedItem = (TreeItem<Global>) root.getSelectionModel().getSelectedItem();
                // Проверяем, что элемент не является пустым и что была нажата правая кнопка мыши
                if (selectedItem != null && event.getButton() == MouseButton.SECONDARY) {
                    // Получим enum выбранного элемента
                    Direction value = selectedItem.getValue().getDirection();
                    //Добавляем реакцию на нажатие кнопки "Добавить"
                    menuAdd.setOnAction(event1 -> {
                        switch (value) {
                            case MAINSYSTEM:
                                TreeItem server = new TreeItem<Global>(new Server());
                                selectedItem.getChildren().add(server);
                            default: System.out.println("Selected item: " + value);
                        }
                    });
                    //Добавляем реакцию на нажатие кнопки "Удалить"
                    menuDelete.setOnAction(event1 -> {
                        switch (value) {
                            case SERVER:
                                selectedItem.getParent().getChildren().remove(selectedItem);
                            default: System.out.println("Selected item:" + value);
                        }
                    });
                }
            });
    }
}