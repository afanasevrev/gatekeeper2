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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class AlternativeController implements Initializable {
    //Кнопка добавить
    @FXML
    private Button buttonCreate = new Button();
    //Кнопка отменить
    @FXML
    private Button buttonCancel = new Button();
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
    //Кнопка для выбора сервера
    @FXML
    private ToggleButton toggleButtonServer = new ToggleButton();
    //Кнопка для выбора компьютера
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
    //Кнопка для выбора карт
    @FXML
    private ToggleButton toggleButtonCards = new ToggleButton();
    //Кнопка для выбора макетов карт
    @FXML
    private ToggleButton toggleButtonCardLayouts = new ToggleButton();
    //Кнопка для выбора глобальных уровней доступа
    @FXML
    private ToggleButton toggleButtonGlobalAccessLevels = new ToggleButton();
    //Кнопка для выбора должностей
    @FXML
    private ToggleButton toggleButtonPositions = new ToggleButton();
    //Кнопка для выбора организаций
    @FXML
    private ToggleButton toggleButtonOrganizations = new ToggleButton();
    //Кнопка для выбора людей мужского пола
    @FXML
    private ToggleButton toggleButtonMan = new ToggleButton();
    //Кнопка для выбора людей женского пола
    @FXML
    private ToggleButton toggleButtonWoman = new ToggleButton();
    //Кнопка для выбора карты
    @FXML
    private ToggleButton toggleButtonCard = new ToggleButton();
    //Кнопка для выбора макета карты
    @FXML
    private ToggleButton toggleButtonCardLayout = new ToggleButton();
    //Кнопка для выбора глобального уровня доступа
    @FXML
    private ToggleButton toggleButtonGlobalAccessLevel = new ToggleButton();
    //Кнопка для выбора должности
    @FXML
    private ToggleButton toggleButtonPosition = new ToggleButton();
    //Кнопка для выбора организации
    @FXML
    private ToggleButton toggleButtonOrganization = new ToggleButton();
    //Кнопка для выбора отдела
    @FXML
    private ToggleButton toggleButtonOffice = new ToggleButton();
    //Кнопка для выбора консоли
    @FXML
    private ToggleButton toggleButtonConsole = new ToggleButton();
    //Указываем путь к рисунку главного дерева в системе
    private Image imageMain = new Image("main.png");

    //Создаем ImageView для рисунка main.png
    private ImageView imageViewMain = new ImageView(imageMain);
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
    //Главный объект на дереве
    private TreeItem<Global> mainSystem = new TreeItem<>(new MainSystem());
    //Дерево
    private TreeView root = new TreeView(mainSystem);
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
    //Добавляем сцену
    private Stage stage = new Stage();
    /*
    Добавляем статический объект дерева - переменная, в которой будет размещаться
    выбранный объект в дереве
    */
    private static TreeItem<Global> item;

    //Создаем экземпляр BoxesController
    private BoxesController boxesController;
    private AnchorPane pane = new AnchorPane();
    @FXML
    private TextField textField = new TextField();
    @FXML
    private VBox vbox = new VBox();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Прикрепляем главное окно
        //AnchorPane.setLeftAnchor(pane, 0.0);
        //AnchorPane.setBottomAnchor(pane, 0.0);
        //AnchorPane.setRightAnchor(pane, 0.0);
        //AnchorPane.setTopAnchor(pane, 0.0);
        //Прикрепляем дерево к окну так, чтобы он растягивался вместе с ним
        AnchorPane.setLeftAnchor(root, 0.0);
        AnchorPane.setBottomAnchor(root, 0.0);
        AnchorPane.setRightAnchor(root, 0.0);
        AnchorPane.setTopAnchor(root, 0.0);
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

        anchorPaneForItems.getChildren().addAll(root);
        imageViewMain.setFitWidth(25);
        imageViewMain.setFitHeight(25);
        mainSystem.setGraphic(imageViewMain);

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
                    item = selectedItem;
                    switch (value) {
                        case MAINSYSTEM:
                            try {
                                mainContainer.start(stage);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case SERVER:
                            try {
                                serverContainer.start(stage);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case PERCO:
                            try {
                                percoContainer.start(stage);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case PERCOC01:
                            try {
                                cardReaderContainer.start(stage);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case BUREAU:
                            try {
                                bureauContainer.start(stage);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case USERS:
                        case ADMINS:
                        case OPERATORS:
                            try {
                                usersContainer.start(stage);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case CARDS:
                            try {
                                cardsContainer.start(stage);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case CARD_LAYOUTS:
                            try {
                                cardLayoutsContainer.start(stage);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case GLOBAL_ACCESS_LEVELS:
                            try {
                                globalAccessLevelsContainer.start(stage);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case POSITIONS:
                            try {
                                positionsContainer.start(stage);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case ORGANIZATIONS:
                            try {
                                organizationsContainer.start(stage);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case ORGANIZATION:
                            try {
                                organizationContainer.start(stage);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case COMPUTER:
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
                        default: selectedItem.getParent().getChildren().remove(selectedItem);
                    }
                });
                //Проверяем что была нажата левая кнопка мыши
            } else if (selectedItem != null && event.getButton() == MouseButton.PRIMARY) {
                TreeItem<Global> selectedItem1 = (TreeItem<Global>) root.getSelectionModel().getSelectedItem();
                //Получим enum выбранного элемента
                Direction value = selectedItem1.getValue().getDirection();
                switch (value) {
                    case MAINSYSTEM:
                        boxesController = new BoxesController();

                        pane.getChildren().addAll(boxesController.loader);

                        vbox.getChildren().clear();
                        vbox.getChildren().add(pane);
                        break;
                    case SERVER:
                        vbox.getChildren().clear();
                        break;
                    default:
                        System.out.println("Selected item: " + value);
                }
            }
        });
    }
    //Метод для добавления объекта в дерево системы
    private void addItem(TreeItem treeItem, Image image) {
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(25);
        imageView.setFitWidth(25);
        treeItem.setGraphic(imageView);
        item.getChildren().add(treeItem);
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
            addItem(server, imageServer);
        } else if (toggleButtonComputer.isSelected()) {
            TreeItem computer = new TreeItem<Global>(new Computer());
            addItem(computer, imageComputer);
        } else if (toggleButtonBureau.isSelected()) {
            TreeItem bureau = new TreeItem<Global>(new Bureau());
            addItem(bureau, imageBureau);
        } else if (toggleButtonPerco.isSelected()) {
            TreeItem perco = new TreeItem<Global>(new Perco());
            addItem(perco, imagePerco);
        } else if (toggleButtonPERCoC01.isSelected()) {
            TreeItem percoc01 = new TreeItem<Global>(new PERCoC01());
            addItem(percoc01, imagePERCoC01);
        } else if (toggleButtonCardReader.isSelected()) {
            TreeItem cardReader = new TreeItem<Global>(new CardReader());
            addItem(cardReader, imageCardReader);
        } else if (toggleButtonUsers.isSelected()) {
            TreeItem users = new TreeItem<Global>(new Users());
            addItem(users, imageUsers);
        } else if (toggleButtonAdmins.isSelected()) {
            TreeItem admins = new TreeItem<Global>(new Administrators());
            addItem(admins, imageAdmins);
        } else if (toggleButtonOperators.isSelected()) {
            TreeItem operators = new TreeItem<Global>(new Operators());
            addItem(operators, imageOperators);
        } else if (toggleButtonCards.isSelected()) {
            TreeItem cards = new TreeItem<Global>(new Cards());
            addItem(cards, imageCards);
        } else if (toggleButtonCardLayouts.isSelected()) {
            TreeItem cardLayouts = new TreeItem<Global>(new CardLayouts());
            addItem(cardLayouts, imageCardLayouts);
        } else if (toggleButtonGlobalAccessLevels.isSelected()) {
            TreeItem globalAccessLevels = new TreeItem<Global>(new GlobalAccessLevels());
            addItem(globalAccessLevels, imageGlobalAccessLevels);
        } else if (toggleButtonPositions.isSelected()) {
            TreeItem positions = new TreeItem<Global>(new Positions());
            addItem(positions, imagePositions);
        } else if (toggleButtonOrganizations.isSelected()) {
            TreeItem organizations = new TreeItem<Global> (new Organizations());
            addItem(organizations, imageOrganizations);
        } else if (toggleButtonMan.isSelected()) {
            TreeItem man = new TreeItem<Global> (new Man());
            addItem(man, imageMan);
        } else if (toggleButtonWoman.isSelected()) {
            TreeItem woman = new TreeItem<Global> (new Woman());
            addItem(woman, imageWoman);
        } else if (toggleButtonCard.isSelected()) {
            TreeItem card = new TreeItem<Global> (new Card());
            addItem(card, imageCard);
        } else if (toggleButtonCardLayout.isSelected()) {
            TreeItem cardLayout = new TreeItem<Global> (new CardLayout());
            addItem(cardLayout, imageCardLayout);
        } else if (toggleButtonGlobalAccessLevel.isSelected()) {
            TreeItem globalAccessLevel = new TreeItem<Global> (new GlobalAccessLevel());
            addItem(globalAccessLevel, imageGlobalAccessLevel);
        } else if (toggleButtonPosition.isSelected()) {
            TreeItem position = new TreeItem<Global> (new Position());
            addItem(position, imagePosition);
        } else if (toggleButtonOrganization.isSelected()) {
            TreeItem organization = new TreeItem<Global> (new Organization());
            addItem(organization, imageOrganization);
        } else if (toggleButtonOffice.isSelected()) {
            TreeItem office = new TreeItem<Global> (new Office());
            addItem(office, imageOffice);
        } else if (toggleButtonConsole.isSelected()) {
            TreeItem console = new TreeItem<Global> (new Console());
            addItem(console, imageConsole);
        }
        else {
            System.out.println("NO OBJECT SELECTED");
        }
        //Сортируем элементы дерева после необходимых итераций
        item.getChildren().sort(Comparator.comparing(t->t.getValue().toString()));
    }
}
