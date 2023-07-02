package clientPKG;

import java.io.IOException;
import java.net.Socket;

public class ClientServer {

    private String host;

    private int port;





    Socket socket = null;

    public ClientServer(String host, int port){

        this.host = host;
        this.port = port;

        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
