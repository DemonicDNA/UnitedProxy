package proxy;

import configuration.ProxyConfiguration;
import configuration.ProxyIncomingConfiguration;
import configuration.ProxyOutgoingConfiguration;
import proxy.common.Client;
import proxy.common.Listener;
import proxy.common.Server;
import proxy.creators.ServerCreator;
import proxy.tcp.TCPServerCreator;
import proxy.tcp.kryonet.KryonetTCPListener;

import java.util.List;
import java.util.Optional;

/* todo: map: 1) between incoming and outgoing type to handler of those types
   todo:      2) between incoming protocol and outgoing protocol to the creator of that type's protocol
*/
public class ProxyFactory {

    private ServerCreator serverCreator = new TCPServerCreator();

    public void startProxy(ProxyConfiguration proxyConfiguration) {
        final ProxyIncomingConfiguration incomingConfiguration = proxyConfiguration.getIncoming();
        final ProxyOutgoingConfiguration outgoingConfiguration = proxyConfiguration.getOutgoing();
        final OutgoingProxyFactory outgoingProxyFactory = new OutgoingProxyFactory(outgoingConfiguration);

        switch (incomingConfiguration.getType()) {
            case server:
                switch (incomingConfiguration.getProtocol()) {
                    case tcp:
                        final Server server = serverCreator.createServer(incomingConfiguration.getPort());
                        switch (outgoingConfiguration.getType()) {
                            case client:
                                final Optional<List<Client>> clientsOptional =
                                        outgoingProxyFactory.createClients();
                                if (clientsOptional.isPresent()) {
                                    final List<Client> clientList = clientsOptional.get();
                                    Listener listener = new KryonetTCPListener(
                                            object ->
                                                    clientList.forEach(client ->
                                                            client.send(object)));
                                    server.addListener(listener);
                                }
                                break;

                            case server:
                                //todo: incoming is server, outgoing is server
                                break;

                        }
                        break;
                }
                break;
            case client:
                //todo: incoming is client, outgoing might be both
                break;
        }

        System.out.println("Proxy started");

    }
}
