package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Broker {

    public Broker(int port){

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true){
                Socket socket = serverSocket.accept();
            }
        } catch (IOException e) {
            //TODO: try to reconnect...
            throw new RuntimeException(e);
        }
    }
}
