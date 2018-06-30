package proxy.creators;
import proxy.common.Server;

public interface ServerCreator {

    Server createServer(int port);

}
