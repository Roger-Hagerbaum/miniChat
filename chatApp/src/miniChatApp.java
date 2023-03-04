
import java.io.IOException;

public class miniChatApp {

    public static void main(String[] args) throws IOException {
        int port = 88; // TODO get from api
        server server = new server();

        server.startServer(port);

    }


}