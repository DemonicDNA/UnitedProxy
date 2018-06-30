import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import configuration.ProxyConfiguration;
import proxy.ProxyFactory;

import java.io.IOException;
import java.io.InputStream;

public class ApplicationStarter {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        ProxyConfiguration proxyConfiguration = new ProxyConfiguration();
        final InputStream configStream = ApplicationStarter.class.getResourceAsStream("/config.yml");
        try {
            proxyConfiguration = objectMapper.readValue(configStream, ProxyConfiguration.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.startProxy(proxyConfiguration);

    }

}
