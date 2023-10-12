package alrosa.staa.gatekeeper.objects.bureau.card_layouts;

import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.bureau.Bureau;

public class CardLayouts extends Bureau {
    private String complete_name;
    private final Direction direction = Direction.CARD_LAYOUTS;

    public CardLayouts() {
        this.complete_name = "Макеты карт";
    }
    public CardLayouts(String complete_name) {
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
        return direction;
    }

    @Override
    public String toString() {
        return getComplete_name();
    }
}
