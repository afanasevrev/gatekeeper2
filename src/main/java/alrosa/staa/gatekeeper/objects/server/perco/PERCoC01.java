package alrosa.staa.gatekeeper.objects.server.perco;
import alrosa.staa.gatekeeper.objects.Direction;
public class PERCoC01 extends Perco {
    private String complete_name;
    private String ipAddress;
    private int port;
    private final Direction direction = Direction.PERCOC01;
    public PERCoC01() {
        this.complete_name = "Контроллер PERCo-C01";
        this.ipAddress = "0.0.0.0";
        this.port = 8080;
    }
    public PERCoC01(String complete_name) {
        this.complete_name = complete_name;
        this.ipAddress = "0.0.0.0";
        this.port = 8080;
    }
    public PERCoC01(String complete_name, String ipAddress) {
        this.complete_name = complete_name;
        this.ipAddress = ipAddress;
        this.port = 8080;
    }
    public PERCoC01(String complete_name, String ipAddress, int port) {
        this.complete_name = complete_name;
        this.ipAddress = ipAddress;
        this.port = port;
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
