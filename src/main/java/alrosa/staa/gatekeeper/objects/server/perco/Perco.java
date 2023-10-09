package alrosa.staa.gatekeeper.objects.server.perco;

import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.server.Server;

public class Perco extends Server {
    private String complete_name;
    private final Direction direction = Direction.PERCO;
    public Perco() {
        this.complete_name = "Оборудование Perco";
    }
    public Perco(String complete_name) {
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
