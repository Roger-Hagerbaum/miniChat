

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


class client {

    public void runClient(int port , String user) throws IOException {
        try (Socket socket = new Socket("localhost", port)) {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                // TODO implement username
               dataOutputStream.writeUTF("Testing if message is delivered");
        }

           


    }

}