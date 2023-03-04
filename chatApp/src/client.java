

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


class client {

    public void runClient(int port , String user) throws IOException, InterruptedException {
        Socket socket;
        DataInputStream dataInput = null;
        DataOutputStream dataOutputStream = null;
        String messageSent;
        boolean tryToConnect = true;
        while (tryToConnect){
            long millis = System.currentTimeMillis();
        try {

            socket = new Socket("localhost", port);
            tryToConnect = false;
            socket.setKeepAlive(true);
            dataInput = new DataInputStream(System.in);
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Could not connect on port");
        }
            Thread.sleep(1000 - millis % 1000);
    }
        assert dataOutputStream != null;

        while (true){

            Scanner scanner = new Scanner(dataInput);
            System.out.println("Enter message");
            String userMessage = scanner.nextLine();
            messageSent = user + "," + userMessage;
            dataOutputStream.writeUTF(messageSent);
        }


    }
}