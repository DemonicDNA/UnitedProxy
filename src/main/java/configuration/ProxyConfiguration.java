package configuration;

public class ProxyConfiguration {

    private ProxyIncomingConfiguration incoming;
    private ProxyOutgoingConfiguration outgoing;

    public ProxyIncomingConfiguration getIncoming() {
        return incoming;
    }

    public void setIncoming(ProxyIncomingConfiguration incoming) {
        this.incoming = incoming;
    }

    public ProxyOutgoingConfiguration getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(ProxyOutgoingConfiguration outgoing) {
        this.outgoing = outgoing;
    }
}
