package proxy.tcp;

import com.esotericsoftware.kryonet.Client;
import proxy.creators.ClientCreator;
import proxy.tcp.kryonet.KryonetTCPClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TCPClientCreator implements ClientCreator {

    public Optional<List<proxy.common.Client>> create(List<String> hosts) {
        List<proxy.common.Client> clientList = new ArrayList<>();
        hosts.forEach(host -> {
            Client client = new Client();
            client.start();
            try {
                final String[] split = host.split(":");
                client.connect(5000, split[0], Integer.parseInt(split[1]));
                clientList.add(new KryonetTCPClient(client));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        if(clientList.size() != hosts.size()){
            return Optional.empty();
        }
        return Optional.of(clientList);
    }
}
