package alrosa.staa.gatekeeper.objects.computer.console;

import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.computer.Computer;

public class Console extends Computer {
    private String complete_name;
    private final Direction direction = Direction.CONSOLE;
    public Console() {
        this.complete_name = "Консоль";
    }
    public Console(String complete_name) {
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
