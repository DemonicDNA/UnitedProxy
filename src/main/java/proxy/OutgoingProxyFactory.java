package proxy;

import configuration.ProxyOutgoingConfiguration;
import proxy.common.Client;
import proxy.creators.ClientCreator;
import proxy.tcp.TCPClientCreator;

import java.util.List;
import java.util.Optional;

public class OutgoingProxyFactory {
    private final ProxyOutgoingConfiguration outgoingConfiguration;
    private ClientCreator TCPClientCreator = new TCPClientCreator();

    public OutgoingProxyFactory(ProxyOutgoingConfiguration outgoingConfiguration) {
        this.outgoingConfiguration = outgoingConfiguration;
    }

    public Optional<List<Client>> createClients() {
        switch (outgoingConfiguration.getProtocol()){
            case tcp:
                switch (outgoingConfiguration.getType()){
                    case client:
                        return TCPClientCreator.create(outgoingConfiguration.getHosts());

                }
        }
        return Optional.empty();
    }
}
