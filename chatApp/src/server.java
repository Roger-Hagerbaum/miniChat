import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

 public class server {
     post post = new post();
    public void startServer (int port,String clientUser) throws IOException{
        Thread ServerThread1 = new Thread(() -> {

            try (ServerSocket serverSocket = new ServerSocket(port)) {
                Socket socket = serverSocket.accept();

                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);

                String message;
                String userName;
                String messageResived;
                // String JWT; TODO implement varibel
                
                while (true){
                    try {
                        message = dataInputStream.readUTF();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    String[] split = message.split(";;");
                    userName = split[0];
                    messageResived = split[1];
                    if(post.userLoggedIn(clientUser) == true){
                        System.out.println("Message from user: "+ userName + " " + messageResived);
                    }else {
                        System.out.println("The user was not logged in");
                    }


                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        ServerThread1.start();
    }
    }
 
