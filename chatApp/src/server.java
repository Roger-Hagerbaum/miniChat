

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

 public class server {

     public void startServer (int port) throws IOException{
        
         try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket socket = serverSocket.accept();

                 InputStream inputStream = socket.getInputStream();
                 DataInputStream dataInputStream = new DataInputStream(inputStream);
                 
                 String message;
                // String userName; TODO implement varibel
                // String JWT; TODO implement varibel
                // String messageResived; TODO implement varibel
                 while (true){
                 try {
                     message = dataInputStream.readUTF();
                 } catch (IOException e) {
                     throw new RuntimeException(e);
                 }

                System.out.println("Message Resived: " + message);
             }
        }
         }
         
     
     
 }
 
