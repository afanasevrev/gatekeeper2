package alrosa.staa.gatekeeper.objects;

public class ControlPanel extends MainObject {
    private String name;
    private String ipAddress;
    private int port;
    public ControlPanel() {
        this.name = "Контроллер";
        this.ipAddress = "0.0.0.0";
        this.port = 8080;
    }
    public ControlPanel(String name) {
        this.name = name;
        this.ipAddress = "0.0.0.0";
        this.port = 8080;
    }
    public ControlPanel(String name, String ipAddress) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.port = 8080;
    }
    public ControlPanel(String name, String ipAddress, int port) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.port = port;
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

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return getName();
    }

}
