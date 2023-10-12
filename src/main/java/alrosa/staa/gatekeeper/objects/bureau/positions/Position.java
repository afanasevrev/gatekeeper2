package alrosa.staa.gatekeeper.objects.bureau.positions;

import alrosa.staa.gatekeeper.objects.Direction;

public class Position extends Positions {
    private String complete_name;
    private final Direction direction = Direction.POSITION;

    public Position() {
        this.complete_name = "Должность";
    }

    public Position(String complete_name) {
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
