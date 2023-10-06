package alrosa.staa.gatekeeper.objects.server.perco;
import alrosa.staa.gatekeeper.objects.Direction;
public class PERCoC01 extends Perco {
    private String name;
    private String ipAddress;
    private int port;
    private Direction direction = Direction.PERCOC01;
    public PERCoC01() {
        this.name = "Контроллер PERCo-C01";
        this.ipAddress = "0.0.0.0";
        this.port = 8080;
    }
    public PERCoC01(String name) {
        this.name = name;
        this.ipAddress = "0.0.0.0";
        this.port = 8080;
    }
    public PERCoC01(String name, String ipAddress) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.port = 8080;
    }
    public PERCoC01(String name, String ipAddress, int port) {
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
    public Direction getDirection() {
        return this.direction;
    }
    @Override
    public String toString() {
        return getName();
    }
}
