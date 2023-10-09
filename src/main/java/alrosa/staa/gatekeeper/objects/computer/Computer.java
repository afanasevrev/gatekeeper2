package alrosa.staa.gatekeeper.objects.computer;

import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.global.Global;

public class Computer extends Global {
    private String complete_name;
    private String ipAddress;
    private final Direction direction = Direction.COMPUTER;
    public Computer() {
        this.complete_name = "Компьютер";
        this.ipAddress = "0.0.0.0";
    }
    public Computer(String complete_name) {
        this.complete_name = complete_name;
        this.ipAddress = "0.0.0.0";
    }
    public Computer(String complete_name,String ipAddress) {
        this.complete_name = complete_name;
        this.ipAddress = ipAddress;
    }
    @Override
    public String getComplete_name() {
        return this.complete_name;
    }
    @Override
    public void setComplete_name(String complete_name) {
        this.complete_name = complete_name;
    }
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
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
