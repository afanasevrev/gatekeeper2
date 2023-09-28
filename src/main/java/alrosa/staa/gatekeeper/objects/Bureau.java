package alrosa.staa.gatekeeper.objects;

public class Bureau extends MainObject {
    private String name;

    public Bureau() {
        this.name = "Бюро";
    }
    public Bureau(String name) {
        this.name = name;
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
