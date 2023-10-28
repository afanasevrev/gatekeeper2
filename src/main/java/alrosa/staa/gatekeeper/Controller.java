package alrosa.staa.gatekeeper;

import alrosa.staa.gatekeeper.containers.*;
import alrosa.staa.gatekeeper.controllersforboxes.BoxesController;
import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.bureau.Bureau;
import alrosa.staa.gatekeeper.objects.bureau.Man;
import alrosa.staa.gatekeeper.objects.bureau.Woman;
import alrosa.staa.gatekeeper.objects.bureau.admins.Administrators;
import alrosa.staa.gatekeeper.objects.bureau.card_layouts.CardLayout;
import alrosa.staa.gatekeeper.objects.bureau.card_layouts.CardLayouts;
import alrosa.staa.gatekeeper.objects.bureau.cards.Card;
import alrosa.staa.gatekeeper.objects.bureau.cards.Cards;
import alrosa.staa.gatekeeper.objects.bureau.global_access_levels.GlobalAccessLevel;
import alrosa.staa.gatekeeper.objects.bureau.global_access_levels.GlobalAccessLevels;
import alrosa.staa.gatekeeper.objects.bureau.operators.Operators;
import alrosa.staa.gatekeeper.objects.bureau.organizations.Office;
import alrosa.staa.gatekeeper.objects.bureau.organizations.Organization;
import alrosa.staa.gatekeeper.objects.bureau.organizations.Organizations;
import alrosa.staa.gatekeeper.objects.bureau.positions.Position;
import alrosa.staa.gatekeeper.objects.bureau.positions.Positions;
import alrosa.staa.gatekeeper.objects.bureau.users.Users;
import alrosa.staa.gatekeeper.objects.computer.Computer;
import alrosa.staa.gatekeeper.objects.computer.console.Console;
import alrosa.staa.gatekeeper.objects.global.Global;
import alrosa.staa.gatekeeper.objects.mainsystem.MainSystem;
import alrosa.staa.gatekeeper.objects.server.CardReader;
import alrosa.staa.gatekeeper.objects.server.Server;
import alrosa.staa.gatekeeper.objects.server.perco.PERCoC01;
import alrosa.staa.gatekeeper.objects.server.perco.Perco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //Грузим окно для главной системы
    private BoxesController boxesController = new BoxesController();
    private AnchorPane paneMainSystem = new AnchorPane();
    @FXML
    TextField textField = new TextField();
    @FXML
    private Button apply = new Button();
    @FXML
    private Button cancel = new Button();

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
    @FXML
    private ToggleButton toggleButtonComputer = new ToggleButton();
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
    //Кнопка для выбора сотрудников
    @FXML
    private ToggleButton toggleButtonUsers = new ToggleButton();
    //Кнопка для выбора Администраторов
    @FXML
    private ToggleButton toggleButtonAdmins = new ToggleButton();
    //Кнопка для выбора Операторов
    @FXML
    private ToggleButton toggleButtonOperators = new ToggleButton();
    @FXML
    private ToggleButton toggleButtonCards = new ToggleButton();
    @FXML
    private ToggleButton toggleButtonCardLayouts = new ToggleButton();
    @FXML
    private ToggleButton toggleButtonGlobalAccessLevels = new ToggleButton();
    @FXML
    private ToggleButton toggleButtonPositions = new ToggleButton();
    @FXML
    private ToggleButton toggleButtonOrganizations = new ToggleButton();
    @FXML
    private ToggleButton toggleButtonMan = new ToggleButton();
    @FXML
    private ToggleButton toggleButtonWoman = new ToggleButton();
    @FXML
    private ToggleButton toggleButtonCard = new ToggleButton();
    @FXML
    private ToggleButton toggleButtonCardLayout = new ToggleButton();
    @FXML
    private ToggleButton toggleButtonGlobalAccessLevel = new ToggleButton();
    @FXML
    private ToggleButton toggleButtonPosition = new ToggleButton();
    @FXML
    private ToggleButton toggleButtonOrganization = new ToggleButton();
    @FXML
    private ToggleButton toggleButtonOffice = new ToggleButton();
    @FXML
    private ToggleButton toggleButtonConsole = new ToggleButton();
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
    //Указываем путь к рисунку users
    private final Image imageUsers = new Image("users.png");
    //Указываем путь к рисунку admins
    private final Image imageAdmins = new Image("admins.png");
    //Указываем путь к рисунку operators
    private final Image imageOperators = new Image("operators.png");
    //Указываем путь к рисунку cards
    private final Image imageCards = new Image("cards.png");
    //Указываем путь к рисунку макеты карт
    private final Image imageCardLayouts = new Image("card_layouts.png");
    //Указываем путь к рисунку global_access_levels
    private final Image imageGlobalAccessLevels = new Image("global_access_levels.png");
    //Указываем путь к рисунку positions
    private final Image imagePositions = new Image("positions.png");
    //Указываем путь к рисунку organizations
    private final Image imageOrganizations = new Image("organizations.png");
    //Указываем путь к рисунку man
    private final Image imageMan = new Image("man.png");
    //Указываем путь к рисунку woman
    private final Image imageWoman = new Image("woman.png");
    //Указываем путь к рисунку card
    private final Image imageCard = new Image("card.png");
    //Указываем путь к рисунку card_layout
    private final Image imageCardLayout = new Image("card_layout.png");
    //Указываем путь к рисунку global_access_level
    private final Image imageGlobalAccessLevel = new Image("global_access_level.png");
    //Указываем путь к рисунку position
    private final Image imagePosition = new Image("position.png");
    //Указываем путь к рисунку organization
    private final Image imageOrganization = new Image("organization.png");
    //Указываем путь к рисунку office
    private final Image imageOffice = new Image("office.png");
    //Указываем путь к рисунку console
    private final Image imageConsole = new Image("console.png");
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
    //Создаем экземпляр для контейнера Считывателя
    private CardReaderContainer cardReaderContainer = new CardReaderContainer();
    //Создаем экземпляр для контейнера Бюро
    private BureauContainer bureauContainer = new BureauContainer();
    //Создаем экземпляр для контейнера Пользователи/Администраторы/Операторы
    private UsersContainer usersContainer = new UsersContainer();
    //Создаем экземпляр для контейнера Карты доступа
    private CardsContainer cardsContainer = new CardsContainer();
    //Создаем экземпляр для контейнера Макеты карт
    private CardLayoutsContainer cardLayoutsContainer = new CardLayoutsContainer();
    //Создаем экземпляр для контейнера Глобальные уровни доступа
    private GlobalAccessLevelsContainer globalAccessLevelsContainer = new GlobalAccessLevelsContainer();
    //Создаем экземпляр для контейнера Должности
    private PositionsContainer positionsContainer = new PositionsContainer();
    //Создаем экземпляр для контейнера Организации
    private OrganizationsContainer organizationsContainer = new OrganizationsContainer();
    //Создаем экземпляр для контейнера Отдела
    private OrganizationContainer organizationContainer = new OrganizationContainer();
    //Создаем экземпляр для контейнера Компьютер
    private ComputerContainer computerContainer = new ComputerContainer();
    private Stage stage = new Stage();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
            textField.setText("Главная система");

            AnchorPane.setBottomAnchor(apply, 0.0);
            AnchorPane.setBottomAnchor(cancel, 0.0);
            //Привязываем paneMainSystem к окну так, чтобы он растягивался вместе с окном
            AnchorPane.setBottomAnchor(paneMainSystem, 0.0);
            AnchorPane.setLeftAnchor(paneMainSystem, 0.0);
            AnchorPane.setRightAnchor(paneMainSystem, 0.0);
            AnchorPane.setTopAnchor(paneMainSystem, 0.0);

            //Добавляем всплывающий текст к кнопке Сервер
            Tooltip.install(toggleButtonServer, new Tooltip("Сервер"));
            //Добавляем всплывающий текст к кнопке Компьютер
            Tooltip.install(toggleButtonComputer, new Tooltip("Компьютер"));
            //Добавляем всплывающий текст к кнопке Бюро
            Tooltip.install(toggleButtonBureau, new Tooltip("Бюро"));
            //Добавляем всплывающий текст к кнопке оборудование Perco
            Tooltip.install(toggleButtonPerco, new Tooltip("Оборудование Perco"));
            //Добавляем всплывающий текст к кнопке PERCo-C01
            Tooltip.install(toggleButtonPERCoC01, new Tooltip("Контроллер PERCo-C01"));
            //Добавялем всплывающий текст к кнопке Считыватель
            Tooltip.install(toggleButtonCardReader, new Tooltip("Считыватель"));
            //Добавляем всплывающий текст к кнопке Пользователи
            Tooltip.install(toggleButtonUsers, new Tooltip("Пользователи"));
            //Добавляем всплывающий текст к кнопке Администраторы
            Tooltip.install(toggleButtonAdmins, new Tooltip("Администраторы"));
            //Добавляем всплывающий текст к кнопке Операторы
            Tooltip.install(toggleButtonOperators, new Tooltip("Операторы"));
            //Добавляем всплывающий текст к кнопке Карты
            Tooltip.install(toggleButtonCards, new Tooltip("Карты"));
            //Добавляем всплывающий текст к кнопке Макеты карт
            Tooltip.install(toggleButtonCardLayouts, new Tooltip("Макеты карт"));
            //Добавляем всплывающий текст к кнопке Глобальные уровни доступа
            Tooltip.install(toggleButtonGlobalAccessLevels, new Tooltip("Глобальные уровни доступа"));
            //Добавляем всплывающий текст к кнопке Должности
            Tooltip.install(toggleButtonPositions, new Tooltip("Должности"));
            //Добавляем всплывающий текст к кнопке Организации
            Tooltip.install(toggleButtonOrganizations, new Tooltip("Организации"));
            //Добавляем всплывающий текст к кнопке Man
            Tooltip.install(toggleButtonMan, new Tooltip("Человек"));
            //Добавляем всплывающий текст к кнопке Woman
            Tooltip.install(toggleButtonWoman, new Tooltip("Человек"));
            //Добавляем всплывающий текст к кнопке Карта
            Tooltip.install(toggleButtonCard, new Tooltip("Карта доступа"));
            //Добавляем всплывающий текст к кнопке макет карты
            Tooltip.install(toggleButtonCardLayout, new Tooltip("Макет карты"));
            //Добавляем всплывающий текст к кнопке глобальные уровни доступа
            Tooltip.install(toggleButtonGlobalAccessLevel, new Tooltip("Глобальный уровень доступа"));
            //Добавляем всплывающий текст к кнопке должности
            Tooltip.install(toggleButtonPosition, new Tooltip("Должность"));
            //Добавляем всплывающий текст к кнопке организации
            Tooltip.install(toggleButtonOrganization, new Tooltip("Организация"));
            //Добавляем всплывающий текст к кнопке отдел
            Tooltip.install(toggleButtonOffice, new Tooltip("Отдел"));
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

            //Добавляем реакции на нажатие корня дерева правой кнопкой мыши
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
                                    cardReaderContainer.start(stage);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case BUREAU:
                                item = selectedItem;
                                try {
                                    bureauContainer.start(stage);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case USERS:
                            case ADMINS:
                            case OPERATORS:
                                item = selectedItem;
                                try {
                                    usersContainer.start(stage);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case CARDS:
                                item = selectedItem;
                                try {
                                    cardsContainer.start(stage);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case CARD_LAYOUTS:
                                item = selectedItem;
                                try {
                                    cardLayoutsContainer.start(stage);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case GLOBAL_ACCESS_LEVELS:
                                item = selectedItem;
                                try {
                                    globalAccessLevelsContainer.start(stage);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case POSITIONS:
                                item = selectedItem;
                                try {
                                    positionsContainer.start(stage);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case ORGANIZATIONS:
                                item = selectedItem;
                                try {
                                    organizationsContainer.start(stage);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case ORGANIZATION:
                                item = selectedItem;
                                try {
                                    organizationContainer.start(stage);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                break;
                            case COMPUTER:
                                item = selectedItem;
                                try {
                                    computerContainer.start(stage);
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
                            case MAINSYSTEM:
                                break;
                            default: System.out.println("Deleted item: " + selectedItem.getValue().getDirection());
                                     selectedItem.getParent().getChildren().remove(selectedItem);
                        }
                    });
                    //Проверяем что была нажата левая кнопка мыши
                } else if (selectedItem != null && event.getButton() == MouseButton.PRIMARY) {
                    TreeItem<Global> selectedItem1 = (TreeItem<Global>) root.getSelectionModel().getSelectedItem();
                    //Получим enum выбранного элемента
                    Direction value = selectedItem1.getValue().getDirection();
                    switch (value) {
                        case MAINSYSTEM:
                            try {
                                boxesController.start(stage);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            paneMainSystem.getChildren().add(boxesController.scene.getRoot());
                            windowObjects.getChildren().clear();
                            windowObjects.getChildren().add(paneMainSystem);
                            break;
                        case SERVER:
                            windowObjects.getChildren().clear();
                            break;
                        default:
                            System.out.println("Selected item: " + value);
                    }
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
        } else if (toggleButtonUsers.isSelected()) {
            TreeItem users = new TreeItem<Global>(new Users());
            ImageView imageViewUsers = new ImageView(imageUsers);
            imageViewUsers.setFitWidth(25);
            imageViewUsers.setFitHeight(25);
            users.setGraphic(imageViewUsers);
            item.getChildren().add(users);
        } else if (toggleButtonAdmins.isSelected()) {
            TreeItem admins = new TreeItem<Global>(new Administrators());
            ImageView imageViewAdmins = new ImageView(imageAdmins);
            imageViewAdmins.setFitWidth(25);
            imageViewAdmins.setFitHeight(25);
            admins.setGraphic(imageViewAdmins);
            item.getChildren().add(admins);
        } else if (toggleButtonOperators.isSelected()) {
            TreeItem operators = new TreeItem<Global>(new Operators());
            ImageView imageViewOperators = new ImageView(imageOperators);
            imageViewOperators.setFitWidth(25);
            imageViewOperators.setFitHeight(25);
            operators.setGraphic(imageViewOperators);
            item.getChildren().add(operators);
        } else if (toggleButtonCards.isSelected()) {
            TreeItem cards = new TreeItem<Global>(new Cards());
            ImageView imageViewCards = new ImageView(imageCards);
            imageViewCards.setFitWidth(25);
            imageViewCards.setFitHeight(25);
            cards.setGraphic(imageViewCards);
            item.getChildren().add(cards);
        } else if (toggleButtonCardLayouts.isSelected()) {
            TreeItem cardLayouts = new TreeItem<Global>(new CardLayouts());
            ImageView imageViewCardLayouts = new ImageView(imageCardLayouts);
            imageViewCardLayouts.setFitWidth(25);
            imageViewCardLayouts.setFitHeight(25);
            cardLayouts.setGraphic(imageViewCardLayouts);
            item.getChildren().add(cardLayouts);
        } else if (toggleButtonGlobalAccessLevels.isSelected()) {
            TreeItem globalAccessLevels = new TreeItem<Global>(new GlobalAccessLevels());
            ImageView imageViewGlobalAccesslevels = new ImageView(imageGlobalAccessLevels);
            imageViewGlobalAccesslevels.setFitWidth(25);
            imageViewGlobalAccesslevels.setFitHeight(25);
            globalAccessLevels.setGraphic(imageViewGlobalAccesslevels);
            item.getChildren().add(globalAccessLevels);
        } else if (toggleButtonPositions.isSelected()) {
            TreeItem positions = new TreeItem<Global>(new Positions());
            ImageView imageViewPositions = new ImageView(imagePositions);
            imageViewPositions.setFitWidth(25);
            imageViewPositions.setFitHeight(25);
            positions.setGraphic(imageViewPositions);
            item.getChildren().add(positions);
        } else if (toggleButtonOrganizations.isSelected()) {
            TreeItem organizations = new TreeItem<Global> (new Organizations());
            ImageView imageViewOrganizations = new ImageView(imageOrganizations);
            imageViewOrganizations.setFitWidth(25);
            imageViewOrganizations.setFitHeight(25);
            organizations.setGraphic(imageViewOrganizations);
            item.getChildren().add(organizations);
        } else if (toggleButtonMan.isSelected()) {
            TreeItem man = new TreeItem<Global> (new Man());
            ImageView imageViewMan = new ImageView(imageMan);
            imageViewMan.setFitWidth(25);
            imageViewMan.setFitHeight(25);
            man.setGraphic(imageViewMan);
            item.getChildren().add(man);
        } else if (toggleButtonWoman.isSelected()) {
            TreeItem woman = new TreeItem<Global> (new Woman());
            ImageView imageViewWoman = new ImageView(imageWoman);
            imageViewWoman.setFitWidth(25);
            imageViewWoman.setFitHeight(25);
            woman.setGraphic(imageViewWoman);
            item.getChildren().add(woman);
        } else if (toggleButtonCard.isSelected()) {
            TreeItem card = new TreeItem<Global> (new Card());
            ImageView imageViewCard = new ImageView(imageCard);
            imageViewCard.setFitWidth(25);
            imageViewCard.setFitHeight(25);
            card.setGraphic(imageViewCard);
            item.getChildren().add(card);
        } else if (toggleButtonCardLayout.isSelected()) {
            TreeItem cardLayout = new TreeItem<Global> (new CardLayout());
            ImageView imageViewCardLayout = new ImageView(imageCardLayout);
            imageViewCardLayout.setFitWidth(25);
            imageViewCardLayout.setFitHeight(25);
            cardLayout.setGraphic(imageViewCardLayout);
            item.getChildren().add(cardLayout);
        } else if (toggleButtonGlobalAccessLevel.isSelected()) {
            TreeItem globalAccessLevel = new TreeItem<Global> (new GlobalAccessLevel());
            ImageView imageViewGlobalAccessLevel = new ImageView(imageGlobalAccessLevel);
            imageViewGlobalAccessLevel.setFitWidth(25);
            imageViewGlobalAccessLevel.setFitHeight(25);
            globalAccessLevel.setGraphic(imageViewGlobalAccessLevel);
            item.getChildren().add(globalAccessLevel);
        } else if (toggleButtonPosition.isSelected()) {
            TreeItem position = new TreeItem<Global> (new Position());
            ImageView imageViewPosition = new ImageView(imagePosition);
            imageViewPosition.setFitWidth(25);
            imageViewPosition.setFitHeight(25);
            position.setGraphic(imageViewPosition);
            item.getChildren().add(position);
        } else if (toggleButtonOrganization.isSelected()) {
            TreeItem organization = new TreeItem<Global> (new Organization());
            ImageView imageViewOrganization = new ImageView(imageOrganization);
            imageViewOrganization.setFitWidth(25);
            imageViewOrganization.setFitHeight(25);
            organization.setGraphic(imageViewOrganization);
            item.getChildren().add(organization);
        } else if (toggleButtonOffice.isSelected()) {
            TreeItem office = new TreeItem<Global> (new Office());
            ImageView imageViewOffice = new ImageView(imageOffice);
            imageViewOffice.setFitWidth(25);
            imageViewOffice.setFitHeight(25);
            office.setGraphic(imageViewOffice);
            item.getChildren().add(office);
        } else if (toggleButtonConsole.isSelected()) {
            TreeItem console = new TreeItem<Global> (new Console());
            ImageView imageViewConsole = new ImageView(imageConsole);
            imageViewConsole.setFitWidth(25);
            imageViewConsole.setFitHeight(25);
            console.setGraphic(imageViewConsole);
            item.getChildren().add(console);
        }
        else {
            System.out.println("NE VYBRAN OBJECT");
        }
        //Сортируем элементы дерева после необходимых итераций
        item.getChildren().sort(Comparator.comparing(t->t.getValue().toString()));
    }
}