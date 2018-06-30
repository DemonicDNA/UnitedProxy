package configuration;

public class ProxyIncomingConfiguration {

    private Protocol protocol;
    private ProxyType type;
    //todo: build better configuration tree, might need to be in server
    private int port;

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public ProxyType getType() {
        return type;
    }

    public void setType(ProxyType type) {
        this.type = type;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
