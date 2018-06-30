package proxy.tcp.kryonet;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import java.util.function.Consumer;

public class KryonetTCPListener implements proxy.common.Listener {

    private final Listener listener;

    public KryonetTCPListener(Consumer<Object> consumer) {
        this.listener = new com.esotericsoftware.kryonet.Listener() {
            public void received(Connection connection, Object object) {
                consumer.accept(object);
            }
        };
    }

    Listener getListener() {
        return listener;
    }
}
