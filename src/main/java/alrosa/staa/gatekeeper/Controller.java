package alrosa.staa.gatekeeper;

import alrosa.staa.gatekeeper.containers.CardReaderContainer;
import alrosa.staa.gatekeeper.containers.MainContainer;
import alrosa.staa.gatekeeper.containers.PercoContainer;
import alrosa.staa.gatekeeper.containers.ServerContainer;
import alrosa.staa.gatekeeper.objects.bureau.Bureau;
import alrosa.staa.gatekeeper.objects.computer.Computer;
import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.global.Global;
import alrosa.staa.gatekeeper.objects.mainsystem.MainSystem;
import alrosa.staa.gatekeeper.objects.server.CardReader;
import alrosa.staa.gatekeeper.objects.server.Server;
import alrosa.staa.gatekeeper.objects.server.perco.PERCoC01;
import alrosa.staa.gatekeeper.objects.server.perco.Perco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //Главное окно админского консоля
    @FXML
    private AnchorPane anchorPane = new AnchorPane();
    //Кнопка добавить
    @FXML
    private Button buttonCreate = new Button();
    //Кнопка отменить
    @FXML
    private Button buttonCancel = new Button();
    //Кнопка для выбора сервера
    @FXML
    private ToggleButton toggleButtonServer = new ToggleButton();
    //При наведении мышки на кнопку, отображается "Сервер"
    @FXML
    private void handleToggleHoverServer() {
        toggleButtonServer.setText("Сервер");
    }
    //Когда мышь уходит с кнопки, надпись убирается
    @FXML
    private void handleToggleExitServer() {
        toggleButtonServer.setText("");
    }
    //Кнопка для выбора компьютера
    @FXML
    private ToggleButton toggleButtonComputer = new ToggleButton();
    //При наведении мышки на кнопку, отображается "Компьютер"
    @FXML
    private void handleToggleHoverComputer() {
        toggleButtonComputer.setText("Компьютер");
    }
    //Когда мышь уходит с кнопки, надпись убирается
    @FXML
    private void handleToggleExitComputer() {
        toggleButtonComputer.setText("");
    }
    private Tooltip tooltipBureau = new Tooltip("Бюро");
    //Кнопка для выбора бюро
    @FXML
    private ToggleButton toggleButtonBureau = new ToggleButton();
    //Кнопка для выбора оборудования Perco
    @FXML
    private ToggleButton toggleButtonPerco = new ToggleButton();
    //Кнопка для выбора контроллера PERC0-C01
    @FXML
    private ToggleButton toggleButtonPERCoC01 = new ToggleButton();
    //Кнопка для выбора считывателя
    @FXML
    private ToggleButton toggleButtonCardReader = new ToggleButton();

    //Добавим вертикальный сплиттер
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
    //Указываем путь к рисунку сервер
    private final Image imageServer = new Image("server.png");
    //Указываем путь к рисунку компьютер
    private final Image imageComputer = new Image("computer.png");
    //Указываем путь к рисунку бюро
    private final Image imageBureau = new Image("bureau.png");
    //Указываем путь к рисунку perco
    private final Image imagePerco = new Image("perco.png");
    //Указываем путь к рисунку PERCoC01
    private final Image imagePERCoC01 = new Image("PERCoC01.png");
    //Указываем путь к рисунку cardreader
    private final Image imageCardReader = new Image("cardreader.png");
    //Добавим контекстное меню
    private ContextMenu contextMenu = new ContextMenu();
    //Создание кнопки "Добавить"
    private MenuItem menuAdd = new MenuItem("Добавить");
    //Создание кнопки "Удалить"
    private MenuItem menuDelete = new MenuItem("Удалить");
    //Добавляем главную ветку дерева
    private TreeItem<Global> mainSystem = new TreeItem<>(new MainSystem());
    //Добавляем корень дерева
    private TreeView root = new TreeView(mainSystem);
    //Создадим статическую ветку
    private static TreeItem<Global> item;

    //Создаем экземпляр главного контейнера
    private MainContainer mainContainer = new MainContainer();
    //Создаем экземпляр для серверного контейнера
    private ServerContainer serverContainer = new ServerContainer();
    //Создаем экземпляр для контейнера оборудования Perco
    private PercoContainer percoContainer = new PercoContainer();
    //Создаем экземпляр для контейнера считывателя
    private CardReaderContainer cardReader = new CardReaderContainer();
    private Stage stage = new Stage();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
            //Добавляем всплывающий текст к кнопке Бюро
            Tooltip.install(toggleButtonBureau, new Tooltip("Бюро"));

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

            //Добавляем реакции на нажатие корня дерева
            root.setOnMouseClicked(event -> {
                TreeItem<Global> selectedItem = (TreeItem<Global>) root.getSelectionModel().getSelectedItem();
                //Проверяем, что элемент не является пустым и что была нажата правая кнопка мыши
                if (selectedItem != null && event.getButton() == MouseButton.SECONDARY) {
                    //Получим enum выбранного элемента
                    Direction value = selectedItem.getValue().getDirection();
                    //Добавляем реакцию на нажатие кнопки "Добавить"
                    menuAdd.setOnAction(event1 -> {
                        switch (value) {
                            case MAINSYSTEM:
                                item = selectedItem;
                                try {
                                    mainContainer.start(stage);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case SERVER:
                                item = selectedItem;
                                try {
                                    serverContainer.start(stage);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case PERCO:
                                item = selectedItem;
                                try {
                                    percoContainer.start(stage);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case PERCOC01:
                                item = selectedItem;
                                try {
                                    cardReader.start(stage);
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
                            case COMPUTER:
                            case BUREAU:
                            case PERCO:
                            case PERCOC01:
                            case CARDREADER:
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
        if (toggleButtonServer.isSelected()) {
            TreeItem server = new TreeItem<Global>(new Server());
            ImageView imageViewServer = new ImageView(imageServer);
            imageViewServer.setFitWidth(25);
            imageViewServer.setFitHeight(25);
            server.setGraphic(imageViewServer);
            item.getChildren().add(server);
        } else if (toggleButtonComputer.isSelected()) {
            TreeItem computer = new TreeItem<Global>(new Computer());
            ImageView imageViewComputer = new ImageView(imageComputer);
            imageViewComputer.setFitWidth(25);
            imageViewComputer.setFitHeight(25);
            computer.setGraphic(imageViewComputer);
            item.getChildren().add(computer);
        } else if (toggleButtonBureau.isSelected()) {
            TreeItem bureau = new TreeItem<Global>(new Bureau());
            ImageView imageViewBureau = new ImageView(imageBureau);
            imageViewBureau.setFitWidth(25);
            imageViewBureau.setFitHeight(25);
            bureau.setGraphic(imageViewBureau);
            item.getChildren().add(bureau);
        } else if (toggleButtonPerco.isSelected()) {
            TreeItem perco = new TreeItem<Global>(new Perco());
            ImageView imageViewPerco = new ImageView(imagePerco);
            imageViewPerco.setFitWidth(25);
            imageViewPerco.setFitHeight(25);
            perco.setGraphic(imageViewPerco);
            item.getChildren().add(perco);
        } else if (toggleButtonPERCoC01.isSelected()) {
            TreeItem percoc01 = new TreeItem<Global>(new PERCoC01());
            ImageView imageViewPerco = new ImageView(imagePERCoC01);
            imageViewPerco.setFitWidth(25);
            imageViewPerco.setFitHeight(25);
            percoc01.setGraphic(imageViewPerco);
            item.getChildren().add(percoc01);
        } else if (toggleButtonCardReader.isSelected()) {
            TreeItem cardReader = new TreeItem<Global>(new CardReader());
            ImageView imageViewCardReader = new ImageView(imageCardReader);
            imageViewCardReader.setFitWidth(25);
            imageViewCardReader.setFitHeight(25);
            cardReader.setGraphic(imageViewCardReader);
            item.getChildren().add(cardReader);
        }
        else {
            System.out.println("NE VYBRAN OBJECT");
        }
    }
}