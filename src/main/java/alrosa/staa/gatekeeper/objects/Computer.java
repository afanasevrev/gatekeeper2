package alrosa.staa.gatekeeper.objects;

public class Computer extends MainObject {
    private String name;
    private String ipAddress;

    public Computer() {
        this.name = "Компьютер";
        this.ipAddress = "0.0.0.0";
    }
    public Computer(String name) {
        this.name = name;
        this.ipAddress = "0.0.0.0";
    }
    public Computer(String name,String ipAddress) {
        this.name = name;
        this.ipAddress = ipAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return getName();
    }
}
