package alrosa.staa.gatekeeper.objects.bureau.organizations;

import alrosa.staa.gatekeeper.objects.Direction;

public class Organization extends Organizations {
    private String complete_name;
    private final Direction direction = Direction.ORGANIZATION;

    public Organization() {
        this.complete_name = "Организация";
    }

    public Organization(String complete_name) {
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
