package alrosa.staa.gatekeeper;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TreeView<String> root = new TreeView<String>();

    private ArrayList<TreeItem> objects = new ArrayList<TreeItem>();

    private TreeItem<String> mainSystem = new TreeItem<String>("Главный");
    private TreeItem<String> server = new TreeItem<String>("Сервер");
    private TreeItem<String> controller = new TreeItem<String>("Контроллер");

    public void setObject(String pic, TreeItem item) {
        Circle circle =new Circle(30);
        Image image = new Image(pic);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        imageView.setPreserveRatio(true);
        imageView.setClip(circle);

        item.setGraphic(imageView);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        objects.add(new TreeItem<String>("Сервер"));
        objects.add(new TreeItem<String>("Контроллер"));
        for (TreeItem item: objects) {
            setObject("main.png", item);
        }

      //  mainSystem.setGraphic(imageView);
      //  server.setGraphic(imageViewServer);
      //  controller.setGraphic(imageViewController);
      //  mainSystem.getChildren().add(server);
      //  server.getChildren().add(controller);

        root.setRoot(mainSystem);
    }
}