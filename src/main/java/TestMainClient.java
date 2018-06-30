import com.esotericsoftware.kryonet.Client;

import java.io.IOException;

public class TestMainClient {

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
        try {
            client.connect(5000, "localhost", 1591);
            client.sendTCP("hello2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

