package alrosa.staa.gatekeeper;

import alrosa.staa.gatekeeper.containers.*;
import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.global.Global;
import alrosa.staa.gatekeeper.objects.mainsystem.MainSystem;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    //Добавляем статический объект дерева
    private static TreeItem<Global> item;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

        anchorPaneForItems.getChildren().addAll(root);
        imageViewMain.setFitWidth(25);
        imageViewMain.setFitHeight(25);
        mainSystem.setGraphic(imageViewMain);

        //В контекстное меню добавляем кнопки
        contextMenu.getItems().addAll(menuAdd, menuDelete);
        //В наше дерево добавляем контекстное меню
        root.setContextMenu(contextMenu);
    }
    private void addItem(TreeItem treeItem, Image image) {
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(25);
        imageView.setFitWidth(25);
        treeItem.setGraphic(imageView);
        item.getChildren().add(treeItem);
    }
}
