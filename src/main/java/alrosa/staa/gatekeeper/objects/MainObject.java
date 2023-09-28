package alrosa.staa.gatekeeper.objects;

public abstract class MainObject {
    private String name;

    public MainObject(String name) {
        this.name = name;
    }

    public MainObject() {
        this.name = "Главный";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
