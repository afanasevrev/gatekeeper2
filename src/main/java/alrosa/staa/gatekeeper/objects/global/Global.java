package alrosa.staa.gatekeeper.objects.global;

import alrosa.staa.gatekeeper.objects.Direction;

public abstract class Global {
    private String name;

    public Global() {
        this.name = "Главный";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract Direction getDirection();

    @Override
    public String toString() {
        return getName();
    }
}
