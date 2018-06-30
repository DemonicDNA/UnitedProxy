package configuration;

import java.util.List;

public class ProxyOutgoingConfiguration {
    private Protocol protocol;
    private ProxyType type;
    private List<String> hosts;

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

    public List<String> getHosts() {
        return hosts;
    }

    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }
}
