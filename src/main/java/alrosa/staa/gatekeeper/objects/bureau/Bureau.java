package alrosa.staa.gatekeeper.objects.bureau;

import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.global.Global;

public class Bureau extends Global {
    private String name;
    private Direction direction = Direction.BUREAU;

    public Bureau() {
        this.name = "Бюро";
    }
    public Bureau(String name) {
        this.name = name;
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
