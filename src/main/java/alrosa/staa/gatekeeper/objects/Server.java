package alrosa.staa.gatekeeper.objects;

public class Server extends MainObject {
    private String name;
    private String ipAddress;


    public Server() {
        this.name = "Сервер";
        this.ipAddress = "0.0.0.0";
    }

    public Server(String name) {
        this.name = name;
        this.ipAddress = "0.0.0.0";
    }

    public Server(String name, String ipAddress) {
        this.name = name;
        this.ipAddress = ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public String toString() {
        return name;
    }

}
