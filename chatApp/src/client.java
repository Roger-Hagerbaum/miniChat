

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


class client {

    public void runClient(int port) throws IOException {
        Socket socket;

        DataInputStream dataInput = null;
        DataOutputStream dataOutputStream = null;

        try {
            socket = new Socket("localhost", port);
            socket.setKeepAlive(true);
            dataInput = new DataInputStream(System.in);
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Could not connect on port");
        }

        assert dataOutputStream != null;

        while (true){

            Scanner scanner = new Scanner(dataInput);
            System.out.println("Enter message");
            String userMessage = scanner.nextLine();

            dataOutputStream.writeUTF(userMessage);
        }


    }
}