package alrosa.staa.gatekeeper.objects.server;

import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.server.Server;

public class CardReader extends Server {
    private String complete_name;
    private final Direction direction = Direction.CARDREADER;
    public CardReader() {
        this.complete_name = "Считыватель";
    }
    @Override
    public String getComplete_name() {
        return this.complete_name;
    }
    @Override
    public void setComplete_name(final String complete_name) {
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
