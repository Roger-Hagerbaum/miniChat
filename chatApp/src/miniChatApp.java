
import java.io.IOException;

public class miniChatApp {

    public static void main(String[] args) throws IOException {
        int portServer = 77; // TODO get from api
        int portClient = 77; // TODO get from  api
        String user = "Test1"; // TODO get from api and implement
        server server = new server();
        client client = new client();
        server.startServer(portServer);
        client.runClient(portClient , user);
    }

}