package proxy.creators;

import proxy.common.Client;

import java.util.List;
import java.util.Optional;

public interface ClientCreator {

    public Optional<List<Client>> create(List<String> hosts);

}
