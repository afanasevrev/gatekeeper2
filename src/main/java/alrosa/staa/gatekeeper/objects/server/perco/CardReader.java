package alrosa.staa.gatekeeper.objects.server.perco;

import alrosa.staa.gatekeeper.objects.Direction;


public class CardReader extends PERCoC01 {
    private String name;
    private Direction direction = Direction.CARDREADER;

    public CardReader() {
        this.name = "Считыватель";
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
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
