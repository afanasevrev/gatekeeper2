package alrosa.staa.gatekeeper.objects.server;

import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.global.Global;

public class Server extends Global {
    private String complete_name;
    private String ipAddress;
    private final Direction direction = Direction.SERVER;
    public Server() {
        this.complete_name = "Сервер";
        this.ipAddress = "0.0.0.0";
    }
    public Server(String complete_name) {
        this.complete_name = complete_name;
        this.ipAddress = "0.0.0.0";
    }
    public Server(String complete_name, String ipAddress) {
        this.complete_name = complete_name;
        this.ipAddress = ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public String getIpAddress() {
        return ipAddress;
    }
    @Override
    public String getComplete_name() {
        return complete_name;
    }
    @Override
    public void setComplete_name(String complete_name) {
        this.complete_name = complete_name;
    }
    @Override
    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public String toString() {
        return getComplete_name();
    }
}
