package alrosa.staa.gatekeeper.objects.mainsystem;

import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.global.Global;

public class MainSystem extends Global {
    private String complete_name;
    private final Direction direction = Direction.MAINSYSTEM;
    public MainSystem(String complete_name) {
        this.complete_name = complete_name;
    }
    public MainSystem() {
        this.complete_name = "Главный";
    }
    @Override
    public String getComplete_name() {
        return this.complete_name;
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
