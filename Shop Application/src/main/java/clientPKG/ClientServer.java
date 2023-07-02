package clientPKG;

import java.io.*;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class ClientServer {

    private String host;
    private int port;
    SaveInfo saveInfo = new SaveInfo();

    Admin newAdmin;
    Customer newCustomer;

    public final DataInputStream dataInputStream;
    public final DataOutputStream dataOutputStream;
    public final ObjectOutputStream objectOutputStream;
    public final ObjectInputStream objectInputStream;
    Scanner scanner;
    Formatter formatter;


    Socket socket;

    public ClientServer(String host, int port){

        this.host = host;
        this.port = port;

        try {
            socket = new Socket(host, port);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(dataInputStream);
            objectOutputStream = new ObjectOutputStream(dataOutputStream);
            scanner = new Scanner(dataInputStream);
            formatter = new Formatter(dataOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        String command = null;
        while (command.equals("finish sending info")){
            command = scanner.next();
        while (command.equals("send admin info")){
            try {
                newAdmin = (Admin) objectInputStream.readObject();
                saveInfo.saveAdminInfo(newAdmin);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        while (command.equals("send customer info")){
            try {
                newCustomer = (Customer) objectInputStream.readObject();
                saveInfo.saveCustomerInfo(newCustomer);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        }
    }
}
