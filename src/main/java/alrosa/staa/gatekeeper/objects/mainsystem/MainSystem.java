package alrosa.staa.gatekeeper.objects.mainsystem;

import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.global.Global;

public class MainSystem extends Global {
    private String name;
    private Direction direction = Direction.MAINSYSTEM;
    public MainSystem(String name) {
        this.name = name;
    }
    public MainSystem() {
        this.name = "Главный";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
