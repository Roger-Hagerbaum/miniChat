import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class client {

    public void runClient(int port , String connectingUser, String user,String jwt) throws IOException, InterruptedException {
        post post = new post();
        Socket socket;
        DataInputStream dataInput = null;
        DataOutputStream dataOutputStream = null;
        String messageSent;
        boolean tryToConnect = true;
        boolean endProgram = true;
        System.out.println("waiting form " + connectingUser);
        while (tryToConnect){
            long millis = System.currentTimeMillis();
        try {

            socket = new Socket("localhost", port);
            tryToConnect = false;
            socket.setKeepAlive(true);
            dataInput = new DataInputStream(System.in);
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {

        }
            Thread.sleep(1000 - millis % 1000);
    }
        assert dataOutputStream != null;

        while (endProgram){
            String userMessage;
            Scanner scanner = new Scanner(dataInput);
            System.out.println("Enter message");
            System.out.println("To end the program type exit");
            userMessage = scanner.nextLine();
            if(userMessage.equals("exit")){
                messageSent = user + ";;" + userMessage + ";;" + jwt;
                dataOutputStream.writeUTF(messageSent);
                endProgram = false;
                post.endSpring(user,jwt);
                System.exit(0);
            }
            messageSent = user + ";;" + userMessage + ";;" + jwt;
            dataOutputStream.writeUTF(messageSent);


        }


    }
}