package alrosa.staa.gatekeeper.objects.server.perco;

import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.server.Server;

public class Perco extends Server {
    private String name;
    private Direction direction = Direction.PERCO;

    public Perco() {
        this.name = "Оборудование Perco";
    }
    public Perco(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setName(final String name) {
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
