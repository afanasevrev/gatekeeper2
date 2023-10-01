package alrosa.staa.gatekeeper.objects;

import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Server extends Global {
    private String name;
    private String ipAddress;

    private Direction direction = Direction.SERVER;
    
    public Server() {
        this.name = "Сервер";
        this.ipAddress = "0.0.0.0";
    }
    public Server(String name) {
        this.name = name;
        this.ipAddress = "0.0.0.0";
    }
    public Server(String name, String ipAddress) {
        this.name = name;
        this.ipAddress = ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public String getIpAddress() {
        return ipAddress;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public Direction getDirection() {
        return this.direction;
    }
    @Override
    public String toString() {
        return getName();
    }
}
