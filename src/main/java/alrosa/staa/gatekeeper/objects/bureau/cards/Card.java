package alrosa.staa.gatekeeper.objects.bureau.cards;

import alrosa.staa.gatekeeper.objects.Direction;

public class Card extends Cards {
    private String complete_name;
    private int card_number;
    private final Direction direction = Direction.CARD;

    public Card() {
        this.complete_name = "Карта доступа";
        this.card_number = 0;
    }

    public Card(String complete_name) {
        this.complete_name = complete_name;
        this.card_number = 0;
    }

    public Card(String complete_name, int card_number) {
        this.complete_name = complete_name;
        this.card_number = card_number;
    }

    @Override
    public String getComplete_name() {
        return this.complete_name;
    }

    @Override
    public void setComplete_name(String complete_name) {
        this.complete_name = complete_name;
    }

    public int getCard_number() {
        return this.card_number;
    }

    public void setCard_number(int card_number) {
        this.card_number = card_number;
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
