import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.FrameworkMessage;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.Instrumentation;

public class TestMainServer {

    public static void main(String[] args) {
        Server server1 = new Server();
        server1.start();
        try {
            server1.bind(1991);
        } catch (IOException e) {
            e.printStackTrace();
        }
        server1.addListener(new Listener(){
            @Override
            public void received(Connection connection, Object object) {
                System.out.println(object);
            }
        });


        Server server2 = new Server();
        server2.start();
        try {
            server2.bind(1992);
        } catch (IOException e) {
            e.printStackTrace();
        }
        server2.addListener(new Listener(){
            @Override
            public void received(Connection connection, Object object) {
                if(!(object instanceof FrameworkMessage.KeepAlive)){
                    System.out.println(object);
                }
            }
        });
    }

}
