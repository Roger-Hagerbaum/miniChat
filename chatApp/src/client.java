

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


class client {

    public void runClient(int port) throws IOException {
        try (Socket socket = new Socket("localhost", 88)) {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());


               dataOutputStream.writeUTF("Testing if message is delivered");
        }

           


    }

}