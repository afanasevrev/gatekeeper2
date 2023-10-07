package alrosa.staa.gatekeeper.objects.bureau.users;

import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.bureau.Bureau;

public class Users extends Bureau {
    private String name;
    private Direction direction = Direction.USERS;

    public Users() {
        this.name = "Пользователи";
    }
    public Users(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
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
