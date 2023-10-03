package alrosa.staa.gatekeeper;

import alrosa.staa.gatekeeper.containers.MainContainer;
import alrosa.staa.gatekeeper.objects.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private AnchorPane anchorPane = new AnchorPane();
    @FXML
    private Button buttonCreate = new Button();
    @FXML
    private Button buttonCancel = new Button();
    @FXML
    private ToggleButton toggleButtonServer = new ToggleButton();
    @FXML
    private ToggleButton toggleButtonComputer = new ToggleButton();
    @FXML
    private ToggleButton toggleButtonBureau = new ToggleButton();
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

    //Создаем экземпляр главного контейнера
    MainContainer mainContainer = new MainContainer();
    Stage stage = new Stage();
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
            //Добавляем реакции на нажите корня дерева
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
                                try {
                                    mainContainer.start(stage);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            default: System.out.println("Selected item: " + value);
                        }
                    });
                    //Добавляем реакцию на нажатие кнопки "Удалить"
                    menuDelete.setOnAction(event1 -> {
                        switch (value) {
                            case SERVER:
                                selectedItem.getParent().getChildren().remove(selectedItem);
                                break;
                            default: System.out.println("Selected item: " + value);
                        }
                    });
                }
            });
    }

    @FXML
    public void isPressedButtonCansel(ActionEvent event) {
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void isPressedButtonCreate(ActionEvent event) {
        TreeItem server = new TreeItem<Global>(new Server());
        mainSystem.getChildren().add(server);
    }
}