package proxy.tcp.kryonet;

import com.esotericsoftware.kryonet.Client;

public class KryonetTCPClient implements proxy.common.Client {
    private final Client client;

    public KryonetTCPClient(Client client) {
        this.client = client;
    }

    @Override
    public void send(Object object) {
        client.sendTCP(object);
    }
}
