package alrosa.staa.gatekeeper.objects;

public class Server {
    private String ipAddress;

    public Server(){}

    public Server(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

}
