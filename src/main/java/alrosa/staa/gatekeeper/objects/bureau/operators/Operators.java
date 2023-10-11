package alrosa.staa.gatekeeper.objects.bureau.operators;

import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.bureau.Bureau;

public class Operators extends Bureau {
    private String complete_name;
    private final Direction direction = Direction.OPERATORS;

    public Operators() {
        this.complete_name = "Операторы";
    }

    public Operators(String complete_name) {
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
        return complete_name;
    }
}
