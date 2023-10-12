package alrosa.staa.gatekeeper.objects.bureau.global_access_levels;

import alrosa.staa.gatekeeper.objects.Direction;
import alrosa.staa.gatekeeper.objects.bureau.Bureau;

public class GlobalAccessLevels extends Bureau {
    private String complete_name;
    private final Direction direction = Direction.GLOBAL_ACCESS_LEVELS;

    public GlobalAccessLevels() {
        this.complete_name = "Глобальные уровни доступа";
    }

    public GlobalAccessLevels(String complete_name) {
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
