package alrosa.staa.gatekeeper.objects.bureau.admins;

import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.bureau.Bureau;
import alrosa.staa.gatekeeper.objects.bureau.users.Users;

public class Administrators extends Bureau {
    private String complete_name;
    private final Direction direction = Direction.ADMINS;

    public Administrators() {
        this.complete_name = "Администраторы";
    }

    public Administrators(String complete_name) {
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
        return this.complete_name;
    }
}
