package proxy.tcp.kryonet;

import com.esotericsoftware.kryonet.Server;
import proxy.common.Listener;

public class KryonetTCPServer implements proxy.common.Server {

    private final Server server;

    public KryonetTCPServer(Server server) {
        this.server = server;
    }

    @Override
    public void addListener(Listener listener) {
        if(listener instanceof KryonetTCPListener)
            server.addListener(((KryonetTCPListener) listener).getListener());
    }
}
