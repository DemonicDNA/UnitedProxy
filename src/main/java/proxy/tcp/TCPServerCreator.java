package proxy.tcp;

import com.esotericsoftware.kryonet.Server;
import proxy.tcp.kryonet.KryonetTCPServer;
import proxy.creators.ServerCreator;

import java.io.IOException;

public class TCPServerCreator implements ServerCreator {

    public proxy.common.Server createServer(int port) {
        Server server = new Server();
        server.start();
        try {
            server.bind(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new KryonetTCPServer(server);
    }
}
