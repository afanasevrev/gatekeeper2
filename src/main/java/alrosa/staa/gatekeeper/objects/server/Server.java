package alrosa.staa.gatekeeper.objects.server;

import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.global.Global;

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
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
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
