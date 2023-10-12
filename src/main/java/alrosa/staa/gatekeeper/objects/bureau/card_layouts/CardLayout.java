package alrosa.staa.gatekeeper.objects.bureau.card_layouts;

import alrosa.staa.gatekeeper.objects.Direction;

public class CardLayout extends CardLayouts {
    private String complete_name;
    private final Direction direction = Direction.CARD_LAYOUT;

    public CardLayout() {
        this.complete_name = "Макет карты";
    }

    public CardLayout(String complete_name) {
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
