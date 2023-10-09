package alrosa.staa.gatekeeper.objects.bureau;

import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.global.Global;

public class Bureau extends Global {
    private String complete_name;
    private final Direction direction = Direction.BUREAU;

    public Bureau() {
        this.complete_name = "Бюро";
    }
    public Bureau(String complete_name) {
        this.complete_name = complete_name;
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
